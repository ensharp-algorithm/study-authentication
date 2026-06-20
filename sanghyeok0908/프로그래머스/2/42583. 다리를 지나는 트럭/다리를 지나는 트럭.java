import java.util.*;

class Solution {
    
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int n = truck_weights.length;
        Queue<int[]> queue = new ArrayDeque<>();
        int time = 0, idx = 0, total = 0;
        
        while(idx < n) {
            time++;
            
            for (int[] truck : queue) {
                truck[0]++;
            }
            
            if (!queue.isEmpty() && queue.peek()[0] == bridge_length + 1) {
                total -= queue.poll()[1];
            }
            
            if (queue.size() < bridge_length && total + truck_weights[idx] <= weight) {
                total += truck_weights[idx];
                queue.add(new int[]{1, truck_weights[idx++]});
            }
        }
        
        return time + bridge_length;
    }
}