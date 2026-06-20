

import java.lang.*;
import java.io.*;
import java.util.*;
import java.awt.Point;


public class Main {

    //상하좌우
    static int dx[] = {0, 0, 1, -1};
    static int dy[] = {1, -1, 0, 0};
    static int n, m;
    static int[][] arr, count;
    static boolean[][] isVisited;

    public static void main(String[] argc) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());


        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n][m];
        isVisited = new boolean[n][m];
        count = new int[n][m];

        int x = 0;
        int y = 0;


        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());

                if (arr[i][j] == 2) {
                    x = i;
                    y = j;
                }
            }
        }

        bfs(x, y);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (arr[i][j] == 0 || arr[i][j] == 2) {
                    System.out.print("0 ");
                } else if (!isVisited[i][j] && arr[i][j] == 1) {
                    System.out.print("-1 ");
                } else {
                    System.out.print(count[i][j] + " ");
                }
            }
            System.out.println();
        }


    }

    static void bfs(int x, int y) {
        Deque<Point> queue = new ArrayDeque<>();
        queue.add(new Point(x, y));
        isVisited[x][y] = true;

        while (!queue.isEmpty()) {
            Point p = queue.poll();

            //상하좌우 탐색
            for (int i = 0; i < 4; i++) {
                int nextX = p.x + dx[i];
                int nextY = p.y + dy[i];

                if (0 <= nextX && nextX < n && 0 <= nextY && nextY < m && !isVisited[nextX][nextY] && arr[nextX][nextY] == 1) {
                    isVisited[nextX][nextY] = true;
                    queue.add(new Point(nextX, nextY));
                    count[nextX][nextY] = count[p.x][p.y] + 1;
                }
            }
        }
    }
}