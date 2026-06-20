import sys

N, M = map(int, sys.stdin.readline().split())
card = list(map(int, sys.stdin.readline().split()))
max = 0
for i in range(N):
    for j in range(i + 1, N):
        for k in range(j + 1, N):
            if card[i] + card[j] + card[k] <= M and max < card[i] + card[j] + card[k]:
                max = card[i] + card[j] + card[k]
print(max)