import java.util.*;

class Solution {

    public int solution(int[][] maps) {
        int[] dy = new int[] { -1, 1, 0, 0 };
        int[] dx = new int[] { 0, 0, -1, 1 };
        
        int n = maps.length;
        int m = maps[0].length;
        
        Queue<int[]> queue = new ArrayDeque<>();
        boolean[][] visited = new boolean[n][m];
        queue.add(new int[]{ 0, 0, 1 });
        visited[0][0] = true;
        
        while(!queue.isEmpty()) {
            int[] poll = queue.poll();
            
            for (int i = 0; i < 4; i++) {
                int curY = poll[0] + dy[i];
                int curX = poll[1] + dx[i];
                int cnt = poll[2];
                
                if (curY < 0 || curY >= n || curX < 0 || curX >= m || 
                    visited[curY][curX] || maps[curY][curX] == 0)
                    continue;
                
                // System.out.println(curY + " " + curX + " " + cnt);
                
                if (curY == n - 1 && curX == m - 1)
                    return cnt + 1;
                
                visited[curY][curX] = true;
                queue.add(new int[] { curY, curX, cnt + 1 });
            }
        }
        return -1;
    }
}