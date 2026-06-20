
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N, M;
    static int[][] matrix;
    static int[] dy = new int[] { -1, 1, 0, 0 };
    static int[] dx = new int[] { 0, 0, -1, 1 };

    public static void main(String[] args) throws Exception {
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int t = 1; t <= T; t++) {
            int answer = 0;
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            matrix = new int[N][N];
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    matrix[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    int result = bfs(i, j);
                    answer = Math.max(answer, result);
                }
            }

            sb.append("#" + t + " " + answer + "\n");
        }
        System.out.println(sb);
    }

    static int bfs(int centerY, int centerX) {
        int result = 0;

        // System.out.printf("center Y = %d, X = %d\n", centerY, centerX);

        for (int k = 1; k <= 25; k++) {
            int operCost = k * k + (k - 1) * (k - 1);
            int homeCnt = matrix[centerY][centerX] == 1 ? 1 : 0;
            Queue<int[]> queue = new ArrayDeque<>();
            boolean[][] visited = new boolean[N][N];

            queue.add(new int[] { centerY, centerX });
            visited[centerY][centerX] = true;

            while (!queue.isEmpty()) {
                int[] poll = queue.poll();

                for (int i = 0; i < 4; i++) {
                    int curY = poll[0] + dy[i];
                    int curX = poll[1] + dx[i];
                    int dist = Math.abs(curY - centerY) + Math.abs(curX - centerX);

                    if (curY < 0 || curY >= N || curX < 0 || curX >= N ||
                            visited[curY][curX] || k - 1 < dist) {
                        continue;
                    }

                    queue.add(new int[] { curY, curX });
                    visited[curY][curX] = true;

                    if (matrix[curY][curX] == 1) {
                        homeCnt++;
                    }
                }
            }

            if (homeCnt * M - operCost >= 0) {
                result = Math.max(result, homeCnt);
                // System.out.printf("K = %d, operCost = %d, homeCnt = %d\n", k, operCost, homeCnt);
                // System.out.println("result = " + result);
            }
        }

        return result;
    }
}
