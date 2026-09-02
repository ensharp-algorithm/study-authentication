import java.util.*;

class Solution {
    
    static int A;
    static int[][] info;
    static int n, m;
    
    public int solution(int[][] info, int n, int m) {
        
        A = Integer.MAX_VALUE;
        
        this.info = info;
        this.n = n;
        this.m = m;
        
        dp();
        
        return A != Integer.MAX_VALUE ? A : -1;
    }
    
    private void dp() {
        
        // dp[b] = B 흔적이 b일 때 A 흔적 최소
        int[] dp = new int[m];
        Arrays.fill(dp, Integer.MAX_VALUE);
        
        dp[0] = 0;
        
        for (int i = 0; i < info.length; i++) {

            
            int[] next = new int[m];
            Arrays.fill(next, Integer.MAX_VALUE);
            
            for (int b = 0; b < m; b++) {
                
                if (dp[b] == Integer.MAX_VALUE) {
                    continue;
                }
                
                int a = dp[b];

                
                // B 선택
                if (b + info[i][1] < m) {
                    int nextB = b + info[i][1];
                    next[nextB] = Math.min(next[nextB],a);
                }
                
                // A 선택
                if (a + info[i][0] < n) {
                    int nextA = a + info[i][0];
                    next[b] = Math.min(next[b],nextA);
                }
            }
            
            dp = next;
        }
        
        for (int i = 0; i < m; i++) {
            A = Math.min(A, dp[i]);
        }
    }
}