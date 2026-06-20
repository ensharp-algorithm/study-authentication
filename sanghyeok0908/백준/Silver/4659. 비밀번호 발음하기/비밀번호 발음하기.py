import sys

vowels = ['a', 'e', 'i', 'o', 'u']
while True:
    password = sys.stdin.readline().rstrip()
    isGoodPassword = False
    countVowel = 0
    countConsonant = 0

    if password == "end":
        break

    for vowel in vowels:
        if vowel in password:
            isGoodPassword = True
            break

    if isGoodPassword:
        for p in password:
            if p in vowels:
                countVowel += 1
                countConsonant = 0
            else:
                countVowel = 0
                countConsonant += 1
            if countConsonant == 3 or countVowel == 3:
                isGoodPassword = False
                break

    if isGoodPassword:
        for i in range(len(password) - 1):
            if password[i] == password[i + 1] and password[i] != 'e' and password[i] != 'o':
                isGoodPassword = False
                break

    if isGoodPassword:
        print("<" + password + "> is acceptable.")
    else:
        print("<" + password + "> is not acceptable.")