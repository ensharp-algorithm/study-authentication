exp = list(input().split('-'))
num = []
for e in exp:
    sum = 0
    temp = e.split('+')
    for t in temp:
        sum += int(t)
    num.append(sum)

ans = num[0]
for i in range(1, len(num)):
    ans -= num[i]
print(ans)
