import java.util.*;

class Solution {
    static int cost;
    
    public int solution(int n, int s, int a, int b, int[][] fares) {
        
        int [][] costs = new int [n+1][n+1]; 
        cost = 0;

        for(int i = 1; i <n+1;i++){
             for(int j = 1; j <n+1;j++){
                 if (i == j) costs[i][j] = 0;
                 else costs[i][j] = Integer.MAX_VALUE/4;
             }
        }
        
        for (int[] row : fares){
            costs[row[0]][row[1]] = row[2];
            costs[row[1]][row[0]] = row[2];
        }
      
        
        for (int k = 1; k < n+1;k++){
            for(int i = 1; i <n+1;i++){
                for(int j = 1; j < n+1;j++){
                    costs[i][j] = Math.min(costs[i][j], costs[i][k] +  costs[k][j]);
                } 
            }
        }
        
                
//         for(int i = 1; i <n+1;i++){
//              for(int j = 1; j <n+1;j++){
//                  if (costs[i][j] == Integer.MAX_VALUE/4){
//                       System.out.print("X ");
//                  }
//                  else{
//                     System.out.print(costs[i][j] + " ");
//                 }
//              }
//             System.out.println();
//         }     
        
         
        int together_cost = Integer.MAX_VALUE;
        
        for (int k = 1; k < n+1; k++){
            together_cost = Math.min(together_cost, costs[s][k] +  costs[k][a] +  costs[k][b]);
        }
    
        
        return together_cost;
    }
    
   
}