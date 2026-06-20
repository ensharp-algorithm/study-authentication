import java.util.*;

class Solution {
    
    int N;
    boolean[] buy;
    int[][] cost, hint;
    int answer = Integer.MAX_VALUE;

    public int solution(int[][] c, int[][] h) {
        this.N = c.length;
        cost = c;
        hint = h;
        buy = new boolean[N - 1];
        
        dfs(0);
        return answer;
    }
    
    void dfs(int depth) {
        if (depth == N - 1) {
            answer = Math.min(answer, solve());
            return;
        }
        
        buy[depth] = !buy[depth];
        dfs(depth + 1);
        buy[depth] = !buy[depth];
        dfs(depth + 1);
    }
    
    int solve() {
        int result = 0;
        int[] costIdxes = new int[N];

        for (int i = 0; i < N; i++) {
            int idx = Math.min(costIdxes[i], N - 1);
            result += cost[i][idx];

            if (i < N - 1 && buy[i]) {
                result += hint[i][0];

                for (int j = 1; j < hint[i].length; j++) {
                    costIdxes[hint[i][j] - 1]++;
                }
            }
        }
        return result;
    }
}