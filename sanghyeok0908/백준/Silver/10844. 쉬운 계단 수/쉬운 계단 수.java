import java.io.*;
import java.util.*;

public class Main {

  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

  public static void main(String[] args) throws Exception {
    StringTokenizer st = new StringTokenizer(br.readLine());
    int N = Integer.parseInt(st.nextToken());
    int[][] dp = new int[N + 1][10];

    for (int i = 1; i <= 9; i++) {
      dp[1][i] = 1;
    }

    for (int i = 2; i <= N; i++) {
      dp[i][0] = dp[i - 1][1];
      dp[i][9] = dp[i - 1][8];

      for (int j = 1; j < 9; j++) {
        dp[i][j] = (dp[i - 1][j - 1] + dp[i - 1][j + 1]) % 1000000000;
      }
    }

    int sum = 0;
    for (int i = 0; i <= 9; i++) {
      sum = (sum + dp[N][i]) % 1000000000;
    }

    System.out.println(sum);
  }
}
