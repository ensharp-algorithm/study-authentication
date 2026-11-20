import java.util.*;

class Solution {
    
    int[][] dp;
    List<Integer>[] edges;
    
    public int solution(int n, int[][] lighthouse) {
        dp = new int[n + 1][2];
        edges = new ArrayList[n + 1];
        
        for (int i = 1; i <= n; i++) {
            edges[i] = new ArrayList<>();
        }
        
        for (int[] l : lighthouse) {
            edges[l[0]].add(l[1]);
            edges[l[1]].add(l[0]);
        }
        
        dfs(1, 0);
        return Math.min(dp[1][0], dp[1][1]);
    }
    
    void dfs(int cur, int parent) {
        dp[cur][1] = 1;
        
        for (int child : edges[cur]) {
            if (child == parent) {
                continue;
            }
            
            dfs(child, cur);

            dp[cur][0] += dp[child][1];
            dp[cur][1] += Math.min(dp[child][0], dp[child][1]);
        }
    }
}