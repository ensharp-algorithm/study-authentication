import java.util.*;

class Solution {
    
    int[] player;
    int n;
    boolean[][] history;
    
    public int solution(int n, int[][] results) {
        
        player = new int[n+1];
        history = new boolean[n+1][n+1];

        for (int[] result : results) {
            history[result[0]][result[1]] = true;         
        }
        
        Arrays.fill(player,0);
        
        
        for (int k = 1; k <= n; k++){
            for (int i = 1; i <= n; i++){
                for (int j = 1; j <= n; j++){
                    if (history[i][k] && history[k][j]){
                        history[i][j] = true;
                    }
                }
            }
        }
        
        for (int i = 1; i <= n; i++){
            for (int j = 1; j <= n; j++){
                
                if (history[i][j]) {
                    player[i] ++;
                    player[j] ++;
                }
            }
        }
        
        int cnt = 0;
        for (int i = 1; i <= n; i++){
            if (player[i] == n-1){
                cnt++;
            }
        }
        
        return cnt;
    }
}