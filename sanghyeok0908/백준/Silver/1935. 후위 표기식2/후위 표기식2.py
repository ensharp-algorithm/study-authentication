import sys
from collections import defaultdict

N = int(sys.stdin.readline())
expression = list(sys.stdin.readline().rstrip())
alpha_dict = defaultdict(int)
result = []

for i in range(N):
    alpha_dict[chr(i + 65)] = int(sys.stdin.readline())

for index, e in enumerate(expression):
    if e == '*' or e == '+' or e == '-' or e == '/':
        operand2 = result.pop()
        operand1 = result.pop()
        if e == '*':
            result.append(operand1 * operand2)
        elif e == '+':
            result.append(operand1 + operand2)
        elif e == '-':
            result.append(operand1 - operand2)
        elif e == '/':
            result.append(operand1 / operand2)
    else:
        result.append(alpha_dict[e])
print("{:.2f}".format(result.pop()))