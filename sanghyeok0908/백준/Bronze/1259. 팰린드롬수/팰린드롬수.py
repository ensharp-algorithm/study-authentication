import sys

while True:
    number = sys.stdin.readline().rstrip()
    if number == '0':
        break
    elif number == number[::-1]:
        print("yes")
    else:
        print("no")