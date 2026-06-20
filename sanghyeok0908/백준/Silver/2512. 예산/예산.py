import sys

N = int(sys.stdin.readline())
array = list(map(int, sys.stdin.readline().split()))
target = int(sys.stdin.readline())
start, end = 1, max(array)

while start <= end:
    mid = (start + end) // 2
    result = 0
    for value in array:
        if value > mid:
            result += mid
        else:
            result += value
    if result <= target:
        start = mid + 1
    else:
        end = mid - 1
print(end)