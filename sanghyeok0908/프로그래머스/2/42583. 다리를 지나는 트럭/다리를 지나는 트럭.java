import java.util.*;

class Solution {
    
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int n = truck_weights.length;
        int curWeight = 0;
        int idx = 0;
        int time = 0;
        Deque<int[]> bridge = new ArrayDeque<>();
        
        while(idx < n) {
            int truck = truck_weights[idx];
            
            time++;
            
            while(!bridge.isEmpty() && bridge_length <= time - bridge.peekFirst()[1]) {
                int[] poll = bridge.pollFirst();
                curWeight -= poll[0];
                // System.out.printf("time = %d, outTime = %d\n", time, poll[1]);
            }
            
            if (curWeight + truck <= weight) {
                curWeight += truck;
                bridge.addLast(new int[] { truck, time });
                // System.out.printf("time = %d, curWeight = %d, idx = %d\n", time, curWeight, idx);
                idx++;
            }
        }
        
        int[] last = bridge.pollLast();
        // System.out.println(time);
        // System.out.println(last[0] + " " + last[1]);
        return time + bridge_length;
    }
}