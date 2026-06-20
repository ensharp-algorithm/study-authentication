import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

  static int N, M;
  static int[][] matrix;
  static int[] dy = new int[] { -1, 1, 0, 0 };
  static int[] dx = new int[] { 0, 0, -1, 1 };
  static int max = 0;
  static boolean[][] isVisited;

  public static void main(String[] args) throws Exception {
    int[] input = Arrays.stream(br.readLine().split(" "))
        .mapToInt(Integer::parseInt).toArray();
    N = input[0];
    M = input[1];
    matrix = new int[N][M];
    isVisited = new boolean[N][M];

    for (int i = 0; i < N; i++) {
      matrix[i] = Arrays.stream(br.readLine().split(" "))
          .mapToInt(Integer::parseInt).toArray();
    }

    for (int i = 0; i < N; i++) {
      for (int j = 0; j < M; j++) {
        isVisited[i][j] = true;
        backTracking(i, j, matrix[i][j], 1);
        isVisited[i][j] = false;
      }
    }

    System.out.println(max);
  }

  static void backTracking(int y, int x, int sum, int depth) {
    if (depth == 4) {
      max = Math.max(max, sum);
      return;
    }

    for (int i = 0; i < 4; i++) {
      int curY = y + dy[i];
      int curX = x + dx[i];

      if (curY < 0 || curY >= N || curX < 0 || curX >= M || isVisited[curY][curX]) {
        continue;
      }

      if (depth == 2) {
        isVisited[curY][curX] = true;
        backTracking(y, x, sum + matrix[curY][curX], depth + 1);
        isVisited[curY][curX] = false;
      }

      isVisited[curY][curX] = true;
      backTracking(curY, curX, sum + matrix[curY][curX], depth + 1);
      isVisited[curY][curX] = false;
    }
  }
}