import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int[] dy = new int[] { -1, 1, 0, 0 };
    static int[] dx = new int[] { 0, 0, -1, 1 };
    static int N;
    static int[][] matrix;
    // static int[][][] map;

    public static void main(String[] args) throws Exception {
        N = Integer.parseInt(br.readLine());
        matrix = new int[N][N];
        // map = new int[N][N][2];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                matrix[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int number = 2;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (matrix[i][j] == 1) {
                    setMatrix(i, j, number++);
                }
            }
        }

        int answer = Integer.MAX_VALUE;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (matrix[i][j] != 0) {
                    answer = Math.min(answer, calculate(i, j));
                }
            }
        }
        System.out.println(answer == Integer.MAX_VALUE ? 0 : answer);
    }

    static void setMatrix(int y, int x, int number) {
        Queue<int[]> queue = new ArrayDeque<>();
        queue.add(new int[] { y, x });
        matrix[y][x] = number;

        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            for (int i = 0; i < 4; i++) {
                int curY = poll[0] + dy[i];
                int curX = poll[1] + dx[i];

                if (!isIn(curY, curX) || matrix[curY][curX] != 1)
                    continue;

                matrix[curY][curX] = number;
                queue.add(new int[] { curY, curX });
            }
        }
    }

    static int calculate(int y, int x) {
        int result = Integer.MAX_VALUE;
        int number = matrix[y][x];
        Queue<int[]> queue = new ArrayDeque<>();
        boolean[][] visited = new boolean[N][N];

        queue.add(new int[] { y, x, 0 });
        visited[y][x] = true;

        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            for (int i = 0; i < 4; i++) {
                int curY = poll[0] + dy[i];
                int curX = poll[1] + dx[i];
                int value = poll[2];

                if (!isIn(curY, curX) || visited[curY][curX])
                    continue;

                visited[curY][curX] = true;

                if (matrix[curY][curX] == 0) {
                    queue.add(new int[] { curY, curX, value + 1 });
                } else if (matrix[curY][curX] > number) {
                    result = Math.min(result, value);
                }
            }
        }

        return result;
    }

    static boolean isIn(int y, int x) {
        return y >= 0 && y < N && x >= 0 && x < N;
    }

    static void print() {
        System.out.println("============");
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}
