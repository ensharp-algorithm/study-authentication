import java.util.*;

class Solution {
    public int solution(int[] people, int limit) {
        int answer = 0;
        
        Arrays.sort(people);
        
        // 20 30 50 50 70 80 
        
        // 20 80 i = 0 j = n-1 
        // 30 70 i = 1 j = n-1-1
        // 50 50 i = 2 j = n-1-2
        
        int n = people.length;
        int i = 0 ;
        // 0 1 2 
        
        for (int j = n-1; j >= i ;j--){
            if (people[i] + people[j] <= limit){
                i++;
            }
            
            
            answer++;
        }
        
        
        
        
        
        
        return answer;
    }
}