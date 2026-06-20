N = int(input())
C = []
for _ in range(N):
    C.append(int(input()))
C.sort(reverse=True)

ans = 0
for i in range(N):
    if (i + 1) % 3 != 0:
        ans += C[i]
print(ans)
    