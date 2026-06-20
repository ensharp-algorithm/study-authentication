import sys

number = 1
for _ in range(3):
    number *= int(sys.stdin.readline())
stringNumber = list(str(number))

numberDict = {'0': 0, '1': 0, '2': 0, '3': 0, '4': 0, '5': 0, '6': 0, '7': 0, '8': 0, '9': 0}
for s in stringNumber:
    numberDict[s] += 1

for i in range(10):
    print(numberDict[str(i)])