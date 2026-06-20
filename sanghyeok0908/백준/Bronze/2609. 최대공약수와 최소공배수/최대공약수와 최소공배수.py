import sys

def gcd(a, b):
    if b == 0:
        return a
    return gcd(b, a % b)

a, b = map(int, sys.stdin.readline().split())
print(gcd(a, b))
print((a * b) // gcd(a, b))