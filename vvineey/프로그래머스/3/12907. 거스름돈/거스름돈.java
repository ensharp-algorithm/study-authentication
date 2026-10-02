import java.util.*;

class Solution {
    public int solution(int n, int[] money) {
       
        int[][] dp = new int[money.length+1][n+1];
        
        for (int i = 0; i <= money.length; i++) {
            dp[i][0] = 1;
        }
        
        for (int idx = 0; idx < money.length; idx++){
            // System.out.println(idx + " 번째 동전까지 사용 : " + money[idx]);
            
            for (int sum = 1; sum <= n; sum++){
                
                // System.out.println(sum + " 을 만들기");
                //안 쓰는 경우임 그 다음 경우로 이전 
                dp[idx+1][sum] = dp[idx][sum];
                
                //현재 동전 사용하는 경우 
                if (sum >= money[idx]) {
                    // System.out.println("> " + money[idx] + " 사용 ");
                    
                    dp[idx+1][sum] += dp[idx+1][sum- money[idx]];
                                        
                    // for (int[] row : dp){
                    //     System.out.println(Arrays.toString(row));
                    // }
                }
            }
        }

        
        
        return dp[money.length][n];
    }
}