import java.util.*;

class Solution {
    
    public int solution(int m, int n, int[][] puddles) {
        boolean[][] matrix = new boolean[n][m];
        int[][] dp = new int[n][m];
        
        for (int[] i : puddles) {
            if (i.length > 0)
                matrix[i[1] - 1][i[0] - 1] = true;
        }   
        
        for (int i = m - 1; i >= 0; i--) {
            if (matrix[n - 1][i]) {
                break;
            }
            dp[n - 1][i] = 1;
        }
        for (int i = n - 1; i >= 0; i--) {
            if (matrix[i][m - 1])
                break;
            dp[i][m - 1] = 1;
        }
        
        for (int i = n - 1 - 1; i >= 0; i--) {
            for (int j = m - 1 - 1; j >= 0; j--) {
                if (!matrix[i][j])
                    dp[i][j] = (dp[i + 1][j] + dp[i][j + 1]) % 1000000007;
            }
        }
        
        // for (int i = 0; i < n; i++) {
        //     for (int j = 0; j < m; j++) {
        //         System.out.print(dp[i][j] + " ");
        //     }
        //     System.out.println();
        // }
        
        return dp[0][0];
    }
}