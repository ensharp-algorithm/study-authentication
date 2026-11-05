import java.util.*;

class Solution {

    int n, m, x, y, r, c, k;

    int[] dy = {1, 0, 0, -1};
    int[] dx = {0, -1, 1, 0};
    char[] dir = {'d', 'l', 'r', 'u'};

    public String solution(int n, int m, int x, int y,int r, int c, int k) {

        this.n = n;
        this.m = m;
        this.x = x;
        this.y = y;
        this.r = r;
        this.c = c;
        this.k = k;

        return bfs(new int[]{x, y, 0});
    }

    private String bfs(int[] start) {

        boolean[][][] visited = new boolean[n+1][m+1][k+1];

        int[][][] parent = new int[n+1][m+1][k+1];

        Deque<int[]> queue = new ArrayDeque<>();

        queue.offer(start);
        visited[start[0]][start[1]][0] = true;

        while (!queue.isEmpty()) {

            int[] current = queue.poll();

            int cy = current[0];
            int cx = current[1];
            int cnt = current[2];
            
        
            if (cy == r && cx == c && cnt == k) {
                return getPath(parent);
            }

            if (cnt >= k) {
                continue;
            }

            for (int i = 0; i < 4; i++) {

                int nextY = cy + dy[i];
                int nextX = cx + dx[i];
                int nextCnt = cnt + 1;

                if (nextY < 1 || nextX < 1 || nextY > n || nextX > m) {
                    continue;
                }

                if (visited[nextY][nextX][nextCnt]) {
                    continue;
                }

                queue.offer(new int[]{nextY, nextX, nextCnt});
                visited[nextY][nextX][nextCnt] = true;
                
                //방향 저장
                parent[nextY][nextX][nextCnt] = i;
            }
        }

        return "impossible";
    }

    private String getPath(int[][][] parent) {

        StringBuilder sb = new StringBuilder();

        int a = r;
        int b = c;
        int cnt = k;
        
        System.out.println("경로복원");

        while (cnt > 0) {

            int direction = parent[a][b][cnt];

            sb.append(dir[direction]);
            
            System.out.println(a + " " +  b);

            a -= dy[direction];
            b -= dx[direction];

            cnt--;
        }

        return sb.reverse().toString();
    }
}