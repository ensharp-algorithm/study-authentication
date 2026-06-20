import java.util.*;

class Solution {
    
    static int[] arr;
    static int answer ;
    static int t;
    
    public int solution(int[] numbers, int target) {
        
         arr = numbers;
        
        t = target;
        answer = 0;
        
        dfs(0, 0);
    
        
        return answer;
    }
    
    
     public void dfs(int idx, int sum){
        
        // System.out.println("idx= "+ idx+" sum = "+ sum);
        
        if (idx == arr.length){
            if (sum == t){
            answer++;
        }
            return;
        }
        
        
        // 더하거나 
        dfs(idx + 1,sum+arr[idx]);
        
        
        // 빼거나
        dfs(idx + 1, sum-arr[idx]);
    }
   
    
    
}