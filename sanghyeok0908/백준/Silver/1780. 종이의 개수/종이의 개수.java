import java.io.*;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int N;
    static int[][] matrix;
    static int[] dx = new int[]{-1, 1, 0, 0};
    static int[] dy = new int[]{0, 0, -1, 1};
    // count[0] = -1의 개수, count[1] = 0의 개수, count[2] = 1의 개수
    static int[] count = new int[3];

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        matrix = new int[N][N];

        for (int i = 0; i < N; i++) {
            matrix[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        recursion(N, 0, 0);

        for (int i = 0; i < 3; i++) bw.write(count[i] + "\n");
        br.close();
        bw.close();
    }

    // 행렬이 동일한 숫자인지 확인해야 한다.
    // 동일하지 않다면 행렬을 9등분으로 쪼개야 한다.
    // 쪼갠 9등분 행렬을 각각 동일한 숫자인지 다시 확인한다.
    static void recursion(int size, int startY, int startX) {
        if (startY < 0 || startY >= N || startX < 0 || startX >= N) return;

        if (size == 1 || isSamePaper(startY, startX, startY + size - 1, startX + size - 1)) {
            if (matrix[startY][startX] == -1) count[0]++;
            else if (matrix[startY][startX] == 0) count[1]++;
            else if (matrix[startY][startX] == 1) count[2]++;
            return;
        }

        for(int i = 0; i < size; i += size / 3) {
            for(int j = 0; j < size; j += size / 3) {
                recursion(size / 3, startY + i, startX + j);
            }
        }
    }

    static boolean isSamePaper(int startY, int startX, int endY, int endX) {
        int first = matrix[startY][startX];
        for(int i = startY; i <= endY; i++) {
            for(int j = startX; j <= endX; j++) {
                if (first != matrix[i][j]) return false;
            }
        }
        return true;
    }

    static boolean bfs(int startY, int startX, int endY, int endX) {
        boolean[][] isVisited = new boolean[N][N];
        Queue<int[]> queue = new ArrayDeque<>();

        isVisited[startY][startX] = true;
        queue.add(new int[]{startY, startX});

        while (!queue.isEmpty()) {
            int[] poll = queue.poll();

            for (int i = 0; i < 4; i++) {
                int curY = poll[0] + dy[i];
                int curX = poll[1] + dx[i];

                if (curY < startY || curY > endY || curX < startX || curX > endX || isVisited[curY][curX])
                    continue;

                if (matrix[startY][startX] != matrix[curY][curX]) return false;

                isVisited[curY][curX] = true;
                queue.add(new int[]{curY, curX});
            }
        }

        return true;
    }
}