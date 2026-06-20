import sys

n, m = map(int, sys.stdin.readline().split())
array = [[0] * (n + 1) for _ in range(m + 1)]
array[0][0] = 1
for i in range(1, m + 1):
    for j in range(1, n + 1):
        array[i][j] += (array[i - 1][j] + array[i][j - 1] + array[i - 1][j - 1]) % 1000000007
print(array[m][n])