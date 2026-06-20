import sys

A, B= map(int, sys.stdin.readline().split())
count = 1

while(A != B):
    count += 1
    temp = B
    if B % 10 == 1:
        B //= 10
    elif B % 2 == 0:
        B //= 2
    
    if A == B:
        print(count)
        break
    elif temp == B:
        print(-1)
        break
