def solution(nums):
    answer = 0

    for i in range(len(nums)-2):
        for j in range(i+1, len(nums)-1):
            for k in range(j+1, len(nums)):
                
                if (is_prime_number(nums[i] + nums[j] + nums[k])):
#                     print(nums[i])
#                     print(nums[j])
#                     print(nums[k])
#                     print()
            
            
                    answer+=1


    return answer


def is_prime_number(num):
    
    for i in range(2,num):
        
        if num % i == 0 :
            return False;
        
    return True;
    