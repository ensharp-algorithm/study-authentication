import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  static int N, L;
  static int[][] matrix;

  public static void main(String[] args) throws Exception {
    int count = 0;
    int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

    N = input[0];
    L = input[1];
    matrix = new int[N][N];

    for (int i = 0; i < N; i++) {
      matrix[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
    }

    for (int i = 0; i < N; i++) {
      if (isPossibleRow(i)) {
        count++;
        // System.out.println("y = " + i);
      }

      if (isPossibleColumn(i)) {
        count++;
      }
    }

    System.out.println(count);
  }

  static boolean isPossibleRow(int i) {
    boolean[] isUsed = new boolean[N];

    for (int j = 0; j < N - 1; j++) {
      // 높이의 차이가 1 이상일 때
      if (Math.abs(matrix[i][j + 1] - matrix[i][j]) > 1)
        return false;

      // 오르막길
      if (matrix[i][j] < matrix[i][j + 1]) {

        if (j - L + 1 < 0)
          return false;

        for (int l = 0; l < L; l++) {
          if (matrix[i][j - l] != matrix[i][j] || isUsed[j - l])
            return false;
        }

        for (int l = 0; l < L; l++) {
          isUsed[j - l] = true;
        }
      }
      // 내리막길
      else if (matrix[i][j] > matrix[i][j + 1]) {

        if (j + L >= N)
          return false;

        for (int l = 0; l < L; l++) {

          if (matrix[i][j + 1 + l] != matrix[i][j + 1])
            return false;
        }

        for (int l = 0; l < L; l++) {
          isUsed[j + 1 + l] = true;
        }

        j += L - 1;
      }
    }
    return true;
  }

  static boolean isPossibleColumn(int j) {
    boolean[] isUsed = new boolean[N];

    for (int i = 0; i < N - 1; i++) {
      if (Math.abs(matrix[i][j] - matrix[i + 1][j]) > 1)
        return false;

      if (matrix[i][j] < matrix[i + 1][j]) {
        if (i - L + 1 < 0)
          return false;

        for (int l = 0; l < L; l++) {
          if (matrix[i - l][j] != matrix[i][j] || isUsed[i - l])
            return false;
        }

        for (int l = 0; l < L; l++) {
          isUsed[i - l] = true;
        }
      } else if (matrix[i][j] > matrix[i + 1][j]) {
        if (i + L >= N)
          return false;

        for (int l = 0; l < L; l++) {

          if (matrix[i + 1 + l][j] != matrix[i + 1][j])
            return false;
        }

        for (int l = 0; l < L; l++) {
          isUsed[i + 1 + l] = true;
        }

        i += L - 1;
      }
    }

    return true;
  }
}
