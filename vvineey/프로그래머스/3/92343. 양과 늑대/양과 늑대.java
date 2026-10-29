import java.util.*;

class Solution {
    static int answer = 0;
    
    public int solution(int[] info, int[][] edges) {
        
        Solution.answer = 0;
        int[] parent = new int[info.length];

        
        for (int[] edge : edges){
            parent[edge[1]] = edge[0];
        }
        
        boolean[] visited = new boolean[info.length];
        int[] state = new int[]{1,0};
        visited[0] = true;
        
        dfs(info, visited,parent, state, 0,0);

        return answer;
    }
    
    private void dfs(int[] info, boolean [] visited,int[] parent, int[] state, int idx, int depth){
        
        answer = Math.max(answer, state[0]);
        
        if (depth >= info.length){
            return;
        }
        
        for (int next = 1; next < info.length; next++){
            
            if (visited[next] || !visited[parent[next]]) continue;
            
            if (info[next] == 1 && state[0] <= state[1] + 1){
                continue;
            }
            
            state[info[next]]++;
            visited[next] = true;
            
            dfs(info, visited,parent, state, next, depth+1);
            
            state[info[next]]--;
            visited[next] = false;

        }
    }
}