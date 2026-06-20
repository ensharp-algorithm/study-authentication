import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  static int N, M, H;
  static int[][] ladder;
  static int answer = -1;

  public static void main(String[] args) throws Exception {
    // System.out.println(Math.pow(10 * 30, 3));
    int[] input = Arrays.stream(br.readLine().split(" "))
        .mapToInt(Integer::parseInt)
        .toArray();
    N = input[0];
    M = input[1];
    H = input[2];
    ladder = new int[N][H];

    for (int i = 0; i < N; i++) {
      for (int j = 0; j < H; j++) {
        ladder[i][j] = i;
      }
    }

    for (int i = 0; i < M; i++) {
      input = Arrays.stream(br.readLine().split(" "))
          .mapToInt(Integer::parseInt)
          .toArray();

      ladder[input[1] - 1][input[0] - 1] = input[1];
      ladder[input[1]][input[0] - 1] = input[1] - 1;
    }

    // for (int i = 0; i < N; i++) {
    // for (int j = 0; j < H; j++) {
    // System.out.print(ladder[i][j] + " ");
    // }
    // System.out.println();
    // }

    for (int i = 0; i <= 3; i++) {
      answer = i;
      dfs(0, 0);
    }

    System.out.println(-1);
  }

  static void dfs(int startY, int count) {
    if (answer == count) {
      if (isAnswer()) {
        System.out.println(answer);
        System.exit(0);
      }
      return;
    }

    for (int i = startY; i < N - 1; i++) {
      int idx = i;

      for (int j = 0; j < H; j++) {
        if (ladder[idx][j] == idx && ladder[idx + 1][j] == idx + 1) {
          ladder[idx][j] = idx + 1;
          ladder[idx + 1][j] = idx;
          dfs(idx, count + 1);
          ladder[idx][j] = idx;
          ladder[idx + 1][j] = idx + 1;
        }
      }
    }
  }

  static boolean isAnswer() {
    // for (int i = 0; i < N; i++) {
    // for (int j = 0; j < H; j++) {
    // System.out.print(ladder[i][j] + " ");
    // }
    // System.out.println();
    // }
    // System.out.println("===========+");

    for (int i = 0; i < N; i++) {
      int idx = i;

      for (int j = 0; j < H; j++) {
        idx = ladder[idx][j];
      }

      if (idx != i)
        return false;
    }
    return true;
  }
}
