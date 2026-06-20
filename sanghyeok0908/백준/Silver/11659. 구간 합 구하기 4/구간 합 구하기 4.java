import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  static int N, M;
  static int[] nums;
  static int[] dp;

  public static void main(String[] args) throws Exception {
    int[] input = Arrays.stream(br.readLine().split(" "))
        .mapToInt(Integer::parseInt)
        .toArray();
    N = input[0];
    M = input[1];
    dp = new int[N];
    nums = Arrays.stream(br.readLine().split(" "))
        .mapToInt(Integer::parseInt)
        .toArray();

    dp[0] = nums[0];
    for (int i = 1; i < N; i++) {
      dp[i] = dp[i - 1] + nums[i];
    }

    // for (int i = 0; i < N; i++)
    //   System.out.println(dp[i]);

    for (int i = 0; i < M; i++) {
      input = Arrays.stream(br.readLine().split(" "))
          .mapToInt(Integer::parseInt)
          .toArray();
      // System.out.println(String.format("dp[input[1]] = %d, dp[input[0]] = %d, nums[input[0]] = %d",
      //     dp[input[1]], dp[input[0]], nums[input[0]]));
      System.out.println(dp[input[1] - 1] - dp[input[0] - 1] + nums[input[0] - 1]);
    }

  }
}