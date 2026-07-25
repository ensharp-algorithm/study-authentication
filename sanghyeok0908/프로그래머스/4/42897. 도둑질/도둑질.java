class Solution {
    
    int n;
    
    public int solution(int[] money) {
        n = money.length;
        return Math.max(dp(money, 0, n - 2), dp(money, 1, n - 1));
    }
    
    int dp(int[] money, int start, int end) {
        int take = 0; // 직전 집을 턴 경우의 최댓값
        int skip = 0; // 직전 집을 털지 않은 경우의 최댓값
        
        for (int i = start; i <= end; i++) {
            int nextTake = skip + money[i];
            int nextSkip = Math.max(skip, take);
            
            take = nextTake;
            skip = nextSkip;
        }
        return Math.max(skip, take);
    }
}