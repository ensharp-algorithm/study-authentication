import java.util.*;

class Solution {
    
    int[] dy = { -1, 1, 0, 0 };
    int[] dx = { 0, 0, -1, 1 };

    public int solution(int[][] maps) {
        int n = maps.length;
        int m = maps[0].length;
        boolean[][] visited = new boolean[n][m];
        Queue<int[]> q = new ArrayDeque<>();
        
        q.add(new int[] { 0, 0, 0 });
        visited[0][0] = true;
        
        while(!q.isEmpty()) {
            int[] poll = q.poll();
            
            if (poll[0] == n - 1 && poll[1] == m - 1) {
                return poll[2] + 1;
            }
            
            for (int i = 0; i < 4; i++) {
                int y = poll[0] + dy[i];
                int x = poll[1] + dx[i];
                
                if (y < 0 || y >= n || x < 0 || x >= m || visited[y][x] || maps[y][x] == 0) {
                    continue;
                }
                
                q.add(new int[] { y, x, poll[2] + 1 });
                visited[y][x] = true;
            }
        }
        
        return -1;
    }
}