import java.util.*;

class Solution {

    public String solution(String number, int k) {
        int n = number.length();
        Stack<Integer> stack = new Stack<>();
        int curK = k;
        
        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(number.substring(i, i + 1));
            
            while (curK > 0 && !stack.isEmpty() && stack.peek() < num) {
                curK--;
                stack.pop();   
            }
            stack.push(num);
        }
        
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n - k; i++) {
            sb.append(stack.get(i));
        }
        
        return sb.toString();
    }
}