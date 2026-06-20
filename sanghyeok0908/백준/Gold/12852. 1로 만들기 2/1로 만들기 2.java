import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

  static class Dp {
    public int cnt;
    public List<Integer> list;

    public Dp(int cnt) {
      this.cnt = cnt;
      this.list = new ArrayList<>();
    }

    public Dp(int cnt, List<Integer> list) {
      this.cnt = cnt;
      this.list = new ArrayList<>(list);
    }
  }

  public static void main(String[] args) throws Exception {
    int N = Integer.parseInt(br.readLine());
    Dp[] dp = new Dp[N + 1];

    dp[1] = new Dp(0);
    dp[1].list.add(1);
    if (N > 1) {
      dp[2] = new Dp(1);
      dp[2].list.add(1);
      dp[2].list.add(2);
    }
    if (N > 2) {
      dp[3] = new Dp(1);
      dp[3].list.add(1);
      dp[3].list.add(3);
    }

    for (int i = 4; i <= N; i++) {
      dp[i] = new Dp(dp[i - 1].cnt + 1, dp[i - 1].list);
      if (i % 2 == 0 && dp[i].cnt > dp[i / 2].cnt + 1) {
        dp[i] = new Dp(dp[i / 2].cnt + 1, dp[i / 2].list);
      }
      if (i % 3 == 0 && dp[i].cnt > dp[i / 3].cnt + 1) {
        dp[i] = new Dp(dp[i / 3].cnt + 1, dp[i / 3].list);
      }
      dp[i].list.add(i);
    }

    // for (int i = 1; i <= N; i++) {
    // System.out.println("i = " + i + " cnt = " + dp[i].cnt);
    // for (Integer j : dp[i].list) {
    // System.out.print(j + " ");
    // }
    // System.out.println();
    // }
    System.out.println(dp[N].cnt);
    for (int i = dp[N].list.size() - 1; i >= 0; i--) {
      System.out.print(dp[N].list.get(i) + " ");
    }
    System.out.println();
  }
}