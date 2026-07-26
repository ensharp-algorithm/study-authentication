import java.util.*;

class Solution {
    public String solution(String number, int k) {

        Deque<Character> queue = new ArrayDeque<>();
  
        for (int i = 0; i < number.length();i++){

            // System.out.println(queue.peekLast() + " vs " + number.charAt(i));
            
            while (k > 0 && !queue.isEmpty() && queue.peekLast() < number.charAt(i)){
               
                queue.pollLast();
                k--;
            }
            
            if (queue.size() < number.length() - k){
                queue.offer(number.charAt(i));
            }
            
            
            // System.out.println(queue);
        }
        
        StringBuilder sb = new StringBuilder();
        
        while (!queue.isEmpty()){
            sb.append(queue.poll());
        }
       
        return sb.toString();
    }
}