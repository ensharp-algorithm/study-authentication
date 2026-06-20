import sys

N = int(sys.stdin.readline())
parenthesis_list = list(sys.stdin.readline().rstrip())

num_list = [0 for _ in range(N)]
stack = []

for id, parenthesis in enumerate(parenthesis_list):
    if (parenthesis == '('):
        stack.append(id)
    else:
        if (stack):
            target_id = stack.pop()
            num_list[id] = 1
            num_list[target_id] = 1

max_len = 0
temp_len = 0
for num in num_list:
    if (num == 1):
        temp_len += 1
    else:
        if (max_len < temp_len):
            max_len = temp_len
        temp_len = 0

if (max_len < temp_len):
    max_len = temp_len
        
print(max_len)