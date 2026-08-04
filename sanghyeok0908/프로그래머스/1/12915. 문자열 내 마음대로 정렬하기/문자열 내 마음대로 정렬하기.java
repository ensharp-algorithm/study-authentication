import java.util.*;

class Solution {
    
    public String[] solution(String[] strings, int n) {
        Queue<String> queue = new PriorityQueue<>((o1, o2) -> {
            if (o1.charAt(n) != o2.charAt(n)) {
                return Character.compare(o1.charAt(n), o2.charAt(n));
            }
            return o1.compareTo(o2);
        });  
        for (String str : strings) {
            queue.add(str);
        }
        
        String[] answer = new String[queue.size()];
        int idx = 0;
        while(!queue.isEmpty()) {
            answer[idx++] = queue.poll();
        }
        return answer;
    }
}