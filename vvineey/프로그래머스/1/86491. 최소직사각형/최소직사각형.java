import java.util.*;

class Solution {
    public int solution(int[][] sizes) {
        int answer = 0;
        
        int w = 0;
        int h = 0;
        
        for (int[] size : sizes){
            int big = Math.max(size[0],size[1]);
            int small = Math.min(size[0],size[1]);
            
            if (w < big){
                w = big;
            }
            if (h < small){
                h = small;
            }
        }
        
        answer = w*h;
        
        return answer;
    }
}