import java.util.*;

class Solution {

    int[][] dp;
    
    public int solution(int[][] info, int n, int m) {
        dp = new int[info.length + 1][m];
        
        for (int i = 1; i <= info.length; i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }
        
        for (int i = 0; i < info.length; i++) {
            int a = info[i][0];
            int b = info[i][1];
            
            for (int j = 0; j < m; j++) {
                if (dp[i][j] != Integer.MAX_VALUE && dp[i][j] + a < n)
                    dp[i + 1][j] = Math.min(dp[i + 1][j], dp[i][j] + a);
                if (j + b < m)
                    dp[i + 1][j + b] = Math.min(dp[i + 1][j + b], dp[i][j]);
            }
        }
        
        int answer = Integer.MAX_VALUE;
        for (int j = 0; j < m; j++) {
            answer = Math.min(answer, dp[info.length][j]);
        }
        return answer == Integer.MAX_VALUE ? -1 : answer;
    }
}