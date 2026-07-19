import java.util.*;

class Solution {
    public int solution(int[][] points, int[][] routes) {
        List<List<int[]>> allPaths = new ArrayList<>();
        int maxTime = 0;

        for (int i = 0; i < routes.length; i++) {
            List<int[]> path = new ArrayList<>();
            int[] route = routes[i];
            int currentY = points[route[0] - 1][0] - 1;
            int currentX = points[route[0] - 1][1] - 1;
            
            path.add(new int[]{currentY, currentX});
            
            for (int j = 1; j < route.length; j++) {
                int targetY = points[route[j] - 1][0] - 1;
                int targetX = points[route[j] - 1][1] - 1;
                
                while (currentY != targetY) {
                    currentY += (targetY > currentY) ? 1 : -1;
                    path.add(new int[]{currentY, currentX});
                }
                
                while (currentX != targetX) {
                    currentX += (targetX > currentX) ? 1 : -1;
                    path.add(new int[]{currentY, currentX});
                }
            }
            
            allPaths.add(path);
            maxTime = Math.max(maxTime, path.size());
        }

        
        int dangerCount = 0;
        for (int t = 0; t < maxTime; t++) {
            Map<String, Integer> positionCount = new HashMap<>();
            
            for (List<int[]> path : allPaths) {
                // 로봇이 아직 목적지에 도착하기 전
                if (t < path.size()) {
                    int[] pos = path.get(t);
                    String key = pos[0] + "," + pos[1];
                    positionCount.put(key, positionCount.getOrDefault(key, 0) + 1);
                }
            }
            
            for (int count : positionCount.values()) {
                if (count >= 2) {
                    dangerCount++;
                }
            }
        }

        return dangerCount;
    }
}