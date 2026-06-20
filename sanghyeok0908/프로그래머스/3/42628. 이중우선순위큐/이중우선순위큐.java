import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
        Queue<Integer> maxQ = new PriorityQueue<>((a, b) -> {
            return b - a;
        });
        Queue<Integer> minQ = new PriorityQueue<>((a, b) -> {
            return a - b;
        });
        
        for(String op : operations) {
            String[] split = op.split(" ");
            int num = Integer.parseInt(split[1]);
            
            if (split[0].equals("I")) {
                maxQ.add(num);
                minQ.add(num);
                // System.out.printf("%d 삽입\n", num);
                continue;
            }
            
            if (minQ.isEmpty()) {
                // System.out.println("삭제 건너뛰기");
                continue;
            }
            
            if (num == -1) {
                Integer removedNum = minQ.poll();
                maxQ.remove(removedNum);
                // System.out.printf("%d 삭제\n", removedNum);
            } else {
                Integer removedNum = maxQ.poll();
                minQ.remove(removedNum);
                // System.out.printf("%d 삭제\n", removedNum);
            }
        }
        
        if (maxQ.isEmpty()) return new int[]{0, 0};
        
        return new int[]{maxQ.poll(), minQ.poll()};
    }
}