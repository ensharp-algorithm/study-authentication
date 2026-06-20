import sys

N, K = map(int, sys.stdin.readline().split())
children = list(map(int, sys.stdin.readline().split()))
sub = []
sum = 0

for i in range(N - 1):
    sub.append(children[i + 1] - children[i])
sub.sort()

for i in range(N - K):
    sum += sub[i]
print(sum)