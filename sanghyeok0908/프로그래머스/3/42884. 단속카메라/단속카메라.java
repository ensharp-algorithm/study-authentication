import java.util.*;

class Solution {
    
    Queue<int[]> queue = new PriorityQueue<>((o1, o2) -> {
        if (o1[1] != o2[1]) {
            return Integer.compare(o1[1], o2[1]);
        }
        return Integer.compare(o1[0], o2[0]);
    });
    
    public int solution(int[][] routes) {
        for (int[] route : routes) {
            queue.add(route);    
        }
        
        int prev = -40000;
        int cnt = 0;
        
        while(!queue.isEmpty()) {
            int[] poll = queue.poll();
            int start = poll[0];
            int end = poll[1];
            
            if (prev < start) {
                prev = end;
                cnt++;
            }
        }
        return cnt;
    }
}