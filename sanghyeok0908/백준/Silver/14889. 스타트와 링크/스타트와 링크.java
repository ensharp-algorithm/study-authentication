import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  static int N;
  static int[][] matrix;
  static boolean[] isStartTeam;
  static int answer = Integer.MAX_VALUE;

  public static void main(String[] args) throws Exception {
    N = Integer.parseInt(br.readLine());
    matrix = new int[N][N];
    isStartTeam = new boolean[N];

    for (int i = 0; i < N; i++) {
      matrix[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
    }

    backTracking(0, 0);
    System.out.println(answer);
  }

  static void backTracking(int depth, int start) {
    if (depth == N / 2) {
      // for (int i = 0; i < N; i++) {
      //   if (isStartTeam[i]) {
      //     System.out.print(i + " ");
      //   }
      // }
      // System.out.println("");
      // System.out.println("========");
      // for (int i = 0; i < N; i++) {
      //   if (!isStartTeam[i]) {
      //     System.out.print(i + " ");
      //   }
      // }
      // System.out.println("");

      int value = calculate();
      answer = Math.min(answer, value);
      return;
    }

    for (int i = start; i < N; i++) {
      isStartTeam[i] = true;
      backTracking(depth + 1, i + 1);
      isStartTeam[i] = false;
    }
  }

  static int calculate() {
    int starts = 0, links = 0;

    for (int i = 0; i < N - 1; i++) {
      for (int j = i + 1; j < N; j++) {
        if (isStartTeam[i] && isStartTeam[j]) {
          starts += matrix[i][j];
          starts += matrix[j][i];
        } else if (!isStartTeam[i] && !isStartTeam[j]) {
          links += matrix[i][j];
          links += matrix[j][i];
        }
      }
    }

    return Math.abs(starts - links);
  }
}
