import sys

N, M = map(int, sys.stdin.readline().split())
human1 = []
human2 = []
answer = []

for _ in range(N):
    human1.append(sys.stdin.readline().rstrip())
for _ in range(M):
    human2.append(sys.stdin.readline().rstrip())
human2.sort()

for one in human1:
    start = 0
    end = len(human2) - 1
    while(start <= end):
        target = (start + end) // 2
        if human2[target] == one:
            answer.append(one)
            break
        elif human2[target] < one:
            start = target + 1
        else:
            end = target - 1
answer.sort()

print(len(answer))
for ans in answer:
    print(ans)