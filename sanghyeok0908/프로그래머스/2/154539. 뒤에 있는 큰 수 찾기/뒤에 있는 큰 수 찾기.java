import java.util.*;

class Solution {
    
    public int[] solution(int[] numbers) {
        Deque<int[]> stack = new ArrayDeque<>();
        int[] answer = new int[numbers.length];
        Arrays.fill(answer, -1);
        
        for (int i = 0; i < numbers.length; i++) {
            while (!stack.isEmpty() && stack.peek()[1] < numbers[i]) {
                int[] tmp = stack.pop();
                answer[tmp[0]] = numbers[i];
            }
            
            stack.push(new int[] { i, numbers[i] });
        }
        return answer;
    }
}