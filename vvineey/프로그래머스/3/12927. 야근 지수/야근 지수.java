import java.util.*;

class Solution {
    public long solution(int n, int[] works) {
        
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        
        for (int work : works){
            pq.offer(work);
        }
        
        while  (n > 0) {
            
            int work = pq.poll();
            
            if (work == 0){
                return 0;
            }
            
            work--;
            n--;
            pq.offer(work);
        }
        
        long total = 0;
        
        for (int work : pq){
            total += (long) (work * work);
        }
        
        return total;
    }
}