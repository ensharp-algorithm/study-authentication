import java.util.*;
import java.util.stream.*;

class Solution {
    
    public int solution(int[][] jobs) {
        // {idx, requestTime, jobTime}
        Queue<int[]> initQ = new PriorityQueue<>((a, b) -> {
           if (a[1] < b[1]) {
               return -1;
           } else if (a[1] > b[1]) {
               return 1;
           } 
           
           if (a[2] < b[2]) {
               return -1;
           } else if (a[2] > b[2]) {
               return 1;
           }
           
           return a[0] - b[0];
       });
        Queue<int[]> waitQ = new PriorityQueue<>((a, b) -> {
           if (a[2] < b[2]) {
               return -1;
           } else if (a[2] > b[2]) {
               return 1;
           } 
           
           if (a[1] < b[1]) {
               return -1;
           } else if (a[1] > b[1]) {
               return 1;
           }
           
           return a[0] - b[0];
       });
        
        for (int i = 0; i < jobs.length; i++) {
            initQ.add(new int[]{i, jobs[i][0], jobs[i][1]});
        }
        
        int curTime = 0;
        int timeSum = 0;
        while(!initQ.isEmpty() || !waitQ.isEmpty()) {
            // 아직 initQ에 작업이 있지만, 요청시간이 curTime보다 클 때
            if (!initQ.isEmpty() && curTime < initQ.peek()[1] && waitQ.isEmpty()) {
                curTime = initQ.peek()[1];   
            }
            
            // initQ에서 waitQ로 job 넣기
            while (!initQ.isEmpty() && initQ.peek()[1] <= curTime) {
                System.out.printf("initQ poll, curTime = %d\n", curTime);
                waitQ.add(initQ.poll());
            }
            
            // waitQ에서 작업할 job 빼기
            if (!waitQ.isEmpty()) {
                int[] curJob = waitQ.poll();
                System.out.printf("waitQ poll, curTime = %d, idx = %d\n", curTime, curJob[0]);
                
                // job 수행
                System.out.println("job processing");
                System.out.printf("before curTime = %d\n", curTime);
                curTime += curJob[2];
                timeSum += curTime - curJob[1];
                System.out.printf("after curTime = %d\n", curTime);
            }
        }
        return timeSum / jobs.length;
    }
}