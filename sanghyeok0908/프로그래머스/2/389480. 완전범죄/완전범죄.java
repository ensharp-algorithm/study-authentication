import java.util.*;

class Solution {
    
    int[][] dp;
    
    public int solution(int[][] info, int n, int m) {
        dp = new int[info.length][m];
        for (int i = 0; i < info.length; i++)
            Arrays.fill(dp[i], -1);
        
        int answer = dfs(info, m, 0, 0);
        return answer >= n ? -1 : answer;
    }
    
    int dfs(int[][] info, int m, int depth, int bSum) {
        if (depth == info.length) {
            return 0;
        }
        
        if (dp[depth][bSum] != -1) {
            return dp[depth][bSum];
        }
        
        int a = info[depth][0] + dfs(info, m, depth + 1, bSum);
        int b = Integer.MAX_VALUE;
        
        if (bSum + info[depth][1] < m) {
            b = dfs(info, m, depth + 1, bSum + info[depth][1]);
        }
        return dp[depth][bSum] = Math.min(a, b);
    }
}