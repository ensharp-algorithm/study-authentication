
import java.io.*;
import java.util.*;

public class Solution {

  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  static int N;
  static int[] company = new int[2], home = new int[2];
  static int[][] customers;
  static int[] dp;
  static boolean[] visited;
  static int answer;

  public static void main(String[] args) throws Exception {
    int T = Integer.parseInt(br.readLine());
    StringBuilder sb = new StringBuilder();
    for (int t = 1; t <= T; t++) {
      N = Integer.parseInt(br.readLine());
      customers = new int[N][2];
      dp = new int[N];
      visited = new boolean[N];
      answer = Integer.MAX_VALUE;
      StringTokenizer st = new StringTokenizer(br.readLine());
      company[0] = Integer.parseInt(st.nextToken());
      company[1] = Integer.parseInt(st.nextToken());
      home[0] = Integer.parseInt(st.nextToken());
      home[1] = Integer.parseInt(st.nextToken());
      for (int i = 0; i < N; i++) {
        customers[i][0] = Integer.parseInt(st.nextToken());
        customers[i][1] = Integer.parseInt(st.nextToken());
      }

      bruthForce(0);
      sb.append("#")
          .append(t)
          .append(" ")
          .append(answer)
          .append("\n");
    }
    System.out.println(sb);
  }

  static void bruthForce(int depth) {
    if (depth == N) {
      int distance = getDistance(company[0], company[1], customers[dp[0]][0], customers[dp[0]][1]);

      for (int i = 1; i < N; i++) {
        distance += getDistance(customers[dp[i - 1]][0], customers[dp[i - 1]][1],
            customers[dp[i]][0], customers[dp[i]][1]);
      }

      distance += getDistance(customers[dp[N - 1]][0], customers[dp[N - 1]][1], home[0], home[1]);
      answer = Math.min(answer, distance);
      return;
    }

    for (int i = 0; i < N; i++) {
      if (visited[i]) {
        continue;
      }

      visited[i] = true;
      dp[depth] = i;
      bruthForce(depth + 1);
      visited[i] = false;
    }
  }

  static int getDistance(int ay, int ax, int by, int bx) {
    return Math.abs(ay - by) + Math.abs(ax - bx);
  }
}
