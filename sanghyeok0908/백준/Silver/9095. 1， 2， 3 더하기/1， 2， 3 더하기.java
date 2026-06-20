import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  static int T;

  public static void main(String[] args) throws Exception {
    T = Integer.parseInt(br.readLine());

    while (T-- > 0) {
      int n = Integer.parseInt(br.readLine());
      int[] dp = new int[n + 1];

      if (n > 0)
        dp[1] = 1;
      if (n > 1)
        dp[2] = 2;
      if (n > 2)
        dp[3] = 4;

      for (int i = 4; i <= n; i++) {
        dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3];
      }

      // for (int i = 1; i <= n; i++) {
      // System.out.print(dp[i] + " ");
      // }
      // System.out.println();

      System.out.println(dp[n]);
    }
  }
}

/*
 * dp[1] = 1
 * 1
 * 
 * dp[2] = 2
 * 1 + 1
 * 2
 * 
 * dp[3] = 4
 * 1 + 1 + 1
 * 2 + 1
 * 1 + 2
 * 3
 * 
 * dp[4] = 7
 * 1 + 1 + 1 + 1
 * 1 + 1 + 2
 * 1 + 2 + 1
 * 2 + 1 + 1
 * 2 + 2
 * 1 + 3
 * 3 + 1
 */