import sys

N = int(sys.stdin.readline())
operand_list = []
opcode_list = []
isPossible = True
i = 1

for _ in range(N):
    temp = int(sys.stdin.readline())

    while i <= temp:
        operand_list.append(i)
        opcode_list.append('+')
        i += 1

    if operand_list[-1] == temp:
        operand_list.pop()
        opcode_list.append('-')
    else:
        isPossible = False
        print("NO")
        sys.exit()

if isPossible:
    for o in opcode_list:
        print(o)