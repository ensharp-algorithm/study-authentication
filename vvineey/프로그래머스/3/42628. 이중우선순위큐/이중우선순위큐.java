import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
        
        
        PriorityQueue<Integer> maxQueue = new PriorityQueue<>((o1,o2)->{
            return Integer.compare(o2,o1);
        });
        
        PriorityQueue<Integer> minQueue = new PriorityQueue<>((o1,o2)->{
            return Integer.compare(o1,o2);
        });
        
        for (String s : operations) {
            String[] row = s.split(" ");
            
  
            // System.out.println(maxQueue);
            // System.out.println(minQueue);
        
            
            //삽입
            if (row[0].equals("I")){
                maxQueue.offer(Integer.parseInt(row[1]));
                minQueue.offer(Integer.parseInt(row[1]));
            }
            
            if (minQueue.isEmpty()){
                continue;
            }
            
            // 최댓값 제거 
            if (row[0].equals("D") && row[1].equals("1")){
                int target = maxQueue.peek();
                maxQueue.poll();
                minQueue.remove(target);
            }
            
            // 최솟값 제거
            if (row[0].equals("D") && row[1].equals("-1")){
                int target = minQueue.peek();
                minQueue.poll();
                maxQueue.remove(target);
            }
        }
        
        if (minQueue.isEmpty() && maxQueue.isEmpty()){
            return new int[]{0,0};
        }

        return new int[]{maxQueue.poll(), minQueue.poll()};
        
    }
}