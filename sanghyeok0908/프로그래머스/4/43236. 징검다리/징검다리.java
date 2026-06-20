import java.util.*;

class Solution {

    public int solution(int distance, int[] rocks, int n) {
        int left = 1, right = distance;
        int answer = 0;
        
        Arrays.sort(rocks);
        while(left <= right) {
            int mid = (left + right) / 2; // 최소 거리
            int prev = 0, removeCnt = 0;
            
            for (int r : rocks) {
                int len = r - prev;
                
                if (mid > len) {
                    removeCnt++;
                    
                    if (removeCnt > n) {
                        break;
                    }
                } else {
                    prev = r;   
                }
            }
            // System.out.printf("l = %d, r = %d, removeCnt = %d\n", left, right, removeCnt);            
            
            if (distance - prev < mid) {
                removeCnt++;
            }
            
            if (removeCnt > n) {
                right = mid - 1;
            } else {
                answer = Math.max(answer, mid);
                left = mid + 1;      
            }
        }
        
        return answer;
    }
    
    
}