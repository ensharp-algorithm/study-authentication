import java.util.*;

class Solution {
    
    public int solution(int[][] routes) {
        int answer = 0, prevEnd = -30010;
        Arrays.sort(routes, (o1, o2) -> Integer.compare(o1[1], o2[1]));
        
        for (int[] route : routes) {
            if (prevEnd < route[0]) {
                answer++;
                prevEnd = route[1];
            }
            // System.out.println(route[0] + " " + route[1]);
            // System.out.println(answer + " " + prevEnd);
            // System.out.println("=========");
        }
        return answer;
    }
}