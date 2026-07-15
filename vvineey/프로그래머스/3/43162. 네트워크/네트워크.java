import java.util.*;

class Solution {
    static boolean [] visited;
    
    private void dfs(int[][] computers, int current) {
      
        visited[current] = true;
        
        for (int i = 0; i < computers.length;i++){
            if (current != i && !visited[i] &&  computers[current][i] == 1){
                
                System.out.println("current = " + current + " 연결 :" + i);
                dfs(computers,i);  
            }
        }
    
    }
    
    
    public int solution(int n, int[][] computers) {
        
        int network = 0;
        visited = new boolean[computers.length];
        
        for (int i = 0; i < computers.length; i++){
            
            if (!visited[i]){
                network++;
                System.out.println("컴퓨터 확인 "  + i);
                dfs(computers,i);      
            }
        }
    
        
        return network;
    }
}