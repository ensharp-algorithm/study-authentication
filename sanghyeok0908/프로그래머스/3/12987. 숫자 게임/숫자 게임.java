import java.util.*;

class Solution {

    public int solution(int[] A, int[] B) {
        Queue<Integer> aq = new PriorityQueue<>(), bq = new PriorityQueue<>();
        for (int i = 0; i < A.length; i++) {
            aq.add(A[i]);
            bq.add(B[i]);
        }
        
        while(!aq.isEmpty() && !bq.isEmpty()) {
            // System.out.println("A = " + aq.peek());
            
            while(!bq.isEmpty() && bq.peek() <= aq.peek()) {
                int temp = bq.poll();
                // System.out.println("bq poll = " + temp);
            }
            
            if (!bq.isEmpty()) {
                int temp = bq.poll();
                // System.out.println("bq compare " + temp);
                aq.poll();
            }
        }
        return A.length - aq.size();
    }
}