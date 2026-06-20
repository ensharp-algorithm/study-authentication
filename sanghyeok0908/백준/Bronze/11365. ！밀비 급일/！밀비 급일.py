import sys

password = []
i = 0
while True:
    password.append(list(sys.stdin.readline().rstrip()))
    if password[i][0] == 'E' and password[i][1] == 'N' and password[i][2] == 'D':
        password.remove(password[i])
        break
    i += 1

for word in password:
    for w in reversed(word):
        print(w, end= '')
    print()