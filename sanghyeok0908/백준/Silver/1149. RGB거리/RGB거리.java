import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

  public static void main(String[] args) throws Exception {
    int answer = Integer.MAX_VALUE;
    int N = Integer.parseInt(br.readLine());
    int[][] dp = new int[N + 1][3];
    int[][] home = new int[N + 1][3];
    for (int i = 1; i <= N; i++) {
      home[i] = Arrays.stream(br.readLine().split(" "))
          .mapToInt(Integer::parseInt)
          .toArray();
    }

    for (int i = 0; i < 3; i++) {
      dp[1][i] = home[1][i];
    }

    for (int i = 2; i <= N; i++) {
      dp[i][0] = Math.min(dp[i - 1][1] + home[i][0], dp[i - 1][2] + home[i][0]);
      dp[i][1] = Math.min(dp[i - 1][0] + home[i][1], dp[i - 1][2] + home[i][1]);
      dp[i][2] = Math.min(dp[i - 1][0] + home[i][2], dp[i - 1][1] + home[i][2]);
    }

    for (int i = 0; i < 3; i++) {
      answer = Math.min(answer, dp[N][i]);
    }

    System.out.println(answer);
  }
}