import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        Queue<Integer> queue = new PriorityQueue<>();
        int cnt = 0;
        
        for (int i = 0; i < scoville.length; i++) {
            queue.add(scoville[i]);
        }
        
        while(queue.peek() < K) {
            if (queue.size() < 2) {
                return -1;
            }
            
            int first = queue.poll();            
            int result = first + queue.poll() * 2;
            
            if (result == first) {
                return -1;
            }
            
            cnt++;
            queue.add(result);
        }
        return cnt;
    }
}