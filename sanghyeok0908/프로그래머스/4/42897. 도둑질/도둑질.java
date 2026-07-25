class Solution {
    
    public int solution(int[] money) {
        int n = money.length;
        int[][] dp = new int[2][money.length];
        
        dp[0][0] = money[0];
        dp[0][1] = money[0];
        dp[1][0] = 0;
        dp[1][1] = money[1];
        
        for (int i = 2; i < n; i++) {
            dp[0][i] = Math.max(money[i] + dp[0][i - 2], dp[0][i - 1]);
            dp[1][i] = Math.max(money[i] + dp[1][i - 2], dp[1][i - 1]);
        }
        return Math.max(dp[0][n - 2], dp[1][n - 1]);
    }
}