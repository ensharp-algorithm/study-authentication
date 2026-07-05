import java.util.*;

class Solution {
    public int solution(String name) {
        int answer = 0;
        int move = name.length() - 1;
    
        
        for (int i = 0; i < name.length();i++){
            
            char c = name.charAt(i);
            //오른쪽 (목표 - A)
            int right = c - 'A';

            //왼쪽 (z-묙표 +1)
            int left = 'Z' - c +1;

            answer += Math.min(right,left);
            
            //다음에 처리해야 할 문자 위치 찾기 
            int next = i+1;
            while (next < name.length() && name.charAt(next) == 'A'){
                next++;
            }
            
            System.out.println(next);
            
            //1. 순방향으로만 처리 
            //name.length() - 1
            
            //2. 순방향으로 처리 -> 역방향으로 처리 
            int case2 = i * 2 + name.length()- next;
            
            //3. 역방향 처리 -> 순방향으로 처리 
            int case3 = (name.length()- next) *2 + i;
            
            
            move = Math.min(move,Math.min(case2,case3));
            
        }
        
    return answer + move;
    }
}
