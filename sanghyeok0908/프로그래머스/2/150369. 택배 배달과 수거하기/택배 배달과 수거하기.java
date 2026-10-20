import java.util.*;

class Solution {
    
    public long solution(int cap, int n, int[] deliveries, int[] pickups) {
        int deliveryIdx = getInitValue(n, deliveries);
        int pickupIdx = getInitValue(n, pickups);
        long answer = 0;
        
        while(deliveryIdx >= 0 || pickupIdx >= 0) {
            answer += (Math.max(deliveryIdx, pickupIdx) + 1) * 2;
            
            if (deliveryIdx >= 0)
                deliveryIdx = delivery(cap, n, deliveries, deliveryIdx);
            if (pickupIdx >= 0)
                pickupIdx = delivery(cap, n, pickups, pickupIdx);
        }
        return answer;
    }
    
    int getInitValue(int n, int[] deliveries) {
        int idx = n - 1;
        
        while(idx >= 0 && deliveries[idx] == 0) {
            idx--;
        }
        return idx;
    }
        
    int delivery(int cap, int n, int[] deliveries, int idx) {
        int remaining = cap;

        while(idx >= 0 && remaining > 0) {
            if (deliveries[idx] == 0) {
                idx--;
                continue;
            }

            while(idx >= 0 && deliveries[idx] <= remaining) {
                remaining -= deliveries[idx];
                deliveries[idx--] = 0;
            }
            
            if (idx >= 0 && deliveries[idx] > remaining) {
                deliveries[idx] -= remaining;
                remaining = 0;
            }
        }
        return idx;
    }
}