import java.io.*;
import java.util.*;

public class Main {

    static int m, n;
    static int[][] graph;
    static Queue<int[]> queue = new ArrayDeque<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int max = 0;
        String[] str = br.readLine().split(" ");
        m = Integer.parseInt(str[0]);
        n = Integer.parseInt(str[1]);
        graph = new int[n][m];

        for (int i = 0; i < n; i++) {
            graph[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (graph[i][j] == 1) {
                    queue.add(new int[]{i, j});
                }
            }
        }

        bfs();

//        for (int i = 0; i < n; i++) {
//            for (int j = 0; j < m; j++) {
//                bw.write(graph[i][j] + " ");
//            }
//            bw.write("\n");
//        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (graph[i][j] == 0) {
                    bw.write("-1\n");
                    bw.close();
                    return;
                }

                max = Math.max(max, graph[i][j]);
            }
        }

        bw.write((max - 1) + "\n");
        bw.close();
    }

    static void bfs() {
        int[][] direction = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        boolean[][] isVisited = new boolean[n][m];

        while (!queue.isEmpty()) {
            int[] current = queue.poll();

            for (int[] d : direction) {
                int x = current[0] + d[0];
                int y = current[1] + d[1];

                if (x < 0 || x >= n || y < 0 || y >= m) continue;

                if (graph[x][y] == 0 && !isVisited[x][y]) {
                    graph[x][y] = graph[current[0]][current[1]] + 1;
                    queue.add(new int[]{x, y});
                    isVisited[x][y] = true;
                }
            }
        }
    }
}