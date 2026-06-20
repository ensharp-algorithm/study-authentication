import sys

strings = []
for _ in range(5):
    strings.append(list(sys.stdin.readline().rstrip()))

max_len = 0
for s in strings:
    if (max_len < len(s)):
        max_len = len(s)


for row in range(5):
    if (len(strings[row]) < max_len):
        for i in range(max_len - len(strings[row])):
            strings[row].append('')

for i in range(max_len):
    for j in range(5):
        print(strings[j][i], end= '')