import java.util.*;

class Solution {
    public int[] solution(int[] sequence, int k) {
       
        PriorityQueue<int[]> queue = new PriorityQueue<>((o1,o2)->{
            int length1 = o1[1]- o1[0];
            int length2 = o2[1]- o2[0];
            if (length1 != length2){
                return Integer.compare(length1, length2);
            }
            
            return Integer.compare(o1[0],o2[0]);
        });
        
        int left = 0;
        int sum = 0;
        
        for (int right = 0; right < sequence.length; right++){
            
            sum += sequence[right];
            
            while (sum > k){
                sum -= sequence[left];
                left++;
            }
            
            if (sum == k){
                queue.offer(new int[]{left, right});
            }
            
        }
        
        
        return queue.poll();
    }
}