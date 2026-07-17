import java.util.*;

class Solution {
    
    public int[] solution(int m, int n, int h, int w, int[][] drops) {
        int left = 0, right = drops.length;
        int[] answer = new int[2];
        
        while(left <= right) {
            int mid = (left + right) / 2;
            int[] result = calculate(mid, m, n, h, w, drops);
            
            if (result == null) {
               right = mid - 1;
            } else {
                left = mid + 1; 
                answer = result;
            }
        }
        return answer;
    }
    
    int[] calculate(int K, int m, int n, int h, int w, int[][] drops) {
        int[][] prefixSum = new int[m + 1][n + 1];
        
        for (int i = 0; i < K; i++) {
            int y = drops[i][0] + 1;
            int x = drops[i][1] + 1;
            prefixSum[y][x] = 1;
        }
        
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                prefixSum[i][j] = prefixSum[i][j]
                    + prefixSum[i - 1][j]
                    + prefixSum[i][j - 1]
                    - prefixSum[i - 1][j - 1];
            }
        }
        
        for (int i = 1; i <= m - h + 1; i++) {
            for (int j = 1; j <= n - w + 1; j++) {
                int r1 = i;
                int c1 = j;
                int r2 = i + h - 1;
                int c2 = j + w - 1;
                
                int result = prefixSum[r2][c2]
                    - prefixSum[r1 - 1][c2]
                    - prefixSum[r2][c1 - 1]
                    + prefixSum[r1 - 1][c1 - 1];
                
                if (result == 0) {
                    return new int[] { i - 1, j - 1};
                }
            }
        }
        
        return null;
    }
}