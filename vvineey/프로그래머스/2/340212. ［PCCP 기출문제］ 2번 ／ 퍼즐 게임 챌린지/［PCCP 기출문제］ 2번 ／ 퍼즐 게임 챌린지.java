import java.util.*;
class Solution {
    
    static int[] diffs;
    static int[] times;
    static long limit;

    public int solution(int[] diffs, int[] times, long limit) {
        
        this.diffs = diffs;
        this.times = times;
        this.limit = limit;
        
        int minDiff = 1;
        int maxDiff = 0;
        
        //최고 난이도 
        for (int diff : diffs){
            maxDiff = Math.max(maxDiff, diff);
        }
        
        System.out.println(minDiff+ " "+ maxDiff);
        
        return binarySearch(minDiff, maxDiff);
    }
    
    private int binarySearch(int left, int right){
        
        int answer = 0;
        
        while (left<= right){
            // System.out.println("탐색\n left = " + left+ " right = "+ right);
            
            int mid = left + (right - left) /2;
            
            // System.out.println("level= " + mid);
            
            if (isPossible(mid)){
                right = mid -1;
                answer = mid;
            }
            else{
                left = mid +1;
            }
        }
        
        return answer;
    }
    
    //총 소요 시간
    //((반복 횟수) * (이전 시간 + 현재 시간)) + 현재 시간 
    //diffs[0] = 1
    
    private boolean isPossible(int level){
        
        long total = 0;
        
        for (int i = 0; i < diffs.length; i++){
            
            int diff = diffs[i];
            int time_cur = times[i];
            int time_prev = (i == 0) ? 0 : times[i-1];
            int cnt = (diff<= level) ? 0 : diff-level;
            
          
            total += ((cnt * (time_cur + time_prev)) + time_cur);
            
            
            if (total > limit){
                return false;
            }
        }
            
            // System.out.println( i + "번째 총 소요시간\n " + total);
        return true;
    }
}