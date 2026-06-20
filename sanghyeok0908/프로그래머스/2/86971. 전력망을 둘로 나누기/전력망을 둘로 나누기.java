import java.util.*;

class Solution {
    
    boolean[][] matrix;
    boolean[] visited;
    int n;
    
    public int solution(int n, int[][] wires) {
        int answer = Integer.MAX_VALUE;
        this.n = n;
        
        matrix = new boolean[n + 1][n + 1];
        
        for (int[] w : wires) {
            matrix[w[0]][w[1]] = true;
            matrix[w[1]][w[0]] = true;
        }
        
        for (int[] w : wires) {
            matrix[w[0]][w[1]] = false;
            matrix[w[1]][w[0]] = false;
            visited = new boolean[n + 1];
            
            int res1 = dfs(w[0]);
            int res2 = dfs(w[1]);
            answer = Math.min(answer, Math.abs(res1 - res2));
            matrix[w[0]][w[1]] = true;
            matrix[w[1]][w[0]] = true;
        }
        return answer;
    }
    
    int dfs(int cur) {
        int cnt = 1;
        visited[cur] = true;
        
        for (int i = 1; i <= n; i++) {
            if (matrix[cur][i] && !visited[i])
                cnt += dfs(i);
        }
        return cnt;
    }
}