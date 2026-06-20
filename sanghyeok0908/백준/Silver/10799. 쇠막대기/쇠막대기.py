import sys

input_ch = sys.stdin.readline().rstrip()
sticks = 0
last_ch = ''
result = 0

for ch in input_ch:
    if ch == '(':
        sticks += 1
    else:
        sticks -= 1
        if last_ch == '(':
            result += sticks
        else:
            result += 1
    last_ch = ch
print(result)