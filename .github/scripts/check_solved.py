import subprocess
import sys
import os
import json
import urllib.request
from datetime import datetime, timezone

# 1. 인자 및 환경변수 로드
hours_back = int(sys.argv[1])  # Actions에서 넘겨줄 시간 (48 또는 72)
webhook_url = os.environ.get("DISCORD_WEBHOOK")
target_count = 2
BAR_LENGTH = 5  # 프로그레스 바 칸 수

# 점검 시작 기준시각(UTC). 각 커밋의 커밋시각과 절대시간으로 직접 비교한다.
cutoff_ts = datetime.now(timezone.utc).timestamp() - hours_back * 3600

# 2. '추가(A) 또는 수정(M)된' 소스코드 파일 목록 추출
#    - git 기본 --since 는 "날짜보다 오래된 첫 커밋"을 만나면 순회를 멈추기 때문에,
#      (auto-sync/rebase 등으로) 커밋 시각이 역전되면 범위 안의 커밋을 통째로 건너뛴다.
#    - 그래서 전체 커밋을 나열하되 커밋시각(%ct)을 함께 뽑아 Python에서 직접 필터링한다.
COMMIT_MARK = "@@COMMIT@@"  # 커밋 경계 표시(파일 경로 맨 앞에 나올 일이 없는 값)
cmd = [
    "git", "log",
    "--name-only", "--diff-filter=AM",
    f"--pretty=format:{COMMIT_MARK}%ct",
]
result = subprocess.run(cmd, capture_output=True, text=True)

# 3. 커밋 블록을 순회하며 '범위 안' 커밋의 파일만 사용자별로 집계
#    (같은 파일을 여러 커밋에 걸쳐 수정해도 1문제로만 집계)
# '.undefined' 는 SWEA 연동(auto-sync) 도구가 언어를 감지하지 못했을 때 붙이는 fallback
# 확장자로, 실제 내용은 정상 풀이 소스코드다. 이걸 포함해야 SWEA 풀이도 집계된다.
extensions = ('.java', '.py', '.cpp', '.c', '.js', '.undefined')
user_files = {}
in_window = False  # 현재 파싱 중인 커밋이 점검 범위 안인지 여부
for raw in result.stdout.split('\n'):
    if raw.startswith(COMMIT_MARK):  # 마커 판별은 strip 이전 원본 줄에서 수행
        commit_ts = int(raw[len(COMMIT_MARK):])
        in_window = commit_ts >= cutoff_ts
        continue
    if not in_window:
        continue
    clean_path = raw.strip().strip('"')  # 양끝 공백과 큰따옴표 제거
    if clean_path and clean_path.endswith(extensions):
        user = clean_path.split('/')[0]
        user_files.setdefault(user, set()).add(clean_path)

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
    period_str = "토-일-월" if hours_back == 72 else ("화-수" if sys.argv[2] == "3" else "목-금")

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
