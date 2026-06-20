

import java.lang.*;
import java.io.*;
import java.util.*;
import java.awt.Point;


public class Main {

    static int n, m;
    static int[][] arr;

    //상하좌우
    static int[] dx = {0, 0, - 1, 1};
    static int[] dy = {1, -1, 0, 0};


    public static void main(String[] argc) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[n][m];

        for (int i = 0; i < n; i++) {
            String s = br.readLine();

            for (int j = 0; j < m; j++) {
                arr[i][j] = (s.charAt(j) - '0');
            }
        }

        bfs(0, 0);
        System.out.println(arr[n - 1][m - 1]);

    }

    static void bfs(int x, int y) {
        Deque<Point> queue = new ArrayDeque<>();
        queue.add(new Point(x, y));

        while (!queue.isEmpty()) {

            Point p = queue.poll();
            for (int i = 0; i < 4; i++) {
                int nextX = p.x + dx[i];
                int nextY = p.y + dy[i];

                if (nextX < 0 || nextX >= n || nextY < 0 || nextY >= m) continue;
                if (arr[nextX][nextY]!= 1) continue;

                queue.add(new Point(nextX, nextY));
                arr[nextX][nextY] = arr[p.x][p.y] + 1;
            }
        }
    }
}