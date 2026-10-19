import java.util.*;

class Solution {
    
    int[] dy = { -1, 1, 0, 0 };
    int[] dx = { 0, 0, -1, 1 };
    int n, m;
    
    public int solution(int[][] land) {
        n = land.length;
        m = land[0].length;
        int[] dp = new int[n * m + 10];
        
        for (int i = 0, idx = 2; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (land[i][j] == 1) {
                    dp[idx] = bfs(land, i, j, idx);
                    idx++;
                }
            }
        }
        
        int max = 0;
        
        for (int i = 0; i < m; i++) {
            Set<Integer> set = new HashSet<>();
            int sum = 0;
            
            for (int j = 0; j < n; j++) {
                if (set.add(land[j][i])) {
                    sum += dp[land[j][i]];
                }
            }
            
            max = Math.max(max, sum);
        }
        return max;
    }
    
    int bfs(int[][] land, int startY, int startX, int idx) {
        int cnt = 1;
        Queue<int[]> queue = new ArrayDeque<>();
        
        queue.add(new int[] { startY, startX });
        land[startY][startX] = idx;
        
        while(!queue.isEmpty()) {
            int[] poll = queue.poll();
            
            for (int i = 0; i < 4; i++) {
                int y = poll[0] + dy[i];
                int x = poll[1] + dx[i];
                
                if (y < 0 || y >= n || x < 0 || x >= m
                   || land[y][x] != 1) {
                    continue;
                }
                
                land[y][x] = idx;
                cnt++;
                queue.add(new int[] { y, x });
            }
        }
        return cnt;
    }
}