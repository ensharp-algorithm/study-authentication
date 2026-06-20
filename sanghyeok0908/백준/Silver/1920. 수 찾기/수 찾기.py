import sys

def binary_search(array, target, start, end):
    if start > end:
        return 0
    mid = (start + end) // 2

    if array[mid] == target:
        return 1
    elif array[mid] > target:
        return binary_search(array, target, start, mid - 1)
    return binary_search(array, target, mid + 1, end)

N = int(sys.stdin.readline())
A = list(map(int, sys.stdin.readline().split()))
A.sort()
M = int(sys.stdin.readline())
B = list(map(int, sys.stdin.readline().split()))

for b in B:
    print(binary_search(A, b, 0, N - 1))