import java.util.*;

class Solution {
    int result;
    boolean[] visited ;
    int n;
    
    public int solution(int k, int[][] dungeons) {
        
        result = 0;
        n = dungeons.length;
        visited = new boolean[n];
        
        dfs(k,dungeons,0,0);
        
        return result;
    }
    
    private void dfs(int k, int[][] dungeons, int idx, int cnt){
        
        result = Math.max(result, cnt);
        
        if (idx == n){
            return;
        }
  
        for (int i = 0; i < n; i++){
            
            if (visited[i]){
                continue;
            }
            
            if (k < dungeons[i][0]){
                continue;
            }
            
            
            visited[i] = true;
            k -= dungeons[i][1];
            
            dfs(k,dungeons,idx + 1,cnt + 1);

            visited[i] = false;
            k += dungeons[i][1];
        }
    }
}