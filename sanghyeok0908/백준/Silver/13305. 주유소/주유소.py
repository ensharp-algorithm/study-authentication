N = int(input())
road = list(map(int, input().split()))
gas = list(map(int, input().split()))

minGas = gas[0]
ans = minGas * road[0]
for i in range(1, N - 1):
    if minGas > gas[i]:
        minGas = gas[i]
    ans += minGas * road[i]
print(ans)