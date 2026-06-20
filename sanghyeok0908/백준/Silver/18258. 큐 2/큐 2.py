import sys
from collections import deque

N = int(sys.stdin.readline())
queue = deque()

for _ in range(N):
    order = sys.stdin.readline().split()
    if len(order) == 2:
        queue.append(int(order[1]))
    else:
        if order[0] == "pop":
            try:
                print(queue[0])
                queue.popleft()
            except:
                print(-1)
        elif order[0] == "front":
            try:
                print(queue[0])
            except:
                print(-1)
        elif order[0] == "back":
            try:
                print(queue[-1])
            except:
                print(-1)
        elif order[0] == "size":
            print(len(queue))
        elif order[0] == "empty":
            if len(queue) == 0:
                print(1)
            else:
                print(0)