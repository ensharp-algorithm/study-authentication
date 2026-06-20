import sys

N = int(sys.stdin.readline())
human = []
for _ in range(N):
    age, name = sys.stdin.readline().split()
    human.append((int(age), name))
human.sort(key= lambda x : x[0])

for value in human:
    print(value[0], value[1])