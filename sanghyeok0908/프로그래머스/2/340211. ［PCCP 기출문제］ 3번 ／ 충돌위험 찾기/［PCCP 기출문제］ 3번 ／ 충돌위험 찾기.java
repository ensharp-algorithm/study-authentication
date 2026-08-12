import java.util.*;

class Solution {

    public int solution(int[][] points, int[][] routes) {
        Map<String, Integer> paths = new HashMap<>();
        
        for (int[] route : routes) {
            int time = 0;
            int[] cur = points[route[0] - 1].clone();
            
            String key = convertToKey(time, cur);
            paths.put(key, paths.getOrDefault(key, 0) + 1);
            
            for (int i = 1; i < route.length; i++) {
                int[] end = points[route[i] - 1];
                // System.out.printf("도착지 = %d, %d\n", end[0], end[1]);
                // System.out.println(key + " => " + paths.get(key));
                
                while(cur[0] != end[0]) {
                    time++;
                    cur[0] = cur[0] < end[0] ? cur[0] + 1 : cur[0] - 1;

                    key = convertToKey(time, cur);
                    paths.put(key, paths.getOrDefault(key, 0) + 1);
                    // System.out.println(key + " => " + paths.get(key));
                }

                while(cur[1] != end[1]) {
                    time++;
                    cur[1] = cur[1] < end[1] ? cur[1] + 1 : cur[1] - 1;

                    key = convertToKey(time, cur);
                    paths.put(key, paths.getOrDefault(key, 0) + 1);
                    // System.out.println(key + " => " + paths.get(key));
                }       
            }
        }
        
        int answer = 0;
        for (String k : paths.keySet()) {
            if (paths.get(k) > 1) {
                answer++;
            }
        }
        return answer;
    }
    
    String convertToKey(int time, int[] pos) {
        return time + ":" + pos[0] + "," + pos[1];
    }
}