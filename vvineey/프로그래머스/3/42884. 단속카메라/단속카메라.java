import java.util.*;

class Solution {
    public int solution(int[][] routes) {
        
        for (int[] row : routes){
            Arrays.sort(routes, (o1,o2)->{
                if (o1[1] != o2[1]){
                    return Integer.compare(o1[1],o2[1]);
                }
                 return Integer.compare(o1[0],o2[0]);
            });
        }
        
        int cnt = 0;
        int camera = Integer.MIN_VALUE;
        
        for (int [] row: routes){
            
            // System.out.println("camera " + camera);
            
            int in = row[0];
            int out = row[1];
             
            if (in > camera){
                camera = out;
                cnt++;
            }
        }
    
        
        // [0] -20 -19 -18 -17 -16 -15  
        // [2]         -18 -17 -16 -15  -14 -13
        // [1]                          -14 -13 -12 ... -5
        // [3]                                          -5  -4 -3 
        
        
        return cnt;
    }
}