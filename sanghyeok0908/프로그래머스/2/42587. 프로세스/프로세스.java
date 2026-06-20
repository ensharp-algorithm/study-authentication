import java.util.*;

class Solution {
    
    public int solution(int[] priorities, int location) {
        Queue<int[]> queue = new ArrayDeque<>();
        int n = priorities.length;
        int cnt = 0;
        
        for (int i = 0; i < n; i++) {
            queue.add(new int[]{i, priorities[i]});
        }
        
        while(!queue.isEmpty()) {
            int[] poll = queue.poll();
            boolean isNotYet = false;
            
            for (int[] i : queue) {
                if (poll[1] < i[1]) {
                    isNotYet = true;
                    break;
                }
            }
            
            if (isNotYet) {
                queue.add(poll);
            } else {
                cnt++;
                
                if (poll[0] == location) {
                    return cnt;
                }   
            }
        }
        return -1;
    }
}