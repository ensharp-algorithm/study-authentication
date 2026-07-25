import java.util.*;

class Solution {
    
    public int solution(int distance, int[] rocks, int n) {
        int left = 0, right = 1000000000;
        int answer = 0;
        
        Arrays.sort(rocks);
        
        while(left <= right) {
            int mid = (left + right) / 2; // 최솟값
            int removedCnt = calculate(distance, rocks, mid);
            
            if (removedCnt <= n) {
                left = mid + 1;
                answer = mid;
            } else {
                right = mid - 1;
            }
        }
        return answer;
    }
    
    int calculate(int distance, int[] rocks, int value) {
        int cnt = 0;
        int prev = 0;
        
        // System.out.println("value = " + value);
        for (int i = 0; i < rocks.length; i++) {
            if (rocks[i] - prev < value) {
                cnt++;
                // System.out.println("idx = " + i + " dist = " + (rocks[i] - prev));
                continue;
            }
            prev = rocks[i];
        }
        if (distance - prev < value) {
            cnt++;
            // System.out.println("idx = " + (rocks.length - 1) + " dist = " + (rocks[rocks.length - 1] - prev));
        }
        System.out.println();
        
        // System.out.println("cnt = " + cnt + " " + (cnt <= n));
        return cnt;
    }
}