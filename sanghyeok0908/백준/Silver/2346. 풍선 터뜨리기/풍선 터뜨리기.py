import sys

N = int(sys.stdin.readline())
balloon_list = list(map(int, sys.stdin.readline().split()))
rank_list = list(i for i in range(1, N + 1))
index = 0

while rank_list:
    print(rank_list.pop(index), end= ' ')
    temp = balloon_list.pop(index)
    if len(rank_list) == 0:
        break
    elif temp > 0:
        index = (index + temp - 1) % len(rank_list)
    else:
        index = (index + temp) % len(rank_list)
