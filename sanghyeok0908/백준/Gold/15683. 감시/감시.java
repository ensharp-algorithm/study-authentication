import java.io.*;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int N, M;
    static int[][] inputArr;
    static List<int[]> cctv = new ArrayList<>();  // {y, x, maxCount, count}

    public static void main(String[] args) throws IOException {
        String[] s = br.readLine().split(" ");
        int iterationCount = 1;
        int min = 65;

        N = Integer.parseInt(s[0]);
        M = Integer.parseInt(s[1]);
        inputArr = new int[N][M];

        for (int i = 0; i < N; i++) {
            inputArr[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

            for (int j = 0; j < M; j++) {
                switch (inputArr[i][j]) {
                    case 1:
                    case 3:
                    case 4:
                        cctv.add(new int[]{i, j, 4, 0});
                        iterationCount *= 4;
                        break;
                    case 2:
                        cctv.add(new int[]{i, j, 2, 0});
                        iterationCount *= 2;
                        break;
                    case 5:
                        cctv.add(new int[]{i, j, 1, 0});
                }
            }
        }

        for (int i = 0, cctvIdx = 0; i < iterationCount; i++, cctvIdx = 0) {
            boolean[][] isVisited = new boolean[N][M];

            for (int[] cc : cctv) {
                int[][] direction = getDirection(cc[0], cc[1], cc[3]);

                if (direction == null) continue;

                for (int[] d : direction) {
                    dfs(isVisited, cc[0], cc[1], d);
                }
            }

            min = Math.min(min, getZeroCount(isVisited));

            while (cctvIdx < cctv.size()) {
                if (cctv.get(cctvIdx)[3] + 1 < cctv.get(cctvIdx)[2]) {
                    cctv.get(cctvIdx)[3] += 1;
                    break;
                } else {
                    cctv.get(cctvIdx)[3] = 0;
                    cctvIdx++;
                }
            }
        }

        bw.write(min + "\n");
        br.close();
        bw.close();
    }

    static void dfs(boolean[][] isVisited, int prevY, int prevX, int[] direction) {
        int curY = prevY + direction[0];
        int curX = prevX + direction[1];

        isVisited[prevY][prevX] = true;

        if (curY < 0 || curY >= N || curX < 0 || curX >= M || inputArr[curY][curX] == 6) return;

        dfs(isVisited, curY, curX, direction);
    }

    static int getZeroCount(boolean[][] isVisited) throws IOException {
        int count = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (!isVisited[i][j] && inputArr[i][j] != 6) {
                    count++;
                }
            }
        }
        return count;
    }

    static int[][] getDirection(int y, int x, int count) {
        switch (inputArr[y][x]) {
            case 1:
                switch (count) {
                    case 0:
                        return new int[][]{{0, 1}};
                    case 1:
                        return new int[][]{{1, 0}};
                    case 2:
                        return new int[][]{{0, -1}};
                    case 3:
                        return new int[][]{{-1, 0}};
                }
                break;
            case 2:
                switch (count) {
                    case 0:
                        return new int[][]{{0, 1}, {0, -1}};
                    case 1:
                        return new int[][]{{1, 0}, {-1, 0}};
                }
                break;
            case 3:
                switch (count) {
                    case 0:
                        return new int[][]{{-1, 0}, {0, 1}};
                    case 1:
                        return new int[][]{{1, 0}, {0, 1}};
                    case 2:
                        return new int[][]{{1, 0}, {0, -1}};
                    case 3:
                        return new int[][]{{-1, 0}, {0, -1}};
                }
                break;
            case 4:
                switch (count) {
                    case 0:
                        return new int[][]{{0, -1}, {-1, 0}, {0, 1}};
                    case 1:
                        return new int[][]{{0, -1}, {1, 0}, {0, 1}};
                    case 2:
                        return new int[][]{{0, -1}, {1, 0}, {-1, 0}};
                    case 3:
                        return new int[][]{{-1, 0}, {0, 1}, {1, 0}};
                }
                break;
            case 5:
                switch (count) {
                    case 0:
                        return new int[][]{{0, -1}, {-1, 0}, {0, 1}, {1, 0}};
                }
                break;
        }
        return null;
    }
}