import java.util.*;

class Solution {
    static int [] times;
    static int n;
    
    public long solution(int n, int[] times) {
        this.times = times;
        this.n = n;
        
        int minTime = Integer.MAX_VALUE;
        
        for (int time : times) {
            minTime = Math.min(minTime, time);
        }
        
        return binarySearch(1, (long) minTime * n);
    }
    
    private long binarySearch(long left, long right){
    
        while(left <= right){
            
            long mid = left + ((right - left) / 2);
            
            // System.out.println("left = " + left + " right = " + right + " mid = " + mid);
            
            long cnt = 0;
        
            for (int time : times){
                
                cnt += mid/time;
                
                if (cnt >= n){
                   break;
                }
            }
            
            // System.out.println("cnt = "+ cnt);
            // x x x x x x x [o] o o o o o o o o o o o o o o o o o o
            
            if (cnt >= n){
                right = mid -1;
            }
            else {
                left = mid + 1;
            }
        }
        
        return left;
    }
}