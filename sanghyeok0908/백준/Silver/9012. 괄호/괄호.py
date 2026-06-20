import sys

T = int(sys.stdin.readline())
for _ in range(T):
    temp = list(sys.stdin.readline())
    string = []
    for t in temp:
        VPS = True
        if t == '(':
            string.append(t)
        elif t == ')':
            if len(string) == 0:
                VPS = False
                break
            string.pop()
    if len(string) == 0 and VPS == True:
        print("YES")
    else:
        print("NO")