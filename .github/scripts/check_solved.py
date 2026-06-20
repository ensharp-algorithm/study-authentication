import subprocess
import sys
import os
import json
import urllib.request

# 1. 인자 및 환경변수 로드
hours_back = sys.argv[1]  # Actions에서 넘겨줄 시간 (48 또는 72)
webhook_url = os.environ.get("DISCORD_WEBHOOK")
target_count = 2

# 2. 지정된 시간 내에 '새로 추가된(A)' 소스코드 파일 목록 추출
cmd = f"git log --since='{hours_back} hours ago' --name-only --pretty=format: --diff-filter=A"
result = subprocess.run(cmd, shell=True, capture_output=True, text=True)

# 지원하는 확장자 필터링
extensions = ('.java', '.py', '.cpp', '.c', '.js')
files = [f.strip() for f in result.stdout.split('\n') if f.strip() and f.endswith(extensions)]

# 3. 사용자별 풀이 수 계산
user_counts = {}
for file_path in files:
    user = file_path.split('/')[0]
    user_counts[user] = user_counts.get(user, 0) + 1

# 4. 전체 스터디원 목록 스캔 (최상위 폴더 기준, 숨김 폴더 제외)
all_users = [d for d in os.listdir('.') if os.path.isdir(d) and not d.startswith('.')]

# 5. 달성자 및 미달성자(벌금형) 분류
success_list = []
penalty_list = []

for user in all_users:
    count = user_counts.get(user, 0)
    if count >= target_count:
        success_list.append(f"🟢 **{user}** ({count}문제 완료)")
    else:
        penalty_list.append(f"🔴 **{user}** ({count}문제 / 미달성 💸)")

# 6. Discord Webhook 발송 (Embed 스타일 스타일링)
if webhook_url:
    # 예쁘게 보여주기 위한 타이틀 설정
    period_str = "토-일-월" if hours_back == "72" else ("화-수" if sys.argv[2] == "3" else "목-금")
    
    embed = {
        "title": f"🏆 알고리즘 문제 풀이 현황 점검 ({period_str})",
        "description": f"지난 {hours_back}시간 동안 **최소 {target_count}문제** 제출 여부를 확인했습니다.",
        "color": 15158332, # Red 계열 컬러 플래그
        "fields": [
            {
                "name": "💸 벌금 대상자 (2문제 미만)",
                "value": "\n".join(penalty_list) if penalty_list else "🎉 벌금 대상자가 없습니다!",
                "inline": False
            },
            {
                "name": "🔥 미션 달성자",
                "value": "\n".join(success_list) if success_list else "아직 달성자가 없습니다. 분발하세요! 🏃",
                "inline": False
            }
        ],
        "footer": {
            "text": "공유 레포지토리 자동화 봇에 의해 측정되었습니다."
        }
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
            'User-Agent': 'Mozilla/5.0 (Windows NT 10.0; Win64; x64)' # 이 줄을 추가합니다!
        }
    )
    try:
        urllib.request.urlopen(req)
        print("Discord Embed 알림 전송 성공")
    except Exception as e:
        print(f"알림 전송 실패: {e}")
