import java.io.*;
import java.util.*;

public class Main {

  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  static int N;
  static int[] T, P;
  static int[] dp;

  public static void main(String[] args) throws Exception {
    int max = 0;
    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    T = new int[N];
    P = new int[N];
    dp = new int[N + 51];

    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine());
      T[i] = Integer.parseInt(st.nextToken());
      P[i] = Integer.parseInt(st.nextToken());
    }

    for (int i = 0; i < N; i++) {
      max = Math.max(max, dp[i]);

      if (i + T[i] <= N) {
        dp[i + T[i]] = Math.max(dp[i + T[i]], max + P[i]);
      }
    }

    int answer = 0;
    for (int i = 0; i < N + 51; i++) {
      // System.out.print(dp[i] + " ");
      answer = Math.max(answer, dp[i]);
    }
    // System.out.println();
    System.out.println(answer);
  }
}