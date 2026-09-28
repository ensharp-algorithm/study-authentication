import java.util.*;

class Solution {
    
    public int solution(int[][] info, int n, int m) {
        int[] dp = new int[m];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        
        for (int[] i : info) {
            int a = i[0];
            int b = i[1];
            
            int[] next = new int[m];
            Arrays.fill(next, Integer.MAX_VALUE);
            for (int j = 0; j < m; j++) {
                if (dp[j] == Integer.MAX_VALUE) {
                    continue;
                }
                
                if (dp[j] + a < n) {
                    next[j] = Math.min(next[j], dp[j] + a);
                }
                if (j + b < m) {
                    next[j + b] = Math.min(next[j + b], dp[j]);
                }
            }
            
            System.out.println("i = " + a + " " + b);
            for (int j = 0; j < m; j++) {
                System.out.print(dp[j] + " ");
            }
            System.out.println();
            dp = next;
        }
        
        int answer = Integer.MAX_VALUE;
        for (int d : dp) {
            answer = Math.min(answer, d);
        }
        return answer == Integer.MAX_VALUE ? -1 : answer;
    }
}