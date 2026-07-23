import java.util.*;

class Solution {
    
    boolean[][] matrix = new boolean[110][110];
    
    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        characterX *= 2;
        characterY *= 2;
        itemX *= 2;
        itemY *= 2;
        
        for (int[] rect : rectangle) {
            int leftX = rect[0] * 2;
            int leftY = rect[1] * 2;
            int rightX = rect[2] * 2;
            int rightY = rect[3] * 2;
            
            int curX = leftX;
            int curY = leftY;
            
            while(curX <= rightX) {
                matrix[curY][curX++] = true;
            }
            curX--;
            
            while(curY <= rightY) {
                matrix[curY++][curX] = true;
            }
            curY--;
            
            // System.out.printf("%d %d\n", curY, curX);
            while(curX >= leftX) {
                matrix[curY][curX--] = true;
            }
            curX++;
            
            while(curY >= leftY) {
                matrix[curY--][curX] = true;
            }
            curY++;
            
            // System.out.println("==========");
            // for (int i = 0; i < 30; i++) {
            //     for (int j = 0; j < 30; j++) {
            //         System.out.print((matrix[i][j] ? 1 : 0) + " ");
            //     }
            //     System.out.println();
            // }
        }
        
        for (int[] rect : rectangle) {
            int leftX = rect[0] * 2;
            int leftY = rect[1] * 2;
            int rightX = rect[2] * 2;
            int rightY = rect[3] * 2;
            
            for (int i = leftY + 1; i < rightY; i++) {
                for (int j = leftX + 1; j < rightX; j++) {
                    matrix[i][j] = false;
                }
            }
        }

        System.out.println("==========");
        for (int i = 0; i < 30; i++) {
            for (int j = 0; j < 30; j++) {
                System.out.print((matrix[i][j] ? 1 : 0) + " ");
            }
            System.out.println();
        }
        
        int[] dy = new int[] { -1, 1, 0, 0 };
        int[] dx = new int[] { 0, 0, -1, 1 };
        Queue<int[]> queue = new ArrayDeque<>();
        queue.add(new int[] { characterY, characterX, 0 });
        matrix[characterY][characterX] = false;
        
        while(!queue.isEmpty()) {
            int[] poll = queue.poll();
            
            if (poll[0] == itemY && poll[1] == itemX) {
                return poll[2] / 2;
            }
            
            for (int i = 0; i < 4; i++) {
                int curY = poll[0] + dy[i];
                int curX = poll[1] + dx[i];
                
                if (curY < 0 || curY >= 110 || curX < 0 || curX >= 110 
                    || !matrix[curY][curX]) {
                    continue;
                }
                
                matrix[curY][curX] = false;
                queue.add(new int[] { curY, curX, poll[2] + 1 });
            }
        }
        
        return 0;
    }
}