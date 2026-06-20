import sys
import re

pattern = r'^[A-F]{0,1}A+F+C+[A|B|C|D|E|F]?$'

T = int(sys.stdin.readline())

for _ in range(T):
    input_string = sys.stdin.readline().rstrip()
    if (re.match(pattern, input_string)):
        print("Infected!")
    else:
        print("Good")