import sys

N, K = map(int, sys.stdin.readline().split())
result = 1
divide = 1

for i in range(1, N + 1):
    result *= i
for i in range(1, K + 1):
    divide *= i
for i in range(1, N - K + 1):
    divide *= i
print(result // divide)