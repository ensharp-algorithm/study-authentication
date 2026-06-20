import sys
from collections import deque

T = int(sys.stdin.readline())
for _ in range(T):
    N, M = map(int, sys.stdin.readline().split())
    importance_queue = deque(map(int, sys.stdin.readline().split()))
    paper_queue = deque(i for i in range(1, N + 1))
    answer = paper_queue[M]
    count = 0

    while importance_queue:
        boolean = True

        for importance in importance_queue:
            if importance_queue[0] < importance:
                boolean = False
                importance_queue.append(importance_queue.popleft())
                paper_queue.append(paper_queue.popleft())
                break

        if boolean:
            count += 1
            importance_queue.popleft()

            if paper_queue.popleft() == answer:
                print(count)
                break