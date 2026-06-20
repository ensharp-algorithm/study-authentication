

import java.lang.*;
import java.io.*;
import java.util.*;
import java.awt.Point;


public class Main {

    static int n, m;
    static int[][] arr;
    static int cnt, max;
    static boolean[][] visited;

    //상하좌우
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};


    public static void main(String[] argc) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        //가로 세로
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        visited = new boolean[n][m];
        cnt = 0;
        max = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (arr[i][j] == 1 && !visited[i][j]) {
                    cnt++;
                    max = Math.max(max, bfs(i, j));
                }
            }
        }

        System.out.println(cnt);
        System.out.println(max);
    }

    static int bfs(int x, int y) {
        Deque<Point> queue = new ArrayDeque<>();
        queue.add(new Point(x, y));
        visited[x][y] = true;
        int area = 1;

        while (!queue.isEmpty()) {
            Point p = queue.poll();

            //상하좌우 탐색
            for (int i = 0; i < 4; i++) {
                int nextX = p.x + dx[i];
                int nextY = p.y + dy[i];

                if (nextX < 0 || nextX >= n || nextY < 0 || nextY >= m) continue;
                if (visited[nextX][nextY]) continue;
                if (arr[nextX][nextY] == 0) continue;

                visited[nextX][nextY] = true;
                queue.add(new Point(nextX,nextY));
                area++;
            }

        }
        return area;
    }
}