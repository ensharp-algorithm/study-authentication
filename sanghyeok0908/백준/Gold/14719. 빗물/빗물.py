import sys

H, W = map(int, sys.stdin.readline().split())
world = list(map(int, sys.stdin.readline().split()))
rain_count = 0

for i in range(1, W - 1):
    left_wall = max(world[:i])
    right_wall = max(world[i + 1:])
    small_wall = min(left_wall, right_wall)
    if world[i] < small_wall:
        rain_count += small_wall - world[i]
print(rain_count)