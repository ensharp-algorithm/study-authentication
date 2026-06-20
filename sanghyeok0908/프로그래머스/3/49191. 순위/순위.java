import java.util.*;

class Solution {
    
    Set<Integer>[] topDp, bottomDp;
    List<Integer>[] top, bottom;
    
    public int solution(int n, int[][] results) {
        top = new ArrayList[n + 1];
        bottom = new ArrayList[n + 1];
        topDp = new HashSet[n + 1];
        bottomDp = new HashSet[n + 1];
        
        for (int i = 1; i <= n; i++) {
            top[i] = new ArrayList<>();
            bottom[i] = new ArrayList<>();
            topDp[i] = new HashSet<>();
            bottomDp[i] = new HashSet<>();
        }
        
        for (int[] result : results) {
            bottom[result[0]].add(result[1]);
            top[result[1]].add(result[0]);
        }
        
        int answer = 0;
        for (int i = 1; i <= n; i++) {
            Set<Integer> topSet = dfs(i, topDp, top);
            Set<Integer> bottomSet = dfs(i, bottomDp, bottom);
            
            int topCnt = topSet.size() - 1;
            int bottomCnt = bottomSet.size() - 1;
            
            // System.out.printf("%d top = %d, bottom = %d\n", i, topCnt, bottomCnt);
            
            if (topCnt + bottomCnt == n - 1) {
                answer++;
            }
        }
        
        return answer;
    }
    
    Set<Integer> dfs(int cur, Set<Integer>[] dp, List<Integer>[] edges) {
        if (!dp[cur].isEmpty()) {
            return dp[cur];
        }
        
        Set<Integer> temp = new HashSet<>();
        temp.add(cur);
        
        for (int next : edges[cur]) {
            temp.addAll(dfs(next, dp, edges));        
        }
        
        dp[cur] = temp;
        return temp;
    }
}