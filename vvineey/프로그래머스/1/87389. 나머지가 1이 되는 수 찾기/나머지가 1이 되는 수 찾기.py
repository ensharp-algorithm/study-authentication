def solution(n):
    answer = 1000001
    
    for i in range(1,n):
        if (n%i==1):
            answer = min(answer,i)
        
    
    return answer