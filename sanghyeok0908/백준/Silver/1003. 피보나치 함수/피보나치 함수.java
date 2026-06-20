import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

  public static void main(String[] args) throws Exception {
    int T = Integer.parseInt(br.readLine());

    while (T-- > 0) {
      int N = Integer.parseInt(br.readLine());
      int[][] dp = new int[N + 1][2];

      dp[0][0] = 1;
      dp[0][1] = 0;
      if (N > 0) {
        dp[1][0] = 0;
        dp[1][1] = 1;
      }

      // dp[2][0] = 1;
      // dp[2][1] = 1;

      // dp[3][0] = 1;
      // dp[3][1] = 2;

      for (int i = 2; i <= N; i++) {
        dp[i][0] = dp[i - 1][0] + dp[i - 2][0];
        dp[i][1] = dp[i - 1][1] + dp[i - 2][1];
      }

      // for (int i = 0; i <= N; i++) {
      //   System.out.println(dp[i][0] + " " + dp[i][1]);
      // }
      System.out.println(dp[N][0] + " " + dp[N][1]);
    }

  }
}