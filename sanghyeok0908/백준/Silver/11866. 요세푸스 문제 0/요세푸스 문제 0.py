import sys

N, K = map(int, sys.stdin.readline().split())
array = list(range(1, N + 1))
index = 0
result = []

while len(array) != 0:
    index += K - 1
    index %= len(array)
    result.append(array.pop(index))

print('<', end='')
for i in range(N - 1):
    print(result[i], end=', ')
print(result[-1], end='')
print('>')