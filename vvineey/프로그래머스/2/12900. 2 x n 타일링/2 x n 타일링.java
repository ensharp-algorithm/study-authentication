import java.util.*;

class Solution {
    static final int mod = 1000000007;
    
    public int solution(int n) {
        
        long[] dp = new long[n+1];
        dp[0] = 1;
        dp[1] = 1;
        
        for (int i = 2; i <=n; i++){
            dp[i] = (dp[i-1] + dp[i-2])% mod;
        }
        
        return (int)dp[n];
    }
}