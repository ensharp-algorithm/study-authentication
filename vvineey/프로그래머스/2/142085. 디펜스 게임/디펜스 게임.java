import java.util.*;

class Solution {
    public int solution(int n, int k, int[] enemy) {
        
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        
        for(int i = 0; i < enemy.length; i++){
            n -= enemy[i];
            pq.offer(enemy[i]);
            
            if (n < 0){
                
                if (k < 1){
                    return i;
                }
                
                k--;
                n += pq.poll();
            }
        }
        
        return enemy.length;
    }
}