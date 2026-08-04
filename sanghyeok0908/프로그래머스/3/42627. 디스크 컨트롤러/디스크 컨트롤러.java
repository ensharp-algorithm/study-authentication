import java.util.*;

class Solution {
    
    public int solution(int[][] jobs) {
        Queue<int[]> waitQ = new PriorityQueue<>((o1, o2) -> {
            // 요청 시간
           if (o1[1] != o2[1]) {
               return Integer.compare(o1[1], o2[1]);
           }
            // 소요시간
           if (o1[2] != o2[2]) {
               return Integer.compare(o1[2], o2[2]);
           }
            // 작업 번호
           return Integer.compare(o1[0], o2[0]);
        });
        Queue<int[]> processQ = new PriorityQueue<>((o1, o2) -> {
            // 소요 시간
           if (o1[2] != o2[2]) {
               return Integer.compare(o1[2], o2[2]);
           }
            // 요청 시간
           if (o1[1] != o2[1]) {
               return Integer.compare(o1[1], o2[1]);
           }
            // 작업 번호
           return Integer.compare(o1[0], o2[0]);
        });
        List<Integer> result = new ArrayList<>();
            
        for (int i = 0; i < jobs.length; i++) {
            waitQ.add(new int[] { i, jobs[i][0], jobs[i][1] });
        }
        
        int curTime = 0;
        int nextTime = 0;
        while(!waitQ.isEmpty() || !processQ.isEmpty()) {
            // System.out.println("curTime = " + curTime);
            
            while (curTime >= nextTime && 
                   !waitQ.isEmpty() && 
                   curTime >= waitQ.peek()[1]) {
                int[] poll = waitQ.poll();
                processQ.add(poll);
                // System.out.printf("add processQ %d %d %d\n", poll[0], poll[1], poll[2]);
            }
            
            if (curTime >= nextTime && !processQ.isEmpty()) {
                int[] poll = processQ.poll();
                nextTime = curTime + poll[2];
                result.add(nextTime - poll[1]);
            }
            
            while(!processQ.isEmpty()) {
                int[] poll = processQ.poll();
                waitQ.add(poll);
                // System.out.printf("waitQ 다시 add %d %d %d\n", poll[0], poll[1], poll[2]);
            }
            
            curTime++;
        }
        
        int answer = 0;
        for (Integer i : result) {
            answer += i;
        }
        return answer / result.size();
    }
}