import java.util.*;

class Solution {
    
    int answer; 
    boolean[] visited;
    int[] parents;
    
    public int solution(int[] info, int[][] edges) {
        
        int n = info.length;
        answer = Integer.MIN_VALUE;
        visited = new boolean[n];
        parents = new int[n];
        
        for (int [] edge : edges){
            parents[edge[1]] = edge[0];
        }
        
        parents[0] = 0;
        visited[0] = true;
        
        dfs(info, 0, new int[]{1,0});
        
        return answer;
    }
    
    
    private void dfs(int[] info, int depth, int[] status){
        
        //모든 가지마다 양의 수 비교
        answer = Math.max(answer, status[0]);
        
        if (depth == info.length){
            return;
        }
        
        for (int i = 1; i < info.length; i++){
            
            if (visited[i] || !visited[parents[i]]){
                continue;
            }
            
            if (status[0] == status[1] + info[i]){
                continue;
            }
            
            //선택
            visited[i] = true;
            status[info[i]]++;
            
            dfs(info, depth +1, status);
            
            //미선택
            visited[i] = false;
            status[info[i]]--;
        }
    }
}