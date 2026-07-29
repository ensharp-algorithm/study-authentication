class Solution {
    public int solution(int m, int n, int[][] puddles) {
        
        int [][] board = new int[n][m];
        
        for (int[] puddle : puddles){
            board[puddle[1]-1][puddle[0]-1] = -1;
            
        }
    
        
        for (int i = 0; i < n; i++){
            for (int j = 0; j < m ; j++){
                
                if (board[i][j] == -1){
                    continue;
                }
                if (i == 0 && j == 0){
                    board[i][j] = 1;
                }
            
                else{
                    int num1 = 0;
                    int num2 = 0;
                    
                    if (i-1 >= 0){
                        num1 = board[i-1][j] == -1 ? 0 : board[i-1][j];
                    }
                    if (j-1 >= 0){
                        num2 = board[i][j-1] == -1 ? 0 : board[i][j-1];
                    }
                    board[i][j] = (num1 +  num2) % 1000000007;
                }
            }
        }
        
//         for (int i = 0; i < n; i++){
//             for (int j = 0; j < m ; j++){
//                  System.out.printf("%d ",board[i][j]);
//             }
//             System.out.println();
//          }
        
//          System.out.println("=================");
        
        return  board[n-1][m-1];
    }
}