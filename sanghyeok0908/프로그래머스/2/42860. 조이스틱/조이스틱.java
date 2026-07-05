import java.util.*;

class Solution {
    
    public int solution(String name) {
        int answer = 0;
        int n = name.length();
        int min = n-1;
        
        for (int i = 0; i < n; i++) {
            // up down
            int value = (int) name.charAt(i) - 'A';
            value = 26 - value < value ? 26 - value : value;
            answer += value;
            
            // if (value == 0) {
            //     continue;
            // }
            
            // side
            int next = i + 1;
            while(next < n && name.charAt(next) == 'A') {
                next++;
            }
            
            // if (next >= n) {
            //     break;
            // }
            
            // 오른쪽 갔다가 왼쪽
            int rightAndLeft = i * 2 + n - next;
            
            // 왼쪽 갔다가 오른쪽
            int leftAndRight = (n - next) * 2 + i;
            
            min = Math.min(min,  Math.min(rightAndLeft, leftAndRight));
            
        }
        return answer + min;
    }
}