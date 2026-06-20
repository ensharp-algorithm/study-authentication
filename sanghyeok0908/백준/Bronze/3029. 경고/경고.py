import sys

h1, m1, s1 = map(int, sys.stdin.readline().split(':'))
h2, m2, s2 = map(int, sys.stdin.readline().split(':'))
t1 = h1 * 60 * 60 + m1 * 60 + s1
t2 = h2 * 60 * 60 + m2 * 60 + s2
t = t2 - t1 if t2 > t1 else 60 * 60 * 24 - t1 + t2
h = t // 60 // 60
m = t // 60 % 60
s = t % 60
print("%02d:%02d:%02d" %(h, m, s))