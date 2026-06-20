n = int(input())

p = list(map(int, input().split()))
p.sort()

ans = 0
for i in range(n):
    for j in range(i + 1):
           ans += p[j]
print(ans)
