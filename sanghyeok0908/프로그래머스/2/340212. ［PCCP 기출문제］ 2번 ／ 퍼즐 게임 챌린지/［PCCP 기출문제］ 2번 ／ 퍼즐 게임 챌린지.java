import java.util.*;

class Solution {
    
    public int solution(int[] diffs, int[] times, long limit) {
        int left = 1, right = 100000;
        int answer = Integer.MAX_VALUE;
        
        while(left <= right) {
            int level = (left + right) / 2;
            // System.out.printf("l = %d, m = %d, r = %d\n", left, level, right);
            
            boolean isSuccess = calculate(diffs, times, limit, level);
            if (isSuccess) {
                right = level - 1;
                answer = Math.min(answer, level);
            } else {
                left = level + 1;
            }
        }
        return answer;
    }
    
    boolean calculate(int[] diffs, int[] times, long limit, int level) {
        int n = diffs.length;
        long total = times[0];

        for (int i = 1; i < n; i++) {
            int diff = diffs[i] - level;
            
            if (diff <= 0) {
                total += times[i];
                continue;
            }
            
            total += (long)(times[i - 1] + times[i]) * diff + times[i];
        }
        
        // System.out.printf("level = %d, total = %d, limit = %d\n", level, total, limit);
        return total <= limit;
    }
}