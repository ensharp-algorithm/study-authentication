import java.util.*;

class Solution {
    public long solution(int cap, int n, int[] deliveries, int[] pickups) {

        PriorityQueue<Integer> deliveryQueue  = new PriorityQueue<>((o1,o2)->{
            return Integer.compare(o2,o1);
        });
        
        PriorityQueue<Integer> pickupQueue  = new PriorityQueue<>((o1,o2)->{
            return Integer.compare(o2,o1);
        });
        
        
        for (int i = 0; i < n; i++){
            if (deliveries[i] != 0){
                deliveryQueue.offer(i);
            }
            if (pickups[i] != 0){
                pickupQueue.offer(i);
            }
        }
        
        int truck = 0;
        int deliveryDes = n-1;
        int pickupDes = n-1;
        long  total = 0;
        
        
        while (!deliveryQueue.isEmpty() || !pickupQueue.isEmpty()){
            // System.out.println("> " + deliveryQueue);
            // System.out.println("> " +pickupQueue);
         
            int turn = Integer.MIN_VALUE;
            
            //배달
            while(!deliveryQueue.isEmpty() && truck < cap) {
                deliveryDes = deliveryQueue.peek();
                turn = Math.max(turn,deliveryDes+1);
                
                //전부 배달 가능 
                if (truck + deliveries[deliveryDes] <= cap){
                    truck += deliveries[deliveryDes];
                    deliveries[deliveryDes] = 0;
                    deliveryQueue.poll();
                } 
                //일부만 배달 가능
                else{
                    deliveries[deliveryDes] -= (cap- truck);
                    truck = cap;
                }
            }
            
            truck = 0;
            
            //수거
             while(!pickupQueue.isEmpty() && truck < cap) {
                pickupDes = pickupQueue.peek();
                turn = Math.max(turn,pickupDes+1);
                
                //전부 수거 가능 
                if (truck + pickups[pickupDes] <= cap){
                    truck += pickups[pickupDes];
                    pickups[pickupDes] = 0;
                    pickupQueue.poll();
                } 
                //일부만 수거 가능
                else{
                    pickups[pickupDes] -= (cap- truck);
                    truck = cap;
                }
            }
            
            truck = 0;
            total+= turn *2;

        }
        
        return total;
    }
}