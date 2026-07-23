import java.util.*;

class Solution {
    
    

    public int solution(int bridge_length, int weight, int[] truck_weights) {
        
        Queue<Integer> wait = new ArrayDeque<>();
        Queue<Integer> bridge = new ArrayDeque<>();
 
   
        for (int i = 0; i < truck_weights.length; i++){
            wait.offer(truck_weights[i]);
        }
        
        for (int i = 0; i < bridge_length; i++){
            bridge.offer(0);
        }
        
        int currentTime = 0;
        int currentWeight = 0;
        int currentTruck = 0;
        
        //0을 넣어서 큐를 관리한다
        
        while(!wait.isEmpty() || currentWeight != 0){
            
            // ///
            // System.out.println(currentTime + "초");
            // System.out.println(wait);
            // System.out.println(bridge);
            // System.out.println();
            // ///
            
            currentTime++;
            currentWeight -= bridge.poll();
        
            if (!wait.isEmpty()){
                currentTruck = wait.peek();
                
                if (currentWeight + currentTruck <= weight){
                    currentWeight += currentTruck;
                    bridge.offer(wait.poll());
                }
                 else{
                    bridge.offer(0);
                }
            }
        
            else{
                bridge.offer(0);
            }
        }
        return currentTime;
    }
}