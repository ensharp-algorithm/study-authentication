import java.util.*;

class Solution {
    
    public long solution(int n, int[] works) {
        int left = 0, right = 0, maxMid = 0;
        long total = 0;
        
        for (int w : works) {
            right = Math.max(right, w);
            maxMid = Math.max(maxMid, w);
            total += w;
        }
        if (total <= n) {
            return 0;
        }
        
        while(left <= right) {
            int mid = (left + right) / 2;
            int diff = 0;
            
            for (int w : works) {
                if (w > mid) {
                    diff += w - mid;
                }
            }
            
            if (diff <= n) {
                maxMid = Math.min(maxMid, mid);
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        
        // System.out.println("maxMid = " + maxMid);
        
        int copyN = n;
        for (int i = 0; i < works.length; i++) {
            if (maxMid < works[i]) {
                copyN -= (works[i] - maxMid);
                works[i] = maxMid;
            }
        }
        
        // int idx = 0;
        // while(copyN > 0) {
        //     works[idx]--;
        //     copyN--;
        //     idx = (idx + 1) % works.length;
        // }
        
        long answer = 0;
        for (int i = 0; i < works.length; i++) {
            if (copyN > 0 && works[i] == maxMid) {
                works[i]--;
                copyN--;
            }
            answer += (long) works[i] * works[i];
        }
        
        // long answer = 0;
        // for (int w : works) {
        //     answer += Math.pow(w, 2);
        // }
        return answer;
    }
}