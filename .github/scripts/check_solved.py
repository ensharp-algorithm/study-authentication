import subprocess
import sys
import os
import json
import urllib.request
from datetime import datetime, timezone

# 1. 인자 및 환경변수 로드
hours_back = sys.argv[1]  # Actions에서 넘겨줄 시간 (48 또는 72)
webhook_url = os.environ.get("DISCORD_WEBHOOK")
target_count = 2
BAR_LENGTH = 5  # 프로그레스 바 칸 수

# 2. 지정된 시간 내에 '추가(A) 또는 수정(M)된' 소스코드 파일 목록 추출
cmd = f"git log --since='{hours_back} hours ago' --name-only --pretty=format: --diff-filter=AM"
result = subprocess.run(cmd, shell=True, capture_output=True, text=True)

# 지원하는 확장자 필터링
extensions = ('.java', '.py', '.cpp', '.c', '.js')
files = []
for f in result.stdout.split('\n'):
    clean_path = f.strip().strip('"')  # 양끝 공백과 큰따옴표 제거
    if clean_path and clean_path.endswith(extensions):
        files.append(clean_path)

# 3. 사용자별 풀이 수 계산 (같은 파일을 여러 커밋에 걸쳐 수정해도 1문제로만 집계)
user_files = {}
for file_path in files:
    user = file_path.split('/')[0]
    user_files.setdefault(user, set()).add(file_path)

user_counts = {user: len(paths) for user, paths in user_files.items()}

# 4. 전체 스터디원 목록 스캔 (최상위 폴더 기준, 숨김 폴더 제외)
all_users = [d for d in os.listdir('.') if os.path.isdir(d) and not d.startswith('.')]


def make_bar(count, target, length=BAR_LENGTH):
    """목표 대비 진행 상황을 이모지 블록 바로 표현"""
    ratio = min(count / target, 1) if target else 1
    filled = round(ratio * length)
    bar = "🟩" * filled + "⬜" * (length - filled)
    if count > target:
        bar += f" +{count - target}"
    return bar


# 5. 달성자 및 미달성자(벌금형) 분류
success_list = []
penalty_list = []

for user in all_users:
    count = user_counts.get(user, 0)
    bar = make_bar(count, target_count)
    line = f"**{user}**\n{bar}  `{count}/{target_count}문제`"
    if count >= target_count:
        success_list.append((count, f"🟢 {line}"))
    else:
        penalty_list.append((count, f"🔴 {line}"))

# 문제 수가 많은 순으로 정렬
success_list.sort(key=lambda x: -x[0])
penalty_list.sort(key=lambda x: -x[0])

success_lines = [line for _, line in success_list]
penalty_lines = [line for _, line in penalty_list]

# 6. Discord Webhook 발송 (Embed 스타일 스타일링)
if webhook_url:
    total_users = len(all_users)
    success_n = len(success_list)
    penalty_n = len(penalty_list)
    success_rate = round((success_n / total_users) * 100) if total_users else 0

    # 예쁘게 보여주기 위한 타이틀 설정
    period_str = "토-일-월" if hours_back == "72" else ("화-수" if sys.argv[2] == "3" else "목-금")

    # 전체 달성률에 따라 임베드 색상 변경
    if penalty_n == 0:
        color = 3066993   # green
    elif success_rate >= 50:
        color = 15105570  # orange
    else:
        color = 15158332  # red

    overall_bar = make_bar(success_n, total_users if total_users else 1, length=10)

    embed = {
        "title": "📊 알고리즘 문제 풀이 현황 리포트",
        "description": (
            f"⏰ **점검 기간** · 최근 {hours_back}시간 ({period_str})\n"
            f"🎯 **목표** · 최소 {target_count}문제 제출\n\n"
            f"{overall_bar}  **{success_rate}%** 달성"
        ),
        "color": color,
        "fields": [
            {"name": "👥 전체 인원", "value": f"{total_users}명", "inline": True},
            {"name": "✅ 달성 인원", "value": f"{success_n}명", "inline": True},
            {"name": "💸 미달성 인원", "value": f"{penalty_n}명", "inline": True},
            {
                "name": "🔥 미션 달성자",
                "value": "\n\n".join(success_lines) if success_lines else "아직 달성자가 없습니다. 분발하세요! 🏃",
                "inline": False
            },
            {
                "name": "🚨 벌금 대상자",
                "value": "\n\n".join(penalty_lines) if penalty_lines else "🎉 벌금 대상자가 없습니다!",
                "inline": False
            }
        ],
        "footer": {
            "text": "공유 레포지토리 자동화 봇 · 매 점검마다 자동 집계됩니다"
        },
        "timestamp": datetime.now(timezone.utc).isoformat()
    }

    # 미달성자가 있을 경우 멘션이나 경고 한 줄 추가
    content_text = "⚠️ **미션 실패 인원은 정해진 벌금을 납부해 주세요!** ⚠️" if penalty_list else "🙌 **모두 미션 달성! 고생하셨습니다.**"

    payload = {
        "content": content_text,
        "embeds": [embed]
    }

    req = urllib.request.Request(
        webhook_url,
        data=json.dumps(payload).encode('utf-8'),
        headers={
            'Content-Type': 'application/json',
            'User-Agent': 'Mozilla/5.0 (Windows NT 10.0; Win64; x64)'  # 이 줄을 추가합니다!
        }
    )
    try:
        urllib.request.urlopen(req)
        print("Discord Embed 알림 전송 성공")
    except Exception as e:
        print(f"알림 전송 실패: {e}")
