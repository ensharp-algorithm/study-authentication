import java.util.*;

class Solution {
    public int solution(int[][] beginning, int[][] target) {
     
        int n = beginning.length;
        int m = beginning[0].length;
        boolean [][] board = new boolean[n][m];
        
        for (int i = 0 ; i < n; i++){
            for (int j = 0 ; j < m; j++){
                board[i][j] = false;
                if (beginning[i][j] != target[i][j]){
                    board[i][j] = true;
                }
            }
        }
        
        
//          for (int i = 0 ; i < n; i++){
//             for (int j = 0 ; j < m; j++){
//                 if (board[i][j]){
//                     System.out.print("o ");
//                 }
//                 else{
//                      System.out.print("x ");
//                 }
//             }
//               System.out.println();
//           }
        
        
        //0번 행을 기준으로 뒤집어야 하는 열 결정 
        int columns = 0;
        
        for (int i = 0; i< m ;i++){
            if (board[0][i]){
                columns++;
            }
        }
        
        // System.out.println(columns);
        
        
        //나머지 행과 기준 행 패턴 비교 
        int rows = 0;
        for (int i = 1; i < n; i++){
            int cnt = 0;
            for (int j = 0 ; j < m;j++){
                
                //아예 동일하거나 아예 다 다르거나 
                if (board[0][j] != board[i][j]){
                    cnt++;
                }
            }
            
            if (cnt != 0 && cnt != m){
                return -1;
            }
            
            if (cnt == m){
                rows++;   
            }
        }
        
        // System.out.println(rows);
    
        return Math.min((rows+ columns),(n-rows + m- columns));
    }
}