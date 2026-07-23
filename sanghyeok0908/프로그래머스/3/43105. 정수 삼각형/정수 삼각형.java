import java.util.*;

class Solution {
    
    public int solution(int[][] triangle) {
        int height = triangle.length;
        int[][] dp = new int[height][];
        
        for (int i = 0; i < height; i++) {
            dp[i] = new int[triangle[i].length];
        }
        dp[0][0] = triangle[0][0];
        
        for (int i = 1; i < height; i++) {
            int w = dp[i].length;
            dp[i][0] = dp[i - 1][0] + triangle[i][0];
            dp[i][w - 1] = dp[i - 1][w - 2] + triangle[i][w - 1];
            
            for (int j = 1; j < w - 1; j++) {
                dp[i][j] = Math.max(dp[i - 1][j - 1], dp[i - 1][j]) + triangle[i][j];
                // System.out.printf("%d %d\n", dp[i - 1][j], triangle[i][j]);
            }
        }
        
        int max = 0;
        for (int i = 0; i < triangle[height - 1].length; i++) {
            if (dp[height - 1][i] > max) {
                max = dp[height - 1][i];
            }
        }
        return max;
    }
}