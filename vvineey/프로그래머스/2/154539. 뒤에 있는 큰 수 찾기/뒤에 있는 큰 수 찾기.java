import java.util.*;

class Solution {
    public int[] solution(int[] numbers) {
        
        Deque<Integer> stack = new ArrayDeque<>();
         
        int n = numbers.length;
        int[] answer = new int[n];
        Arrays.fill(answer, -1);
        
        for (int i = 0; i < n; i++){
            
            //스택이 빌 때까지 배정함
            while(!stack.isEmpty() && numbers[i] > numbers[stack.peek()]){
                
                // System.out.println(numbers[i] + " vs stk :"   + numbers[stack.peek()]);
                
                answer[stack.pop()] = numbers[i];
    
            }
            
            stack.push(i);
        }
        
        return answer;
    }
}                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                            