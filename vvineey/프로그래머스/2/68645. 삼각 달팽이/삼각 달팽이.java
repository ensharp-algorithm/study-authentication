import java.util.*;

class Solution {
    public int[] solution(int n) {
        
        int[][] arr = new int[n][n];
        int goal = 0;
        
        for (int i = 0 ; i <n ; i++){
            for (int j = 0 ; j < n; j++){
                
                if (j > i){
                    arr[i][j] = -1;
                }
                else{
                    arr[i][j] = 0;
                    goal++;
                }
            }
        }
        
        int[] dx = {0,1,-1};
        int[] dy = {1,0,-1};
        int cnt = 1;
        
        int x = 0; 
        int y = 0;
        arr[y][x] = cnt++;
        
        while (cnt <= goal){
            
            for (int i = 0; i < 3; i++){
                int nx = x + dx[i];
                int ny = y + dy[i];

                //방향 유지
                while(nx >= 0 && ny >= 0 && nx < n && ny < n && arr[ny][nx] == 0){
                    
                    x = nx;
                    y = ny;
                    // System.out.println(">> " + y + " " + x);
                    
                    arr[y][x] = cnt++;
                    
                    nx = x + dx[i];
                    ny = y + dy[i];
                }
            }
        }

        
        int [] answer = new int[goal];
        int idx = 0;
           
        for (int i = 0 ; i <n ; i++){
            for (int j = 0 ; j < n; j++){
                if (arr[i][j] == -1){
                    continue;
                }
                answer[idx++] = arr[i][j];
            }
        }
        
    
        return answer;
    }
}