import sys

N = int(sys.stdin.readline())
machine = list(map(int, sys.stdin.readline().split()))
machine.sort()

M = 0
if N % 2 == 1:
    M = machine[-1]
    for i in range(int(N / 2)):
        if M < machine[i] + machine[N - 2 - i]:
            M = machine[i] + machine[N - 2 - i]
else:
    for i in range(int(N / 2)):
        if M < machine[i] + machine[N - 1 - i]:
            M = machine[i] + machine[N - 1 - i]
print(M)