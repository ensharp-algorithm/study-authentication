import sys

T = int(sys.stdin.readline())
zero = [1, 0, 1]
one = [0, 1, 1]
for _ in range(T):
    number = int(sys.stdin.readline())
    for i in range(len(zero), number + 1):
        zero.append(zero[i - 1] + zero[i - 2])
        one.append(one[i - 1] + one[i - 2])
    print(zero[number], one[number])