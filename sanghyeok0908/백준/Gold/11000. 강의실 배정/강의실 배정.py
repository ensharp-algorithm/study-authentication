import sys
import heapq

N = int(sys.stdin.readline())
class_list = []
for _ in range(N):
    class_list.append(list(map(int, sys.stdin.readline().split())))
class_list.sort()
heap = []

for start, end in class_list:
    if heap and heap[0] <= start:
        heapq.heappop(heap)
    heapq.heappush(heap, end)
print(len(heap))