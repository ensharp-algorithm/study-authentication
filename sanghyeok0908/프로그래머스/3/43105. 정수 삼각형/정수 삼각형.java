import java.util.*;

class Solution {
    
    public int solution(int[][] triangle) {
        int height = triangle.length;
        int weight = triangle[height - 1].length;
        int[][] dp = new int[height][];
        
        for (int i = 0; i < height; i++) {
            dp[i] = new int[triangle[i].length];
        }
        for (int i = 0; i < weight; i++) {
            dp[height - 1][i] = triangle[height - 1][i];
        }
        
        for (int i = height - 2; i >= 0; i--) {
            for (int j = 0; j < dp[i].length; j++) {
                dp[i][j] = Math.max(dp[i + 1][j], dp[i + 1][j + 1]) + triangle[i][j];
                // System.out.printf("%d %d %d\n", dp[i + 1][j], dp[i + 1][j + 1], triangle[i][j]);
            }
        }
        
        return dp[0][0];
    }
}