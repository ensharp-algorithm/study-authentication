import sys

N = int(sys.stdin.readline())
drink = list(map(int, sys.stdin.readline().split()))
drink.sort()

total = drink[-1]
for i in range(N - 1):
    total += drink[i] / 2
print(total)