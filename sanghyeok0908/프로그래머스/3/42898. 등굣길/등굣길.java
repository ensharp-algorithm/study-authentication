import java.util.*;

class Solution {
    
    public int solution(int m, int n, int[][] puddles) {
        int[][] dp = new int[n][m];
        dp[0][0] = 1;
        
        for (int[] p : puddles) {
            if (p.length >= 2)
                dp[p[1] - 1][p[0] - 1] = -1;
        }
        
        for (int i = 1; i < m; i++) {
            if (dp[0][i] != -1)
                dp[0][i] = dp[0][i - 1];
        }
        
        for (int i = 1; i < n; i++) {
            if (dp[i][0] != -1)
                dp[i][0] = dp[i - 1][0];
        }
        
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                if (dp[i][j] == -1) {
                    continue;
                }
                
                if (dp[i][j - 1] != -1) {
                    dp[i][j] += dp[i][j - 1];
                    dp[i][j] %= 1000000007;
                }

                if (dp[i - 1][j] != -1) {
                    dp[i][j] += dp[i - 1][j];
                    dp[i][j] %= 1000000007;
                }
            }
        }
        return dp[n - 1][m - 1];
    }
}