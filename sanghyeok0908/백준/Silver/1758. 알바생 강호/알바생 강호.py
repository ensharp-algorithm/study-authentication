n = int(input())
ans = 0
tip = []

for _ in range(n):
    tip.append(int(input()))
tip.sort(reverse=True)

for i in range(n):
    if (tip[i] - i > 0):
        ans += tip[i] - i
print(ans)