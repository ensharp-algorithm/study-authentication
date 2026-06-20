class Solution {
    public int solution(int sticker[]) {
        int n = sticker.length;
        // 0: 첫 번째 선택 O, 1: 첫 번째 선택 X
        int[][] dp = new int[2][n]; 
        
        if (n == 1) {
            return sticker[0];
        } else if (n == 2) {
            return Math.max(sticker[0], sticker[1]);
        }
        
        dp[0][0] = sticker[0];
        dp[0][1] = sticker[0];
        dp[1][1] = sticker[1];
        
        for (int i = 2; i < n - 1; i++) {
            dp[0][i] = Math.max(dp[0][i - 1], dp[0][i - 2] + sticker[i]);
            dp[1][i] = Math.max(dp[1][i - 1], dp[1][i - 2] + sticker[i]);
        }
        
        dp[0][n - 1] = dp[0][n - 2];
        dp[1][n - 1] = Math.max(dp[1][n - 2], dp[1][n - 3] + sticker[n - 1]);
        
        // for (int i = 0; i < n; i++) {
        //     System.out.println(dp[0][i] + " " + dp[1][i]);
        // }
        return Math.max(dp[0][n - 1], dp[1][n - 1]);
    }
}