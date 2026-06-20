import java.io.*;
import java.util.*;

public class Main {

    static int n, m;
    static int[][] graph;

    static void bfs() {
        int[][] position = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] isVisited = new boolean[n][m];

        queue.add(new int[]{0, 0});

        while(!queue.isEmpty()) {
            int[] pop = queue.poll();

            for(int[] pos: position) {
                int curX = pop[0] + pos[0];
                int curY = pop[1] + pos[1];

                if (curX < 0 || curY < 0 || curX >= n || curY >= m) continue;

                if (graph[curX][curY] == 1 && !isVisited[curX][curY]) {
                    queue.add(new int[]{curX, curY});
                    isVisited[curX][curY] = true;
                    graph[curX][curY] = graph[pop[0]][pop[1]] + 1;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] str = br.readLine().split(" ");

        n = Integer.parseInt(str[0]);
        m = Integer.parseInt(str[1]);
        graph = new int[n][m];

        for (int i = 0; i < n; i++) {
            char[] charArray = br.readLine().toCharArray();
            for (int j = 0; j < m; j++) {
                graph[i][j] = charArray[j] - '0';
            }
        }

        bfs();
        bw.write(graph[n - 1][m - 1] + "\n");
        bw.close();
    }
}