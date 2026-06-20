import java.util.*;

class Solution {  
    
    public String solution(int[] numbers) {
        Queue<String> q = new PriorityQueue<>((o1, o2) -> {
            String str1 = o1 + o2;
            String str2 = o2 + o1;
            return Integer.compare(Integer.parseInt(str1), Integer.parseInt(str2)) * -1;
        });
        
        for (int num : numbers) {
            q.add(Integer.toString(num));    
        }
        
        if (q.peek().equals("0")) {
            return "0";
        }
        
        StringBuilder sb = new StringBuilder();
        while(!q.isEmpty()) {
            sb.append(q.poll());
        }
        return sb.toString();
    }
}