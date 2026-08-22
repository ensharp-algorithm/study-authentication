class Solution {
    
    int[] dp;
    
    public int solution(int n, int[] money) {
        dp = new int[100001];
        dp[0] = 1;
        
        for (int m : money) {
            for (int i = m; i <= n; i++) {
                dp[i] = (dp[i] + dp[i - m]) % 1000000007;
            }    
        }
        
        // for (int i = 0; i <= n; i++) {
        //     System.out.println(i + ": " + dp[i]);
        // }
        return dp[n];
    }
}