import java.util.*;

class Solution {
    
    public int solution(int[] priorities, int location) {
        Queue<int[]> queue = new ArrayDeque<>();
        
        for (int i = 0; i < priorities.length; i++) {
            queue.add(new int[] {i, priorities[i]});
        }
        
        int cnt = 0;
        while(!queue.isEmpty()) {
            int[] cur = queue.poll();
            boolean isFirst = true;
            
            for (int[] q : queue) {
                if (cur[1] < q[1]) {
                    isFirst = false;        
                    break;
                }
            }
            
            if (isFirst) {
                cnt++;
                
                if (cur[0] == location) {
                    return cnt;
                }
            } else {
                queue.add(cur);
            }
        }
        return -1;
    }
}