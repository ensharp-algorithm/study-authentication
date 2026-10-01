import java.util.*;

class Solution {
    public int solution(int n) {
        
        int[] memo = new int[n+1];
        Arrays.fill(memo, -1);
        memo[0] = 1;
        memo[1] = 1;
        
        return getPair(memo,n);
    }
    
    
    private int getPair(int[] memo, int n){
 
        if (memo[n] != -1){
            // System.out.println("memo " + n + " : " + memo[n]);
            return memo[n];
        }
        
        int sum = 0;
        for (int i = 0; i < n; i++){
            // System.out.println(i + " " + (n-1-i));
            sum += getPair(memo, i) *  getPair(memo, n-1-i);
        }
        
        return memo[n] = sum;
    }
}