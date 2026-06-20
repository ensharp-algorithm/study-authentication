n = int(input())
coin = 0
while True:
    if n % 5 == 0:
        coin += n / 5
        break
    else:
        n -= 2
        coin += 1

    if n < 0:
        break

if n < 0:
    print(-1)
else:
    print(int(coin))