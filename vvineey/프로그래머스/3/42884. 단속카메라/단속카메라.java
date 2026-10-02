import java.util.*;

class Solution {
    public int solution(int[][] routes) {
        
        for (int [] route : routes){
            Arrays.sort(routes, (o1,o2)->{
                return Integer.compare(o1[1], o2[1]);
            });
        }
        
        int prev = Integer.MIN_VALUE;
        int cnt = 0;
        
        for (int i = 0; i < routes.length; i++) {
            
            // System.out.println(routes[i][0] + " " + routes[i][1]);
            
            // System.out.println(prev + " vs " + routes[i][0]);
            if (prev < routes[i][0]){
                
                
                prev = routes[i][1];
                // System.out.println("> 설치 : " + prev);
                cnt++;
            }
      
        }
        
        return cnt;
    }
}