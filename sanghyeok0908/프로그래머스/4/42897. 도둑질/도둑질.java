class Solution {

    public int solution(int[] money) {
        int n = money.length;
        
        // 첫 번째 집을 안 털었을 때
        int[][] dp = new int[n][2];
        for (int i = 1; i < n; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1]);
            dp[i][1] = dp[i - 1][0] + money[i];
        }
        
        int temp = Math.max(dp[n - 1][0], dp[n - 1][1]);
        
        // 첫 번째 집을 털었을 때
        dp = new int[n][2];
        dp[0][1] = money[0];
        for (int i = 1; i < n - 1; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1]);
            dp[i][1] = dp[i - 1][0] + money[i];
        }
        
        return Math.max(temp, Math.max(dp[n - 2][0], dp[n - 2][1]));
    }
}