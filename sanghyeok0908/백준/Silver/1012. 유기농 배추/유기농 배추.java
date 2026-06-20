import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            String[] str = br.readLine().split(" ");
            int M = Integer.parseInt(str[0]);
            int N = Integer.parseInt(str[1]);
            int count = Integer.parseInt(str[2]);
            int[][] graph = new int[N][M];
            int answer = 0;

            for (int j = 0; j < count; j++) {
                int[] current = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
                graph[current[1]][current[0]] = 1;
            }

            for (int j = 0; j < N; j++) {
                for (int k = 0; k < M; k++) {
                    if (graph[j][k] == 1) {
                        answer++;
                        bfs(M, N, graph, k, j);
                    }
                }
            }

            bw.write(answer + "\n");
        }
        bw.close();
    }

    static void bfs(int M, int N, int[][] graph, int x, int y) {
        int[][] direction = new int[][]{{0, -1}, {0, 1}, {-1, 0}, {1, 0}};
        Queue<int[]> queue = new ArrayDeque<>();

        queue.add(new int[]{x, y});
        graph[y][x] = 2;

        while (!queue.isEmpty()) {
            int[] poll = queue.poll();

            for (int[] d : direction) {
                int currentX = poll[0] + d[0];
                int currentY = poll[1] + d[1];

                if (currentX < 0 || currentX >= M || currentY < 0 || currentY >= N) continue;

                if (graph[currentY][currentX] == 1) {
                    queue.add(new int[]{currentX, currentY});
                    graph[currentY][currentX] = 2;
                }
            }
        }
    }
}