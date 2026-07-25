import java.util.*;

class Solution {
    
    int weakCnt, workerCnt;
    int[] weakLine;
    int[] workers;
    boolean[] isUsed;
    int answer = Integer.MAX_VALUE;
    
    public int solution(int n, int[] weak, int[] dist) {
        weakCnt = weak.length;
        workerCnt = dist.length;
        weakLine = new int[weakCnt * 2];
        workers = new int[workerCnt];
        isUsed = new boolean[workerCnt];
        
        for (int i = 0; i < weakCnt; i++) {
            weakLine[i] = weak[i];
            weakLine[i + weakCnt] = weak[i] + n;
        }
        
        permute(0, dist);
        return answer == Integer.MAX_VALUE ? -1 : answer;
    }
    
    void permute(int depth, int[] dist) {
        if (depth == workerCnt) {
            for (int i = 0; i < weakCnt; i++) {
                answer = Math.min(answer, calculate(i));
            }
            return;
        }
        
        for (int i = 0; i < workerCnt; i++) {
            if (isUsed[i]) {
                continue;
            }
            
            isUsed[i] = true;
            workers[depth] = dist[i];
            permute(depth + 1, dist);
            isUsed[i] = false;
        }
    }
    
    int calculate(int start) {
        int idx = start;
        int cnt = 0;
        
        while (idx < start + weakCnt) {
            if (cnt == workerCnt) {
                return Integer.MAX_VALUE;
            }
                
            int end = weakLine[idx] + workers[cnt++];
            
            while(idx < start + weakCnt && weakLine[idx] <= end) {
                idx++;
            }
        }
        return cnt;
    }
}