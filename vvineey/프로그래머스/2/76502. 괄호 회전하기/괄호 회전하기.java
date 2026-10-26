import java.util.*;

class Solution {
    public int solution(String s) {
        
        int answer = 0;
        
        ArrayDeque<Character> stack = new ArrayDeque<>();
        
        for(int i = 0; i < s.length(); i++){
            stack.offer(s.charAt(i));
        }
        
        for(int i = 0; i < s.length(); i++){
        
            char c = stack.pollFirst();
            stack.offer(c);
            
            
            if (isRight(stack)){
                answer++;
            }
        }
        
        return answer;
    }
    
    private boolean isRight(ArrayDeque<Character> stack){
        
        HashMap<Character, Character> hm = new HashMap<>();
        hm.put('[', ']');
        hm.put('(', ')');
        hm.put('{', '}');
        
        ArrayDeque<Character> queue = new ArrayDeque<>();
        
        for (char c : stack ){
            if (hm.containsKey(c)){
                queue.offer(c);
                continue;
            }
            if (queue.isEmpty()){
                return false;
            }
                
            if(hm.get(queue.peekLast()) != c){
                return false;
            }
            queue.pollLast();
        }
        
        if (queue.size() != 0){
            return false;
        }
        
        return true;
    }
}