import sys
    
N = int(sys.stdin.readline())
cardN = list(map(int, sys.stdin.readline().split()))
cardN.sort()
M = int(sys.stdin.readline())
cardM = list(map(int, sys.stdin.readline().split()))
countCard = {}

for card in cardN:
    if card in countCard:
        countCard[card] += 1
    else:
        countCard[card] = 1

for card in cardM:
    result = countCard.get(card)
    if result == None:
        print(0, end= ' ')
    else:
        print(result, end= ' ')
print()