import sys
from collections import deque

N, K = map(int, sys.stdin.readline().split())
human = deque()
result = []

for i in range(1, N + 1):
    human.append(i)

while human:
    for _ in range(K - 1):
        human.append(human.popleft())
    result.append(human.popleft())
print(str(result).replace('[', '<').replace(']', '>'))