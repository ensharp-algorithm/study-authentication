import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static char[][] graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        graph = new char[N][N];

        for (int i = 0; i < N; i++) {
            graph[i] = br.readLine().toCharArray();
        }

        int r = solve('R');
        int g = solve('G');
        int b = solve('B');

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (graph[i][j] == 'G') {
                    graph[i][j] = 'R';
                }
            }
        }

        int rg = solve('R');
        bw.write((r + g + b) + " " + (rg + b) + "\n");
        bw.close();
    }

    static int solve(char color) {
        int result = 0;
        boolean[][] isVisited = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (graph[i][j] == color && !isVisited[i][j]) {
                    result++;
                    bfs(color, i, j, isVisited);
                }
            }
        }
        return result;
    }

    static void bfs(char color, int i, int j, boolean[][] isVisited) {
        int[][] direction = new int[][]{{0, -1}, {0, 1}, {-1, 0}, {1, 0}};
        Queue<int[]> queue = new ArrayDeque<>();

        queue.add(new int[]{i, j});
        isVisited[i][j] = true;

        while (!queue.isEmpty()) {
            int[] poll = queue.poll();

            for (int[] d : direction) {
                int curY = poll[0] + d[0];
                int curX = poll[1] + d[1];

                if (curX < 0 || curX >= N || curY < 0 || curY >= N || isVisited[curY][curX]) continue;

                if (graph[curY][curX] == color) {
                    queue.add(new int[]{curY, curX});
                    isVisited[curY][curX] = true;
                }
            }
        }
    }
}