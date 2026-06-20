import java.io.*;
import java.util.*;

public class Main {

    static final int[] dx = new int[]{-1, 1, 0, 0};
    static final int[] dy = new int[]{0, 0, -1, 1};
    static boolean[][] isVisited;
    static int[][] graph;
    static int N, M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        // N: 행의 개수, M: 열의 개수
        N = input[0];
        M = input[1];

        graph = new int[N][M];

        for (int i = 0; i < N; i++) {
            graph[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        bw.write(solve() + "\n");

        bw.close();
    }

    static int solve() {
        int result = 0;
        boolean isSplit = false;

        while (!isSplit) {
            int seaCount = 0;

            isVisited = new boolean[N][M];

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (graph[i][j] != 0) {
                        melt(j, i);
                    }
                }
            }

            for (int i = 0; i < N; i++) {
                boolean isBreak = false;

                for (int j = 0; j < M; j++) {
                    if (graph[i][j] != 0) {
                        isSplit = bfs(j, i);
                        isBreak = true;
                        break;
                    }
                }

                if (isBreak) break;
            }

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (graph[i][j] == 0) seaCount++;
                }
            }

            if (N * M == seaCount) return 0;

            result++;
        }
        return result;
    }

    static boolean bfs(int x, int y) {
        Deque<int[]> deque = new ArrayDeque<>();

        isVisited = new boolean[N][M];
        isVisited[y][x] = true;

        deque.add(new int[]{x, y});

        while (!deque.isEmpty()) {
            int[] poll = deque.poll();

            for (int i = 0; i < 4; i++) {
                int curX = poll[0] + dx[i];
                int curY = poll[1] + dy[i];

                if (!isInGraph(curX, curY) || isVisited[curY][curX] || graph[curY][curX] == 0) continue;

                // (x, y)에 인접한 (curX, curY)가 빙하일 때
                isVisited[curY][curX] = true;
                deque.add(new int[]{curX, curY});
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                // 접근하지 못한 빙하가 있을 때 분리된 것으로 간주한다.
                if (!isVisited[i][j] && graph[i][j] != 0) {
                    return true;
                }
            }
        }

        return false;
    }

    static void melt(int x, int y) {
        int count = 0;

        for (int i = 0; i < 4; i++) {
            int curX = x + dx[i];
            int curY = y + dy[i];

            if (isInGraph(curX, curY) && !isVisited[curY][curX] && graph[curY][curX] == 0) count++;
        }

        isVisited[y][x] = true; // 같은 날 바다가 된 빙하 좌표는 무시하여야 하기 때문에 방문처리를 한다.
        graph[y][x] -= count;

        if (graph[y][x] < 0) graph[y][x] = 0;
    }

    static boolean isInGraph(int x, int y) {
        return x >= 0 && x < M && y >= 0 && y < N;
    }
}