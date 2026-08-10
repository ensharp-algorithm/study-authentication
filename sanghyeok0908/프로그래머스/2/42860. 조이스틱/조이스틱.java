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
            
            // side
            int next = i + 1;
            while(next < n && name.charAt(next) == 'A') {
                next++;
            }
            
            // 현재까지 정방향으로 왔다가 되돌아서 next까지 가기
            int rightAndLeft = i * 2 + n - next;
            
            // 반대 방향으로 next까지 갔다가 현재까지 돌아오기
            int leftAndRight = (n - next) * 2 + i;
            
            min = Math.min(min,  Math.min(rightAndLeft, leftAndRight));
        }
        return answer + min;
    }
}