import java.util.*;

class Solution {  
    
    public String solution(int[] numbers) {
        Queue<String> queue = new PriorityQueue<>((o1, o2) -> {
            String str1 = o1 + o2;
            String str2 = o2 + o1;
            return str2.compareTo(str1);
        });
        
        for(int num : numbers) {
            queue.add(num + "");
        }
        
        StringBuilder sb = new StringBuilder();
        while(!queue.isEmpty()) {
            sb.append(queue.poll());
        }
        
        String answer = sb.toString();
        if (answer.startsWith("0")) {
            return "0";
        }
        return answer;
    }
}