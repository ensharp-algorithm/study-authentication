import java.util.*;

class Solution {

    public int solution(int n, int[][] results) {
    
        boolean [][] win = new boolean[n+1][n+1];
        
        for (int[] row : results){
          win[row[0]][row[1]] = true;
        }
        
        //k를 거쳐서 이기는 경우 갱신
        for (int k= 1; k<=n;k++){
            for (int i = 1; i <=n;i++){
                for (int j = 1; j <=n;j++){
                    if (win[i][k] && win[k][j]){
                        // System.out.println("win " + i + " " + k  + " win " + k + " " + j);
                        win[i][j] = true;
                    }
                }
            }
        }
        
        int [] answer = new int[n+1];
        Arrays.fill(answer,0);
        
        for (int i = 1; i <=n;i++){
            for (int j = 1; j <=n;j++){
                if (win[i][j] || win[j][i]){
                    answer[i]++;
                }
            }
        }
        
        int cnt = 0;
        for (int i = 1; i <=n;i++){
            if (answer[i] == n-1){
                cnt++;
            }
        }
        
        return cnt;  
    }
}