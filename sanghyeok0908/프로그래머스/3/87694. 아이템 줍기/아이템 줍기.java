import java.util.*;

class Solution {
    
    boolean[][] matrix = new boolean[101][101];
    
    public int solution(int[][] rectangle, int characterX, int characterY, 
                        int itemX, int itemY) {
        characterX *= 2;
        characterY *= 2;
        itemX *= 2;
        itemY *= 2;
        for (int[] rect : rectangle) {
            for (int i = 0; i < 4; i++) {
                rect[i] *= 2;
            }
            
            drawLine(rect);
        }
        
        for (int[] rect : rectangle) {
            eraseLine(rect);
        }
        return bfs(characterY, characterX, itemY, itemX) / 2;
    }
    
    int bfs(int startY, int startX, int endY, int endX) {
        int[] dy = { -1, 1, 0, 0 };
        int[] dx = { 0, 0, -1, 1 };
        Queue<int[]> queue = new ArrayDeque<>();
        
        queue.add(new int[] { startY, startX, 0 });
        matrix[startY][startX] = false;
        
        while(!queue.isEmpty()) {
            int[] poll = queue.poll();
            
            if (poll[0] == endY && poll[1] == endX) {
                return poll[2];
            }
            
            for (int i = 0; i < 4; i++) {
                int y = poll[0] + dy[i];
                int x = poll[1] + dx[i];
                
                if (y < 0 || y >= 101 || x < 0 || x >= 101
                   || !matrix[y][x]) {
                    continue;
                }
                
                matrix[y][x] = false;
                queue.add(new int[] { y, x, poll[2] + 1 });
            }
        }
        return -1;
    }
    
    void eraseLine(int[] rect) {
        for (int y = rect[1] + 1; y < rect[3]; y++) {
            for (int x = rect[0] + 1; x < rect[2]; x++) {
                matrix[y][x] = false;
            }
        }
    }
    
    void drawLine(int[] rect) {
        for (int y = rect[1]; y <= rect[3]; y++) {
            matrix[y][rect[0]] = true;
            matrix[y][rect[2]] = true;
        }
        
        for (int x = rect[0]; x <= rect[2]; x++) {
            matrix[rect[1]][x] = true;
            matrix[rect[3]][x] = true;
        }
    }
}