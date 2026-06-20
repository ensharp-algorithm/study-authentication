import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

  static class Position {
    public int y, x;

    public Position(int y, int x) {
      this.y = y;
      this.x = x;
    }
  }

  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  static int N, M;
  static int[][] matrix;
  static List<int[]> viruses = new ArrayList<>();
  static boolean[][] isUsed;
  static Position[] trackingArr = new Position[3];
  static int[] dy = new int[] { -1, 1, 0, 0 };
  static int[] dx = new int[] { 0, 0, -1, 1 };
  static int answer = 0;

  public static void main(String[] args) throws Exception {
    int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
    N = input[0];
    M = input[1];
    matrix = new int[N][M];
    isUsed = new boolean[N][M];

    for (int i = 0; i < N; i++) {
      matrix[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

      for (int j = 0; j < M; j++) {
        if (matrix[i][j] == 2) {
          viruses.add(new int[] { i, j });
        }
      }
    }

    backTracking(0);
    System.out.println(answer);
  }

  static void backTracking(int depth) {
    if (depth == 3) {
      // System.out.println("==========");
      // for (int i = 0; i < 3; i++) {
      // System.out.println(trackingArr[i].y + ", " + trackingArr[i].x);
      // }

      int[][] newMatrix = createNewMatrix();
      answer = Math.max(answer, bfs(newMatrix));
      return;
    }

    for (int i = 0; i < N; i++) {
      for (int j = 0; j < M; j++) {
        if (isUsed[i][j] || matrix[i][j] != 0) {
          continue;
        }

        isUsed[i][j] = true;
        trackingArr[depth] = new Position(i, j);
        backTracking(depth + 1);
        isUsed[i][j] = false;
      }
    }
  }

  static int[][] createNewMatrix() {
    int[][] result = new int[N][M];

    for (int i = 0; i < N; i++) {
      result[i] = matrix[i].clone();
    }

    for (Position p : trackingArr) {
      result[p.y][p.x] = 1;
    }
    return result;
  }

  static int bfs(int[][] newMatrix) {
    int result = 0;
    Queue<int[]> queue = new ArrayDeque<>(viruses);
    boolean[][] isVisited = new boolean[N][M];

    for (int[] v : viruses) {
      isVisited[v[0]][v[1]] = true;
    }

    while (!queue.isEmpty()) {
      int[] prev = queue.poll();

      for (int i = 0; i < 4; i++) {
        int curY = prev[0] + dy[i];
        int curX = prev[1] + dx[i];

        if (curY < 0 || curY >= N || curX < 0 || curX >= M ||
            isVisited[curY][curX] || newMatrix[curY][curX] != 0) {
          continue;
        }

        isVisited[curY][curX] = true;
        newMatrix[curY][curX] = 2;
        queue.add(new int[] { curY, curX });
      }
    }

    for (int i = 0; i < N; i++) {
      for (int j = 0; j < M; j++) {
        if (newMatrix[i][j] == 0)
          result++;
      }
    }

    return result;
  }
}
