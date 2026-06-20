import java.util.*;

class Solution {
    public int solution(int[] sides) {
        int answer = 0;
        int maxIdx = 0;
        
        for (int i = 0; i < sides.length; i++) {
            if (sides[maxIdx] < sides[i]) {
                maxIdx = i;
            }
        }
        
        // minValue + x > sides[maxIdx]
        // 3 + x > 6
        int minValue = sides[maxIdx == 1 ? 0 : 1];
        int cnt = sides[maxIdx] - minValue + 1;
        if (cnt > sides[maxIdx]) {
            cnt = 0;
        } else {
            // System.out.println("max = " + sides[maxIdx] + " cnt = " + cnt);
            answer += sides[maxIdx] - cnt + 1;
        }
        
        // 3 + 6 > x
        int sum = minValue + sides[maxIdx];
        answer += sum - sides[maxIdx] - 1;
        
        return answer;
    }
}