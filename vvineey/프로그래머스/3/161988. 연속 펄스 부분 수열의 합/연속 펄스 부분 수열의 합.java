import java.util.*;

class Solution {
    public long solution(int[] sequence) {
        
        int n = sequence.length;        
        long[][] dp = new long[n][2];
        
                
        int standard = -1;
        long answer = Long.MIN_VALUE;
        
        dp[0][0] = sequence[0] * standard;
        standard *= -1;
        dp[0][1] = sequence[0] * standard;
        
        answer = Math.max(answer,Math.max(dp[0][0] ,dp[0][1] ));
        
        for(int i = 1; i < n; i++){
            //dp[][0]
            dp[i][0] = Math.max(sequence[i] * standard, dp[i-1][0] + sequence[i] * standard);
            standard *= -1;
            //dp[][1]
            dp[i][1] = Math.max(sequence[i] * standard, dp[i-1][1] + sequence[i] * standard);
            answer = Math.max(answer,Math.max(dp[i][0] ,dp[i][1] ));
        }
        
        return answer;
    }
}