import sys

mingum = sys.stdin.readline().rstrip()
max_result = ''
min_result = ''
count = 0

for m in mingum:
    if m == 'M':
        count += 1
    else:
        max_result += '5'
        for _ in range(count):
            max_result += '0'
        count = 0

if count:
    temp1 = '1'
    for _ in range(count - 1):
        temp1 += '0'
    temp2 = ''
    for _ in range(count):
        temp2 += '1'
    max_result += str(max(temp1, temp2))

count = 0
for m in mingum:
    if m == 'M':
        count += 1
    else:
        if count:
            min_result += '1'
            for _ in range(count - 1):
                min_result += '0'
            count = 0
        min_result += '5'
    
if count:
    min_result += '1'
    for _ in range(count - 1):
        min_result += '0'

print(max_result)
print(min_result)