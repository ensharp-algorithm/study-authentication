import sys

N = int(sys.stdin.readline())
array = [int(sys.stdin.readline()) for _ in range(N)]
array.sort()
for value in array:
    print(value)