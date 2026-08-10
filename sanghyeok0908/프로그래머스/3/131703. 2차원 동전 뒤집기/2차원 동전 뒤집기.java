import java.util.*;

class Solution {

    int answer = Integer.MAX_VALUE;
    int n, m;
    boolean[] rowFlipped;
    
    public int solution(int[][] beginning, int[][] target) {
        n = beginning.length;
        m = beginning[0].length;
        rowFlipped = new boolean[n];
        
        dfs(0, beginning, target);
        return answer == Integer.MAX_VALUE ? -1 : answer;
    }
    
    void dfs(int depth, int[][] beginning, int[][] target) {
        if (depth == n) {
            func(beginning, target);
            return;
        }
        
        rowFlipped[depth] = true;
        dfs(depth + 1, beginning, target);
        
        rowFlipped[depth] = false;
        dfs(depth + 1, beginning, target);
    }
    
    void func(int[][] beginning, int[][] target) {
        int rowCnt = 0, colCnt = 0;
        
        for (int i = 0; i < n; i++) {
            if (rowFlipped[i])
                rowCnt++;
        }
        
        for (int col = 0; col < m; col++) {
            boolean matched = true, flipMatched = true;
            
            for (int row = 0; row < n; row++) {
                int coin = beginning[row][col];
                
                if (rowFlipped[row]) {
                    coin = coin == 0 ? 1 : 0;
                }
                
                if (coin != target[row][col]) {
                    matched = false;
                } else {
                    flipMatched = false;
                }
            }
            
            if (!matched && !flipMatched) {
                return;
            }
            
            if (!matched && flipMatched) {
                colCnt++;
            }
        }
        
        answer = Math.min(answer, rowCnt + colCnt);
    }
}