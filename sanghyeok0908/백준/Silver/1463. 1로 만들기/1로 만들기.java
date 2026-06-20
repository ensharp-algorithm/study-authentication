import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  static int N;
  static int[] dp;

  public static void main(String[] args) throws Exception {
    N = Integer.parseInt(br.readLine());
    dp = new int[N + 1];

    dp[1] = 0;

    if (N > 1)
      dp[2] = 1;
    if (N > 2)
      dp[3] = 1;

    for (int i = 4; i <= N; i++) {
      dp[i] = dp[i - 1] + 1;

      if (i % 2 == 0) {
        dp[i] = Math.min(dp[i / 2] + 1, dp[i]);
      }

      if (i % 3 == 0) {
        dp[i] = Math.min(dp[i / 3] + 1, dp[i]);
      }
    }

    // for (int i = 1; i < N + 1; i++) {
    //   System.out.print(dp[i] + " ");
    // }
    System.out.println(dp[N]);
  }
}
