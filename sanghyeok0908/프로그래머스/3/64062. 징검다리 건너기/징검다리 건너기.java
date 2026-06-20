class Solution {
    public int solution(int[] stones, int k) {
        int n = stones.length;
        int left = 0, right = 200000000;
        int answer = 0;
        
        while(left <= right) {
            int mid = (left + right) / 2; // 사람 수
            int skipCnt = k;
            
            for (int i = 0; i < n; i++) {
                if (skipCnt <= 0) {
                    break;
                }
                
                if (stones[i] < mid) {
                    skipCnt--;
                } else {
                    skipCnt = k;
                }
            }
            
            if (skipCnt <= 0) {
                right = mid - 1;
            } else {
                answer = mid;
                left = mid + 1;
            }
        }
        
        return answer;
    }
}