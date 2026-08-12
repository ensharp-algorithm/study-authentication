import java.util.*;

class Solution {
    
    int[] dy = new int[] { -1, 0, 1, 0 };
    int[] dx = new int[] { 0, 1, 0, -1 };
    int n, m;
    int[] volumes;
    
    public int solution(int[][] land) {
        int answer = 0;
        n = land.length;
        m = land[0].length;
        volumes = new int[n * m + 10];
        int lastIdx = initLand(land);
        
        for (int j = 0; j < m; j++) {
            int temp = 0;
            boolean[] visited = new boolean[lastIdx + 1];
            // System.out.println("row = " + j);
            
            for (int i = 0; i < n; i++) {
                if (land[i][j] != 0 && !visited[land[i][j]]) {
                    visited[land[i][j]] = true;
                    temp += volumes[land[i][j]];
                    // System.out.printf("idx = %d, volume = %d\n", 
                    //                   land[i][j], volumes[land[i][j]]);
                }
            }
            answer = Math.max(answer, temp);
        }
        return answer;
    }
    
    int initLand(int[][] land) {
        int idx = 2;
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (land[i][j] == 1) {
                    int cnt = bfs(land, i, j, idx);
                    volumes[idx++] = cnt;
                }
            }
        }
        return idx - 1;
    }
    
    int bfs(int[][] land, int y, int x, int idx) {
        int cnt = 1;
        Queue<int[]> queue = new ArrayDeque<>();
        queue.add(new int[] { y, x });
        land[y][x] = idx;
        
        while(!queue.isEmpty()) {
            int[] poll = queue.poll();
            
            for (int i = 0; i < 4; i++) {
                int curY = poll[0] + dy[i];
                int curX = poll[1] + dx[i];
                
                if (curY < 0 || curY >= n || curX < 0 || curX >= m || 
                    land[curY][curX] != 1) {
                    continue;
                }
                
                queue.add(new int[] { curY, curX });
                land[curY][curX] = idx;
                cnt++;
            }
        }
        
        return cnt;
    }
}