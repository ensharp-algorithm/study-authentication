import sys

while True:
    try:
        S, T = sys.stdin.readline().split()
    except:
        break
    count = 0

    for t in T:
        if S[count] == t:
            count += 1
            if count == len(S):
                print('Yes')
                break

    if count != len(S):
        print('No')