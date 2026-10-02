class Solution {
    
    int[] dp;
    
    public long solution(int n) {
        dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        if (n > 1)
            dp[2] = 2;
        
        for (int i = 3; i <= n; i++) {
            dp[i] = (dp[i - 1] + dp[i - 2]) % 1234567;
        }
        
        return dp[n];
    }
}