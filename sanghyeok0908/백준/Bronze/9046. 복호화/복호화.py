import sys

T = int(sys.stdin.readline())
for _ in range(T):
    string_list = list(sys.stdin.readline().rstrip())
    dic = dict()

    for string in string_list:
        if string != ' ':
            if string in dic:
                dic[string] += 1
            else:
                dic[string] = 1
    answer = sorted(dic.values(), reverse= True)
    if (len(answer) > 1 and answer[0] == answer[1]) or len(answer) == 0:
        print('?')
    else:
        print(max(dic, key= dic.get))