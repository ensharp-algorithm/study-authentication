n = int(input())
ans = []
rope = []
for _ in range(n):
    rope.append(int(input()))
rope.sort()
for i in range(n):
    ans.append(rope[i] * (n - i))
ans.sort(reverse=True)
print(ans[0])