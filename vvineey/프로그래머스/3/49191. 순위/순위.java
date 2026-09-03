import java.util.*;

class Solution {
    
    static HashSet<Integer>[] graph;
    static HashSet<Integer>[] win;
    static HashSet<Integer>[] lose;

    public int solution(int n, int[][] results) {
        
        graph = new HashSet[n+1];
        win = new HashSet[n+1];
        lose = new HashSet[n+1];
        
        for (int i = 1; i <= n; i++){
            graph[i] = new HashSet<>();
            win[i] = new HashSet<>();
            lose[i] = new HashSet<>();
        }
        
        for (int[] result : results) {
            int winner = result[0];
            int loser = result[1];
            
            graph[winner].add(loser);
        }
        
        for (int i = 1; i <= n; i++) {

            boolean[] visited = new boolean[n+1];
            visited[i] = true;
            dfs(i, i, visited);
        }
        
        
        int answer = 0;
        
        for (int i = 1; i <= n; i++){
            
            if (win[i].size() + lose[i].size() == n-1){
                answer++;
            }
        }
        
        return answer;  
    }

    private void dfs(int root, int current, boolean[] visited) {

        for (Integer next : graph[current]) {

            if (visited[next]) {
                continue;
            }

            visited[next] = true;

            win[root].add(next);
            lose[next].add(root);

            dfs(root, next, visited);
        }
    }
}