import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        for (int i : scoville) {
            pq.offer(i);
        }
        
        while(!pq.isEmpty() && pq.peek() < K){
            
            int first = pq.poll();
            
            if (!pq.isEmpty()) {
                int second =  pq.poll(); 
                
                pq.offer(mix(first,second));
                answer ++;
            }
            
            else{
                return -1;
            }
     
        }
        
        
         return answer;
    }
    
    
    private int mix(int x,int y){
        return x + (y*2);
    }
}
