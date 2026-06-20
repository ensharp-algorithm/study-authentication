import sys

S = list(sys.stdin.readline().rstrip())
K = sys.stdin.readline().rstrip()
word = []

for s in S:
    if s.isalpha():
        word.append(s)
word = ''.join(word)
if K in word:
    print(1)
else:
    print(0)