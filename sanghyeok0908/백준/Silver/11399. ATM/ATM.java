import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  static int N;
  static int[] arr;
  static int[] dp;

  public static void main(String[] args) throws Exception {
    int answer = 0;

    N = Integer.parseInt(br.readLine());
    arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
    dp = new int[N];
    Arrays.sort(arr);

    dp[0] = arr[0];
    for (int i = 1; i < N; i++) {
      dp[i] = dp[i - 1] + arr[i];
    }

    // for (int i = 0; i < N; i++) {
    // System.out.print(arr[i] + " ");
    // }
    // System.out.println();
    // for (int i = 0; i < N; i++) {
    // System.out.print(dp[i] + " ");
    // }
    // System.out.println();

    for (int i = 0; i < N; i++) {
      answer += dp[i];
    }
    System.out.println(answer);
  }
}