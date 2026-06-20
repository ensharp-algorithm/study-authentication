import java.util.*;

class Solution {
    
    public int solution(int[][] routes) {
        int n = routes.length;
        
        for (int i = 0; i < n; i++) {
            if (routes[i][0] > routes[i][1]) {
                int temp = routes[i][0];
                routes[i][0] = routes[i][1];
                routes[i][1] = temp;
            }
        }
        
        Arrays.sort(routes, (o1, o2) -> Integer.compare(o1[1], o2[1]));       
        
        int camera = -30001;
        int cnt = 0;
        for (int[] route : routes) {
            if (camera < route[0]) {
                cnt++;
                camera = route[1];
            }
        }
        
        return cnt;
    }
}