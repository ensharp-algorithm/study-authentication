import java.util.*;

class Solution {
    
    public long solution(int n, int[] times) {
        long answer = 0;
        long left = 1, right = 1;
        for (int t : times) {
            right = Math.max(right, t);
        }
        right *= n;
        
        while(left <= right) {
            long mid = (left + right) / 2;
            long sum = 0;
            
            for (int t : times) {
                sum += mid / t;
            }
            
            // System.out.printf("l = %d, r = %d, m = %d, sum = %d\n", left, right, mid, sum);
            
            if (sum >= n) {
                answer = mid;
                right = mid - 1;
            } else if (sum < n) {
                left = mid + 1;
            }
        }
        
        return answer;
    }
}