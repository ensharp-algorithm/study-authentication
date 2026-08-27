import java.util.*;

class Solution {
    
    public int solution(int n, int[][] data) {
        TreeSet<Integer> xSet = new TreeSet<>(), ySet = new TreeSet<>();
        Map<Integer, Integer> xMap = new HashMap<>(), yMap = new HashMap<>();
        boolean[][] matrix = new boolean[n][n];
        
        for (int i = 0; i < n; i++) {
            xSet.add(data[i][1]);
            ySet.add(data[i][0]);
        }
        
        int idx = 0;
        for (Integer x : xSet) {
            xMap.put(x, idx++);
        }
        idx = 0;
        for (Integer y : ySet) {
            yMap.put(y, idx++);
        }
        
        for (int[] d : data) {
            matrix[yMap.get(d[0])][xMap.get(d[1])] = true;
        }
        
        int[][] prefixSum = new int[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                prefixSum[i][j] = prefixSum[i - 1][j] + prefixSum[i][j - 1] - prefixSum[i - 1][j - 1] + (matrix[i - 1][j - 1] ? 1 : 0);
            }
        }
        
        int answer = 0;
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (data[i][0] == data[j][0] || data[i][1] == data[j][1]) {
                    continue;
                }
                
                int y1 = yMap.get(data[i][0]);
                int y2 = yMap.get(data[j][0]);
                int x1 = xMap.get(data[i][1]);
                int x2 = xMap.get(data[j][1]);
                
                int minY = Math.min(y1, y2) + 1;
                int minX = Math.min(x1, x2) + 1;
                int maxY = Math.max(y1, y2) - 1;
                int maxX = Math.max(x1, x2) - 1;
                
                if (minY <= maxY && minX <= maxX) {
                    if (prefixSum[maxY + 1][maxX + 1] - prefixSum[maxY + 1][minX] - prefixSum[minY][maxX + 1] + prefixSum[minY][minX] <= 0)
                        answer++;
                } else {
                    answer++;
                }
            }
        }
        return answer;
    }
}