import java.util.*;

class Solution {
    
    int n;
    int answer = Integer.MAX_VALUE;
    int[][] costs, hints;
    
    public int solution(int[][] cost, int[][] hint) {
        n = cost.length;
        costs = cost;
        hints = hint;
        
        dfs(0, new int[n], 0);
        return answer;
    }
    
    void dfs(int stage, int[] idxes, int total) {
        if (stage == n) {
            answer = Math.min(answer, total);
            return;
        }
        
        int idx = idxes[stage] >= n ? n - 1 : idxes[stage];
        total += costs[stage][idx];
        
        dfs(stage + 1, idxes, total);
        
        if (stage + 1 == n) {
            return;
        }
        
        total += hints[stage][0];
        
        int[] copyIdxes = idxes.clone();
        for (int i = 1; i < hints[stage].length; i++) {
            copyIdxes[hints[stage][i] - 1]++;
        }
        
        dfs(stage + 1, copyIdxes, total);
    }
}