import sys
import heapq

schedule_list = []
heap = []
N = int(sys.stdin.readline())
for _ in range(N):
    schedule_list.append(list(map(int, sys.stdin.readline().split())))
schedule_list.sort(key= lambda x : x[0])

for start, end in schedule_list:
    if heap and heap[0] <= start:
        heapq.heappop(heap)
    heapq.heappush(heap, end)
print(len(heap))