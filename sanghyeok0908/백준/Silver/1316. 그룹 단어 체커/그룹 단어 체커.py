import sys

N = int(sys.stdin.readline())
answer = 0

for _ in range(N):
    strings = list(sys.stdin.readline().rstrip())
    group = True
    for i in range(len(strings)):
        continuity = True
        for j in range(i + 1, len(strings)):
            if strings[i] != strings[j]:
                continuity = False
            elif continuity == False:
                group = False
                break
        if group == False:
            break
    if group:
        answer += 1
print(answer)