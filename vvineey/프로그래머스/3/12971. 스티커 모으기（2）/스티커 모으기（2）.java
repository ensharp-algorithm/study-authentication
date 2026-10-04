import java.util.*;

class Solution {
    public int solution(int sticker[]) {
        
        if (sticker.length == 1){
            return sticker[0];
        }
        
        int[] dp = new int[sticker.length];
        
        //dp[i] = i번째 스티커까지 고려했을 때 얻을 수 있는 최댓값
        Arrays.fill(dp, 0);
        
        //0번을 쓰는 경우 -> 1을 못 쓴다
        dp[0] = sticker[0];
        dp[1] = sticker[0];
        
        for (int i = 2; i < sticker.length-1; i++){
            //현재 스티커 사용 
            dp[i] = Math.max(dp[i], dp[i-2] + sticker[i]);
            
            //현재 스티커 사용 x
            dp[i] = Math.max(dp[i],dp[i-1]);
        }
        
        int case1 = dp[sticker.length-2];
        
        Arrays.fill(dp, 0);
        //0번을 안 쓰는 경우 -> 1을 쓴다
        dp[0] = 0;
        dp[1] = sticker[1];
        
        for (int i = 2; i < sticker.length; i++){
            //현재 스티커 사용 
            dp[i] = Math.max(dp[i], dp[i-2] + sticker[i]);
            
            //현재 스티커 사용 x
            dp[i] = Math.max(dp[i],dp[i-1]);
        }
        
        int case2 = dp[sticker.length-1];
        return Math.max(case1,case2);
    }
}