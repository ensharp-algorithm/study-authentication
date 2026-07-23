import java.util.*;

class Solution {
    
    static int[] memo;
    public int solution(int n) {
        
        //1. top - down 풀이 
        memo = new int[n+1];
        Arrays.fill(memo,-1);
        
        return fibonacci(n);
    }
    
    private int fibonacci(int n){
        
        if (n < 2){
            return n;
        }
        
        if (memo[n] != -1){
            return memo[n];
        }
        
        memo[n] = (fibonacci(n-1) + fibonacci(n-2)) % 1234567;
        
        return memo[n];
    }
}