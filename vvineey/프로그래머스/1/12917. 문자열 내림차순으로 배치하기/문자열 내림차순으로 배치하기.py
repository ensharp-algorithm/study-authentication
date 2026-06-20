def solution(s):
    
    s = list(s)
    
    for i in range(len(s)) :
        for j in range(i+1,len(s)):
            
            if (s[i] < s[j]):
                tmp = s[i]
                s[i] = s[j]
                s[j] = tmp
    

    sorted_s = ""
    for i in s :
        sorted_s += i
    
    return sorted_s