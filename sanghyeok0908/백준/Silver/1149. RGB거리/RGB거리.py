import sys
from collections import defaultdict

N = int(sys.stdin.readline())
red = 0
green = 0
blue = 0

for _ in range(N):
    r, g, b = map(int, sys.stdin.readline().split())
    if red == green and green == blue and blue == 0:
        red = r
        green = g
        blue = b
        continue
    
    temp_red = min(green, blue) + r
    temp_green = min(red, blue) + g
    temp_blue = min(red, green) + b
    red = temp_red
    green = temp_green
    blue = temp_blue
print(min(red, green, blue))