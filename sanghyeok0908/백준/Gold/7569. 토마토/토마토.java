import java.io.*;
import java.util.*;

public class Main {

    static int[][][] graph;
    static boolean[][][] isVisited;
    static int M, N, H;
    static Queue<int[]> queue = new ArrayDeque<>();
    static int[][] direction = new int[][]{{-1, 0, 0}, {1, 0, 0}, {0, -1, 0}, {0, 1, 0}, {0, 0, -1}, {0, 0, 1}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] str = br.readLine().split(" ");
        int max = 0;

        M = Integer.parseInt(str[0]);
        N = Integer.parseInt(str[1]);
        H = Integer.parseInt(str[2]);
        graph = new int[H][N][M];
        isVisited = new boolean[H][N][M];

        for (int i = 0; i < H; i++) {
            for (int j = 0; j < N; j++) {
                graph[i][j] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            }
        }

        for (int i = 0; i < H; i++) {
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < M; k++) {
                    if (!isVisited[i][j][k] && graph[i][j][k] == 1) {
                        isVisited[i][j][k] = true;
                        queue.add(new int[]{i, j, k});
                    }
                }
            }
        }

        bfs();

        for (int i = 0; i < H; i++) {
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < M; k++) {
                    if (graph[i][j][k] == 0) {
                        bw.write("-1\n");
                        bw.close();
                        return;
                    }

                    max = Math.max(max, graph[i][j][k]);
                }
            }
        }

        bw.write((max - 1) + "\n");
        bw.close();
    }

    static void bfs() {
        while (!queue.isEmpty()) {
            int[] poll = queue.poll();

            for (int[] d : direction) {
                int curZ = poll[0] + d[0];
                int curY = poll[1] + d[1];
                int curX = poll[2] + d[2];

                if (curX < 0 || curY < 0 || curZ < 0 || curX >= M || curY >= N || curZ >= H || isVisited[curZ][curY][curX])
                    continue;

                if (graph[curZ][curY][curX] == 0) {
                    isVisited[curZ][curY][curX] = true;
                    queue.add(new int[]{curZ, curY, curX});
                    graph[curZ][curY][curX] = graph[poll[0]][poll[1]][poll[2]] + 1;
                }
            }
        }
    }
}