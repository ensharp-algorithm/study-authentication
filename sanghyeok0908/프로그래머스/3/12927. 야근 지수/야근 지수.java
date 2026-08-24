import java.util.*;

class Solution {
    
    Queue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
    
    public long solution(int n, int[] works) {
        for (int w : works) {
            queue.add(w);
        }
        
        while(!queue.isEmpty() && n > 0) {
            Integer max = queue.poll();
            max--;
            n--;
            if (max > 0)
                queue.add(max);
        }
        
        long answer = 0;
        while(!queue.isEmpty()) {
            int poll = queue.poll();
            answer += Math.pow(poll, 2);
            // System.out.println(poll[0] + " " + poll[1]);
        }
        return answer;
    }
}