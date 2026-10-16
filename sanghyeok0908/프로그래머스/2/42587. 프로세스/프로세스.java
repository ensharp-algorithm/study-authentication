import java.util.*;

class Solution {
    
    public int solution(int[] priorities, int location) {
        Queue<int[]> queue = new ArrayDeque<>();
        
        for (int i = 0; i < priorities.length; i++) {
            queue.add(new int[] { i, priorities[i] });
        }
        
        int cnt = 0;
        
        while(!queue.isEmpty()) {
            boolean isProcess = true;
            int[] poll = queue.poll();
            
            for (int[] process : queue) {
                if (poll[1] < process[1]) {
                    isProcess = false;
                    break;
                }
            }
            
            if (!isProcess) {
                queue.add(poll);
                continue;
            }
            
            cnt++;
            
            if (poll[0] == location) {
                return cnt;
            }
        }
        return -1;
    }
}