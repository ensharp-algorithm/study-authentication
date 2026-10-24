import java.util.*;

class Solution {
    
    public int solution(int n, int k, int[] enemy) {
        long[] prefixSum = new long[enemy.length];
        int left = 0, right = enemy.length - 1;
        
        prefixSum[0] = enemy[0];
        for (int i = 1; i < enemy.length; i++) {
            prefixSum[i] = enemy[i] + prefixSum[i - 1];
        }
        
        while(left <= right) {
            int curRound = (left + right) / 2;
            long enemyCnt = prefixSum[curRound] - getRemovedEnemy(enemy, k, curRound + 1);
            
            if (enemyCnt <= n) {
                left = curRound + 1;
            } else {
                right = curRound - 1;
            }
        }
        return left;
    }
    
    long getRemovedEnemy(int[] origin, int k, int size) {
        Queue<Integer> q = new PriorityQueue<>(Collections.reverseOrder());
        long result = 0;
        
        for (int i = 0; i < size; i++) {
            q.add(origin[i]);
        }
        
        for (int i = 0; i < k && !q.isEmpty(); i++) {
            result += q.poll();
        }
        return result;
    }
}