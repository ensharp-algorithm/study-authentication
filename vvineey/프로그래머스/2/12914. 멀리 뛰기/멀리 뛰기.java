class Solution {
    public long solution(int n) {

        //n번째 칸까지 가는 방법의 수 
        int[] dp = new int[n+1];
        dp[0] = 0;
        dp[1] = 1;
        
        if (n < 2) return dp[n];
        
        dp[2] = 2;
        
        for (int i = 3; i<=n ;i++){
            dp[i] = (dp[i-1]+ dp[i-2]) % 1234567;
        }
        return dp[n];
    }
}