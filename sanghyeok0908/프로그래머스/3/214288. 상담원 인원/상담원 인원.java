import java.util.*;

class Solution {
    
    int answer = Integer.MAX_VALUE;

    public int solution(int k, int n, int[][] reqs) {
        int maxMentoCnt = n - k + 1;
        List<int[]>[] requests = new ArrayList[k + 1];
        int[][] waitTime = new int[k + 1][maxMentoCnt + 1];
        
        for (int i = 1; i <= k; i++) {
            requests[i] = new ArrayList<>();
        }
        
        for (int[] req : reqs) {
            requests[req[2]].add(new int[] { req[0], req[1] });
        }
        
        for (int i = 1; i <= k; i++) {
            for (int cnt = 1; cnt <= maxMentoCnt; cnt++) {
                waitTime[i][cnt] = calculateWaitTime(requests[i], cnt);
            }
        }
        
        dfs(k, 1, n, 0, waitTime);
        return answer;
    }
    
    int calculateWaitTime(List<int[]> request, int cnt) {
        int wait = 0;
        Queue<Integer> queue = new PriorityQueue<>();
        
        for (int i = 0; i < cnt; i++) {
            queue.add(0);
        }
        
        for (int[] req : request) {
            int start = Math.max(queue.poll(), req[0]);
            
            wait += start - req[0];
            queue.add(start + req[1]);
        }
        return wait;
    }
    
    void dfs(int k, int type, int remaining, int curWaitTime, int[][] waitTime) {
        if (answer <= curWaitTime) {
            return;
        }
        
        if (type == k) {
            answer = Math.min(answer, curWaitTime + waitTime[type][remaining]);
            return;
        }
        
        int maxMentoCnt = remaining - (k - type);
        
        for (int i = 1; i <= maxMentoCnt; i++) {
            dfs(k, type + 1, remaining - i, curWaitTime + waitTime[type][i], waitTime);
        }
    }
}