import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  static int N;
  static int[][] arr;
  static boolean[][][] matrix;

  public static void main(String[] args) throws Exception {
    N = Integer.parseInt(br.readLine());
    arr = new int[N][4];
    matrix = new boolean[N][101][101];

    for (int i = 0; i < N; i++) {
      arr[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
      matrix[i][arr[i][1]][arr[i][0]] = true;

      int[] end = drawLine(i, new int[] { arr[i][1], arr[i][0] }, arr[i][2]);

      if (arr[i][3] > 0) {
        List<Integer> directions = new ArrayList<>();
        directions.add(arr[i][2]);

        setMatrix(i, 1, end, directions);
      }
    }

    System.out.println(calcuate());
  }

  static void setMatrix(int idx, int depth, int[] end, List<Integer> directions) {
    if (depth > arr[idx][3]) {
      return;
    }

    for (int i = directions.size() - 1; i >= 0; i--) {
      int direction = (directions.get(i) + 1) % 4;

      end = drawLine(idx, end, direction);
      directions.add(direction);
    }

    // System.out.println("==========");

    setMatrix(idx, depth + 1, end, directions);
  }

  static int[] drawLine(int idx, int[] start, int direction) {
    int endY = -1;
    int endX = -1;

    switch (direction) {
      case 0:
        endY = start[0];
        endX = start[1] + 1;
        break;
      case 1:
        endY = start[0] - 1;
        endX = start[1];
        break;
      case 2:
        endY = start[0];
        endX = start[1] - 1;
        break;
      case 3:
        endY = start[0] + 1;
        endX = start[1];
        break;
    }

    matrix[idx][endY][endX] = true;

    // System.out.println(String.format("(%d, %d) -> (%d, %d)", start[1], start[0],
    // endX, endY));

    return new int[] { endY, endX };
  }

  /*
   * 0 -> 1
   * 1 -> 2
   * 2 -> 3
   * 3 -> 0
   */

  static int calcuate() {
    int result = 0;

    for (int n = 1; n < N; n++) {
      for (int i = 0; i < 101; i++) {
        for (int j = 0; j < 101; j++) {
          if (matrix[n][i][j]) {
            matrix[0][i][j] = true;
          }
        }
      }
    }

    for (int i = 0; i < 100; i++) {
      for (int j = 0; j < 100; j++) {
        if (matrix[0][i][j] &&
            matrix[0][i][j + 1] &&
            matrix[0][i + 1][j] &&
            matrix[0][i + 1][j + 1]) {
          result++;
        }
      }
    }

    return result;
  }
}
