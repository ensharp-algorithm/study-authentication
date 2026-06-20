import java.io.*;
import java.util.*;

public class Main {

  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  static int N;
  static int[] arr;
  static int[] dp;

  public static void main(String[] args) throws Exception {
    int answer = 1;
    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    arr = new int[N];
    dp = new int[N];
    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < N; i++) {
      arr[i] = Integer.parseInt(st.nextToken());
    }

    dp[0] = arr[0];
    for (int i = 1; i < N; i++) {
      dp[i] = arr[i];

      for (int j = i - 1; j >= 0; j--) {
        if (arr[j] >= arr[i]) {
          continue;
        }
        dp[i] = Math.max(dp[i], dp[j] + arr[i]);
      }
    }

    for (int i = 0; i < N; i++) {
      // System.out.print(dp[i] + " ");
      answer = Math.max(answer, dp[i]);
    }
    // System.out.println();

    System.out.println(answer);
  }
}