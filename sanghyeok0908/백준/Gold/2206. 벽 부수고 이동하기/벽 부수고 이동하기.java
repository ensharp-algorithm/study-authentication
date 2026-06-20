import java.io.*;
import java.util.*;

public class Main {

    static int[] dx = new int[]{-1, 1, 0, 0};
    static int[] dy = new int[]{0, 0, -1, 1};
    static int[][] graph;
    static int N, M;
    static int[][][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] str = br.readLine().split(" ");
        N = Integer.parseInt(str[0]);
        M = Integer.parseInt(str[1]);
        graph = new int[N][M];
        visited = new int[N][M][2];

        for (int i = 0; i < N; i++) {
            char[] charArray = br.readLine().toCharArray();
            for (int j = 0; j < M; j++) graph[i][j] = charArray[j] - '0';
        }

        bfs();

        int notBrokenCount = visited[N - 1][M - 1][0];
        int brokenCount = visited[N - 1][M - 1][1];
        if (notBrokenCount == 0 && brokenCount == 0) {
            // 출발지와 목적지가 동일할 때
            if (N == 1 && M == 1) bw.write("1\n");
            // 둘 다 접근하지 못했을 때
            else bw.write("-1\n");
        } else {
            if (notBrokenCount == 0) {
                // 벽을 부섰을 때만 도달했을 때
                bw.write((brokenCount + 1) + "\n");
            } else if (brokenCount == 0) {
                // 벽을 부수지 않았을 때만 도달했을 때
                bw.write((notBrokenCount + 1) + "\n");
            } else if (notBrokenCount < brokenCount) {
                // 둘 다 도달 했을 때 최소 거리
                bw.write((notBrokenCount + 1) + "\n");
            } else {
                // 둘 다 도달 했을 때 최소 거리
                bw.write((brokenCount + 1) + "\n");
            }
        }
        bw.close();
    }

    static void bfs() {
        Queue<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{0, 0, 0});

        while (!queue.isEmpty()) {
            int[] poll = queue.poll();

            for (int i = 0; i < 4; i++) {
                int curY = poll[0] + dy[i];
                int curX = poll[1] + dx[i];

                if (curX < 0 || curY < 0 || curX >= M || curY >= N)
                    continue;

                // 1. 아직 벽을 부스지 않았을 때 graph[curY][curX] == 1일 때
                // 2. 벽을 부순 적이 있는 상태에서 graph[curY][curX] == 0일 때
                if (graph[curY][curX] == 1 && poll[2] == 0) {
                    queue.add(new int[]{curY, curX, 1});
                    visited[curY][curX][1] = visited[poll[0]][poll[1]][0] + 1;
                } else if (graph[curY][curX] == 0 && visited[curY][curX][poll[2]] == 0) {
                    queue.add(new int[]{curY, curX, poll[2]});
                    visited[curY][curX][poll[2]] = visited[poll[0]][poll[1]][poll[2]] + 1;
                }
            }
        }
    }
}