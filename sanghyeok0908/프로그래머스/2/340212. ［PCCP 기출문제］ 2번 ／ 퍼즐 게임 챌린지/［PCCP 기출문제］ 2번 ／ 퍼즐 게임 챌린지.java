import java.util.*;

class Solution {
    
    int n;
    
    public int solution(int[] diffs, int[] times, long limit) {
        int left = 1, right = 100000;
        int answer = right;
        n = diffs.length;
        
        while(left <= right) {
            int mid = (left + right) / 2;
            long total = func(diffs, times, mid);
            
            // System.out.printf("left = %d, right = %d, mid = %d, total = %d\n", left, right, mid, total);
            if (total <= limit) {
                answer = Math.min(answer, mid);
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return answer;
    }
    
    long func(int[] diffs, int[] times, long level) {
        long result = times[0];
        
        for (int i = 1; i < n; i++) {
            if (diffs[i] <= level) {
                result += times[i];
                continue;
            }
            
            result += (diffs[i] - level) * (times[i - 1] + times[i]) + times[i];
        }
        return result;
    }
}