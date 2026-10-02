class Solution {
    
    int[] dp;
    
    public long solution(int n) {
        dp = new int[n + 1];
        
        return dfs(n);
    }
    
    int dfs(int num) {
        if (num == 0) {
            return 1;
        }
        if (num < 0) {
            return 0;
        }
        
        if (dp[num] == 0) {
            dp[num] = (dfs(num - 1) + dfs(num - 2)) % 1234567;
        }
        return dp[num];
    }
}