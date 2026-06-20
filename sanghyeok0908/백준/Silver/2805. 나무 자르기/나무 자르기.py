import sys

N, M = map(int, sys.stdin.readline().split())
wood = list(map(int, sys.stdin.readline().split()))
start, end = 1, max(wood)

while start <= end:
    mid = (start + end) // 2
    is_need_wood = 0
    for w in wood:
        if w > mid:
            is_need_wood += w - mid
    if is_need_wood < M:
        end = mid - 1
    else:
        start = mid + 1
print(end)