import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

  static int N, M;
  static int[][] matrix;
  static int[] dy = new int[] { -1, 1, 0, 0 };
  static int[] dx = new int[] { 0, 0, -1, 1 };
  static int answer = 0;

  public static void main(String[] args) throws Exception {
    int[] input = Arrays.stream(br.readLine().split(" "))
        .mapToInt(Integer::parseInt).toArray();

    N = input[0];
    M = input[1];
    matrix = new int[N][M];

    input = Arrays.stream(br.readLine().split(" "))
        .mapToInt(Integer::parseInt).toArray();

    int y = input[0];
    int x = input[1];
    int d = input[2];

    for (int i = 0; i < N; i++) {
      matrix[i] = Arrays.stream(br.readLine().split(" "))
          .mapToInt(Integer::parseInt).toArray();
    }

    calculate(y, x, d);
    System.out.println(answer);
  }

  static void calculate(int y, int x, int d) {
    // System.out.println(String.format("=========== (%d, %d), d = %d", y, x, d));
    // for (int i = 0; i < N; i++) {
    //   for (int j = 0; j < M; j++) {
    //     System.out.print(matrix[i][j] + " ");
    //   }
    //   System.out.println("");
    // }

    if (matrix[y][x] == 1)
      return;

    if (matrix[y][x] == 0) {
      answer++;
      matrix[y][x] = 2;
    }

    // 주변에 청소하지 않은 칸 조회
    if (bfs(y, x)) {

      for (int i = 0; i < 4; i++) {
        d--;
        d = d < 0 ? d + 4 : d;

        switch (d) {
          case 0:
            if (matrix[y - 1][x] == 0) {
              calculate(y - 1, x, d);
              return;
            }
            break;
          case 1:
            if (matrix[y][x + 1] == 0) {
              calculate(y, x + 1, d);
              return;
            }
            break;
          case 2:
            if (matrix[y + 1][x] == 0) {
              calculate(y + 1, x, d);
              return;
            }
            break;
          case 3:
            if (matrix[y][x - 1] == 0) {
              calculate(y, x - 1, d);
              return;
            }
            break;
        }
      }

      // System.out.println("error");
      return;
    }

    // 주변 4칸 모두 청소 안한 빈칸이 없을 경우

    switch (d) {
      case 0:
        calculate(y + 1, x, d);
        return;
      case 1:
        calculate(y, x - 1, d);
        return;
      case 2:
        calculate(y - 1, x, d);
        return;
      case 3:
        calculate(y, x + 1, d);
        return;
    }
  }

  static boolean bfs(int y, int x) {
    for (int i = 0; i < 4; i++) {
      int curY = y + dy[i];
      int curX = x + dx[i];

      if (matrix[curY][curX] != 0)
        continue;

      return true;
    }
    return false;
  }
}