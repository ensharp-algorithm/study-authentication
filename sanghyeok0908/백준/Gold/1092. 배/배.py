import sys
input = sys.stdin.readline

N = int(input())
crane_list = list(map(int, input().split()))
M = int(input())
box_list = list(map(int, input().split()))

crane_list.sort(reverse= True)
box_list.sort(reverse= True)
if box_list[0] > crane_list[0]:
    print(-1)
else:
    count = 0
    while box_list:
        for crane in crane_list:
            if box_list and crane < box_list[-1]:
                continue
            for box in box_list:
                if crane >= box:
                    box_list.remove(box)
                    break
        count += 1
    print(count)