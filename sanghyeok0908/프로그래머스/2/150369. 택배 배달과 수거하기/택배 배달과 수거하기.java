import java.util.*;

class Solution {
    public long solution(int cap, int n, int[] deliveries, int[] pickups) {
        long answer = 0;
        Stack<int[]> dStack = new Stack<>();
        Stack<int[]> pStack = new Stack<>();
        
        for (int i = 0; i < n; i++) {
            if (deliveries[i] != 0) {
                dStack.add(new int[] {i, deliveries[i]});
            }
            
            if (pickups[i] != 0) {
                pStack.add(new int[] {i, pickups[i]});
            }
        }
        
        while(!dStack.isEmpty() && !pStack.isEmpty()) {
            int result = dStack.peek()[0] > pStack.peek()[0] ? dStack.peek()[0] + 1 : pStack.peek()[0] + 1;
            answer += result * 2;
            
            calculate(dStack, cap, 0);
            calculate(pStack, cap, 0);
        }
        
        while(!dStack.isEmpty()) {
            int result = dStack.peek()[0] + 1;
            answer += result * 2;
            calculate(dStack, cap, 0);
        }
        
        while(!pStack.isEmpty()) {
            int result = pStack.peek()[0] + 1;
            answer += result * 2;
            calculate(pStack, cap, 0);
        }
        return answer;
    }
    
    void calculate(Stack<int[]> stack, int cap, int cur) {
        if (stack.isEmpty()) {
            return;
        }
        
        int[] pop = stack.pop();
        
        if (cur + pop[1] < cap) {
            calculate(stack, cap, cur + pop[1]);
        } else if (cur + pop[1] > cap) {
            stack.push(new int[] { pop[0], pop[1] - (cap - cur) });
        }
    }
}