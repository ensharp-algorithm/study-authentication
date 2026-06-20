import sys

string = list(sys.stdin.readline())
answer = 0
for s in string:
    if s == 'A' or s == 'E' or s == 'F' or s == 'G' or s == 'H' or s == 'K' or s == 'M' or s == 'N':
        answer += 3
    elif s == 'B' or s == 'D' or s == 'P' or s == 'Q' or s == 'R' or s == 'T' or s == 'W' or s == 'X' or s == 'Y':
        answer += 2
    elif s == 'C' or s == 'I' or s == 'J' or s == 'L' or s == 'O' or s == 'S' or s == 'U' or s == 'V' or s == 'Z':
        answer += 1
if (answer % 10) % 2 == 1:
    print("I'm a winner!")
else:
    print("You're the winner?")