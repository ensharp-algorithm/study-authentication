import sys

n = int(sys.stdin.readline())
meetings = []
for _ in range(n):
    meetings.append(list(map(int, sys.stdin.readline().split())))
meetings.sort(key=lambda x: (x[1], x[0]))

count = 0
endTime = 0
for meeting in meetings:
    if endTime <= meeting[0]:
        endTime = meeting[1]
        count += 1
print(count)