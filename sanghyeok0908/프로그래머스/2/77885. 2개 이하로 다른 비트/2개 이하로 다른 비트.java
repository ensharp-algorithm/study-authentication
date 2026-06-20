import java.util.*;

class Solution {
    public long[] solution(long[] numbers) {
        int N = numbers.length;
        long[] answer = new long[N];
        
        for (int i = 0; i < N; i++) {
            long number = numbers[i];
            
            if (number % 2 == 0) {
                answer[i] = number + 1;
                continue;
            }
            
            long oneBit = (~number) & (number + 1);
            answer[i] = (number | oneBit) & (~(oneBit >> 1));
        }
        
        return answer;
    }
}