import java.util.*;

class Solution {
    
    public long solution(int n, int[] works) {
       
        PriorityQueue<Integer> pq = new PriorityQueue<>((o1,o2)->{
            return Integer.compare(o2,o1);
        });
        
        for (int work : works){
            pq.offer(work);
        }
        
        int cnt = 0;
        
        while (cnt < n && !pq.isEmpty()){
            
            int tmp = pq.poll();
            // System.out.println(tmp);
            
            if (tmp > 0){
                tmp--;
            }
            
            pq.offer(tmp);
            cnt++;
        }
        
        
        long total = 0;
        
        while (!pq.isEmpty()){
            
            int tmp = pq.poll();
            
            // System.out.println(" > " + tmp);
            total += tmp*tmp;
        }
        
        
        return total;
    }
}