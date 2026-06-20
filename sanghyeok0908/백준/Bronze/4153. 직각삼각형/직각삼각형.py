import sys

while True:
    number = list(map(int, sys.stdin.readline().split()))
    if number[0] == number[1] and number[1] == number[2] and number[2] == 0:
        break
    number.sort()
    if number[0] ** 2 + number[1] ** 2 == number[2] ** 2:
        print("right")
    else:
        print("wrong")