import java.util.*;

class Solution {
    public int[] solution(int[] prices) {
        int n = prices.length;
        Stack<int[]> stack = new Stack<>();
        int[] answer = new int[n];
        
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && stack.peek()[1] > prices[i]) {
                int[] pop = stack.pop();
                answer[pop[0]] = i - pop[0];
            }
            
            stack.push(new int[] { i, prices[i] });
        }
        
        while(!stack.isEmpty()) {
            int[] pop = stack.pop();
            answer[pop[0]] = n - pop[0] - 1;
        }
        
        return answer;
    }
}