import java.util.*;

class Solution {
    
    public int solution(int[][] jobs) {
        int n = jobs.length;
        int time = 0, sum = 0, idx = 0;
        // { 작업의 번호, 작업의 요청 시각, 작업의 소요 시간 }
        Queue<int[]> waitQueue = new PriorityQueue<>((o1, o2) -> {
            if (o1[2] != o2[2]) {
                return Integer.compare(o1[2], o2[2]);
            }
            
            if (o1[1] != o2[1]) {
                return Integer.compare(o1[1], o2[1]);
            }
            return Integer.compare(o1[0], o2[0]);
        });
        
        Arrays.sort(jobs, (o1, o2) -> o1[0] != o2[0] ? 
                    Integer.compare(o1[0], o2[0]) : Integer.compare(o1[1], o2[1]));
        
        while(idx < n || !waitQueue.isEmpty()) {
            
            while(idx < n && jobs[idx][0] <= time) {
                waitQueue.add(new int[] { idx, jobs[idx][0], jobs[idx][1] });
                idx++;
            }
            
            if (waitQueue.isEmpty()) {
                time = jobs[idx][0];
                continue;
            }
            
            int[] process = waitQueue.poll();
            time += process[2];
            sum += time - process[1];
        }
        
        return sum / n;
    }
}