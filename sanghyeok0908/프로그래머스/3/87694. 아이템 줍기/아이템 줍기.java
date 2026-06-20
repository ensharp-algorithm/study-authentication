import java.util.*;

class Solution {
    
    int[][] matrix;
    int n = 102;
    int[] dy = new int[] { -1, 1, 0, 0 };
    int[] dx = new int[] { 0, 0, -1, 1 };
    
    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        matrix = new int[n][n];
        
        for (int[] rect : rectangle) {
            int startX = rect[0] * 2;
            int startY = rect[1] * 2;
            int endX = rect[2] * 2;
            int endY = rect[3] * 2;
            
            for (int i = startY; i <= endY; i++) {
                for (int j = startX; j <= endX; j++) {
                    if (matrix[i][j] == 2)
                        continue;
                    
                    if (i == startY || i == endY || j == startX || j == endX) {
                        matrix[i][j] = 1;
                    } else {
                        matrix[i][j] = 2;
                    }
                }
            }
        }
        
        int answer = bfs(characterY * 2, characterX * 2, itemY * 2, itemX * 2);
        return answer / 2;
    }
    
    int bfs(int y, int x, int itemY, int itemX) {
        Queue<int[]> queue = new ArrayDeque<>();
        boolean[][] visited = new boolean[n][n];
        
        queue.add(new int[] { y, x, 0 });
        visited[y][x] = true;
        
        while(!queue.isEmpty()) {
            int[] poll = queue.poll();
            
            for (int i = 0; i < 4; i++) {
                int curY = poll[0] + dy[i];
                int curX = poll[1] + dx[i];
                int cost = poll[2] + 1;
                
                if (curY < 0 || curY >= n || curX < 0 || curX >= n || 
                    visited[curY][curX] || matrix[curY][curX] != 1)
                    continue;
                
                // System.out.println(curX + " " + curY + " cost = " + cost);
                
                if (curY == itemY && curX == itemX) {
                    return cost;
                }
                
                visited[curY][curX] = true;
                queue.add(new int [] { curY, curX, cost });
            }
        }
        return 0;
    }
}