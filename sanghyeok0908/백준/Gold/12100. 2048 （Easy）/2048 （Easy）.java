import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  static int N;
  static int max = 0;
  static int[] arr = new int[5];

  public static void main(String[] args) throws Exception {
    N = Integer.parseInt(br.readLine());

    int[][] matrix = new int[N][N];

    for (int i = 0; i < N; i++)
      matrix[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

    func(0, matrix);
    System.out.println(max);
  }

  static void func(int depth, int[][] matrix) {
    if (depth == 5) {
      int[][] copyMatrix = createCopyMatrix(matrix);

      for (int a : arr) {
        move(copyMatrix, a);
      }

      setMaxCount(copyMatrix);
      return;
    }

    for (int i = 0; i < 4; i++) {
      arr[depth] = i;
      func(depth + 1, matrix);
    }
  }

  static void move(int[][] matrix, int directCount) {
    if (directCount == 0) {
      // left
      for (int i = 0; i < N; i++) {
        int value = 0;
        int cur = 0;

        for (int j = 0; j < N; j++) {
          if (matrix[i][j] == 0)
            continue;

          if (value == matrix[i][j]) {
            matrix[i][cur - 1] = value * 2;
            value = 0;
            matrix[i][j] = 0;
          } else {
            value = matrix[i][j];
            matrix[i][j] = 0;
            matrix[i][cur++] = value;
          }
        }
      }
    } else if (directCount == 1) {
      // top
      for (int i = 0; i < N; i++) {
        int value = 0;
        int cur = 0;

        for (int j = 0; j < N; j++) {
          if (matrix[j][i] == 0)
            continue;

          if (value == matrix[j][i]) {
            matrix[cur - 1][i] = value * 2;
            value = 0;
            matrix[j][i] = 0;
          } else {
            value = matrix[j][i];
            matrix[j][i] = 0;
            matrix[cur++][i] = value;
          }
        }
      }
    } else if (directCount == 2) {
      // right
      for (int i = N - 1; i >= 0; i--) {
        int value = 0;
        int cur = N - 1;

        for (int j = N - 1; j >= 0; j--) {
          if (matrix[i][j] == 0)
            continue;

          if (value == matrix[i][j]) {
            matrix[i][cur + 1] = value * 2;
            value = 0;
            matrix[i][j] = 0;
          } else {
            value = matrix[i][j];
            matrix[i][j] = 0;
            matrix[i][cur--] = value;
          }
        }
      }
    } else if (directCount == 3) {
      // bottom
      for (int i = N - 1; i >= 0; i--) {
        int value = 0;
        int cur = N - 1;

        for (int j = N - 1; j >= 0; j--) {
          if (matrix[j][i] == 0)
            continue;

          if (value == matrix[j][i]) {
            matrix[cur + 1][i] = value * 2;
            value = 0;
            matrix[j][i] = 0;
          } else {
            value = matrix[j][i];
            matrix[j][i] = 0;
            matrix[cur--][i] = value;
          }
        }
      }
    }
  }

  static void print(int[][] matrix) {
    System.out.println("===========");
    for (int i = 0; i < N; i++) {
      for (int j = 0; j < N; j++) {
        System.out.print(matrix[i][j] + " ");
      }
      System.out.println("");
    }
  }

  static boolean isIn(int i, int j) {
    return i >= 0 && i < N && j >= 0 && j < N;
  }

  static int[][] createCopyMatrix(int[][] matrix) {
    int[][] copyMatrix = new int[N][N];

    for (int i = 0; i < N; i++)
      copyMatrix[i] = matrix[i].clone();
    return copyMatrix;
  }

  static void setMaxCount(int[][] matrix) {
    for (int i = 0; i < N; i++) {
      for (int j = 0; j < N; j++)
        max = Math.max(max, matrix[i][j]);
    }
  }
}