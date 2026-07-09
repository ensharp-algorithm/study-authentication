import java.util.*;

class Solution {
    public String solution(String number, int k) {
        
        StringBuilder sb = new StringBuilder();
        
        int n = number.length();
        
        Stack <Character> stack = new Stack<>();
        
        for (int i = 0; i < n ; i++){
            
            // 
            Character c = number.charAt(i);
        
            while (!stack.isEmpty()&& k > 0 && stack.peek() < c){
        
                // System.out.println("pop " +  stack.peek());
                    
                stack.pop();
                k--;
                }
            
            if (stack.size() < n-k){
                stack.push(c);
                // System.out.println("push " + c);
            }
        }
        
         // System.out.println("stack.size() " + stack.size());
        
        
        
        while(!stack.isEmpty()){
            sb.append(stack.pop());
        }
        
        
        return sb.reverse().toString();
    }
}