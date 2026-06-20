import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

  public static void main(String[] args) throws Exception {
    int N = Integer.parseInt(br.readLine());
    long[] dp = new long[N + 1];

    dp[1] = 1;
    if (N > 1)
      dp[2] = 2;
    // if (N > 2)
    // dp[3] = 3;
    // dp[4] = 5;

    for (int i = 3; i <= N; i++) {
      dp[i] = (dp[i - 1] + dp[i - 2]) % 10007;
    }

    // for (int i = 1; i <= N; i++) {
    //   System.out.print(dp[i] + " ");
    // }
    System.out.println(dp[N]);
  }
}