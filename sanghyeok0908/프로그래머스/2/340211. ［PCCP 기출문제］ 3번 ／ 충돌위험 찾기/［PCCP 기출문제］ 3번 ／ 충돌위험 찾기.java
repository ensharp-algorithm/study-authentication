import java.util.*;

class Solution {
    public int solution(int[][] points, int[][] routes) {
        List<int[]>[] paths = new ArrayList[routes.length];
        
        for (int robot = 0; robot < routes.length; robot++) {
            List<int[]> path = new ArrayList<>();
            int[] route = routes[robot];
            int curY = points[route[0] - 1][0] - 1;
            int curX = points[route[0] - 1][1] - 1;
            int time = 0;

            path.add(new int[] { curY, curX, time++ });
            
            for (int i = 1; i < route.length; i++) {
                int endY = points[route[i] - 1][0] - 1;
                int endX = points[route[i] - 1][1] - 1;
                
                while(curY != endY) {
                    curY = curY + (endY > curY ? 1 : -1);
                    path.add(new int[] { curY, curX, time++ });
                }
                
                while(curX != endX) {
                    curX = curX + (endX > curX ? 1 : -1);
                    path.add(new int[] { curY, curX, time++ });
                }
            }
            paths[robot] = path;
        }
        
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < routes.length; i++) {
            // System.out.println("robot = " + i);
            for (int[] p : paths[i]) {
                // System.out.printf("%d %d %d\n", p[0], p[1], p[2]);
                String key = p[0] + ", " + p[1] + ": " + p[2];
                map.put(key, map.getOrDefault(key, 0) + 1);
            }
        }
        
        int answer = 0;
        for (Integer i : map.values()) {
            if (i >= 2) {
                answer++;
            }
        }
        
        // for (String key : map.keySet()) {
        //     System.out.println("key = " + key + " value = " + map.get(key));
        // }
        return answer;
    }
}