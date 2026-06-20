import java.util.*;

class Solution {
    
    int n;
    boolean[] visited;
    int answer = 0;
    int[][] dungeons;
    
    public int solution(int k, int[][] dungeons) {
        this.dungeons = dungeons;
        n = dungeons.length;
        visited = new boolean[n];
        
        dfs(k, 0);
        return answer;
    }
    
    void dfs(int cur, int cnt) {
        for (int i = 0; i < n; i++) {
            if (visited[i] || dungeons[i][0] > cur) {
                continue;
            }
            
            visited[i] = true;
            dfs(cur - dungeons[i][1], cnt + 1);
            visited[i] = false;
        }
        
        answer = Math.max(answer, cnt);
    }
}