import sys

N = int(sys.stdin.readline())
problem = list(sys.stdin.readline())
colorDict = {'B': 0, 'R': 0}
colorDict[problem[0]] += 1

for i in range(1, N):
    if problem[i] != problem[i - 1]:
        colorDict[problem[i]] += 1
print(min(colorDict['B'], colorDict['R']) + 1)