import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

  public static void main(String[] args) throws Exception {
    int N = Integer.parseInt(br.readLine());
    int[] stairs = new int[N + 1];
    int[] dp = new int[N + 1];

    for (int i = 1; i <= N; i++) {
      stairs[i] = Integer.parseInt(br.readLine());
    }

    dp[1] = stairs[1];
    // dp2[1] = stairs[0];
    if (N > 1) {
      dp[2] = stairs[1] + stairs[2];
    }
    if (N > 2) {
      dp[3] = Math.max(stairs[1] + stairs[3], stairs[2] + stairs[3]);
    }

    for (int i = 4; i <= N; i++) {
      dp[i] = Math.max(dp[i - 3] + stairs[i - 1] + stairs[i], dp[i - 2] + stairs[i]);
    }

    // for (int i = 0; i <= N; i++) {
    // System.out.print(dp[i] + " ");
    // }
    // System.out.println("");
    System.out.println(dp[N]);
  }
}

/*
 * dp[1] =
 * 1
 * dp[2] =
 * 1, 2
 * dp[3] =
 * 1, 3
 * dp[4] =
 * 1, 3, 4 -> dp[i - 1] + x
 * 1, 2, 4 -> dp[i - 2] + x
 * dp[5] =
 * 1, 2, 4, 5 -> dp[i - 1] + x
 * 1, 3, 5 -> dp[i - 2] + x
 * dp[6] =
 * 1, 2, 4, 6 -> dp[i - 2] + x
 * 1, 3, 4, 6 -> dp[i - 2] + x
 * 1, 3, 5, 6 -> dp[i - 1] + x
 */