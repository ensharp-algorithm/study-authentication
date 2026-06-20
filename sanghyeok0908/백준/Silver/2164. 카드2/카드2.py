import sys
from collections import deque

N = int(sys.stdin.readline())
card = deque([i for i in range(1, N+1)])

while len(card) > 1:
    card.popleft()
    card.append(card.popleft())
print(card.pop())