import java.io.*;
import java.util.*;

public class Main {

  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  static int N;
  static long[][] dp;

  public static void main(String[] args) throws Exception {
    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    dp = new long[N + 1][2];

    dp[1][1] = 1;
    for (int i = 2; i <= N; i++) {
      dp[i][0] = dp[i - 1][1] + dp[i - 1][0];
      dp[i][1] = dp[i - 1][0];
    }

    System.out.println(dp[N][0] + dp[N][1]);
  }
}