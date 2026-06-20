import java.io.*;
import java.util.*;

public class Main {

  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  static int N;
  static int[] T, P;
  static int[] dp;

  public static void main(String[] args) throws Exception {
    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    T = new int[N];
    P = new int[N];
    dp = new int[N];

    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine());
      T[i] = Integer.parseInt(st.nextToken());
      P[i] = Integer.parseInt(st.nextToken());
    }

    for (int i = 0; i < N; i++) {

      if (i + T[i] > N) {
        continue;
      }

      int prev = 0;

      for (int j = i - 1; j >= 0; j--) {
        if (j + T[j] - 1 < i) {
          prev = Math.max(prev, dp[j]);
        }
      }
      dp[i] = P[i] + prev;
    }

    int answer = 0;
    for (int i = 0; i < N; i++) {
      // System.out.print(dp[i] + " ");
      answer = Math.max(answer, dp[i]);
    }
    // System.out.println();

    System.out.println(answer);
  }
}