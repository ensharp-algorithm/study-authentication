import java.io.*;
import java.util.*;

public class Solution {
  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  static int N;
  static double E;
  static int[] xs, ys;

  public static void main(String[] args) throws Exception {
    int T = Integer.parseInt(br.readLine());
    StringBuilder sb = new StringBuilder();
    for (int t = 1; t <= T; t++) {
      N = Integer.parseInt(br.readLine());
      xs = new int[N];
      ys = new int[N];
      StringTokenizer st = new StringTokenizer(br.readLine());
      for (int i = 0; i < N; i++) {
        xs[i] = Integer.parseInt(st.nextToken());
      }
      st = new StringTokenizer(br.readLine());
      for (int i = 0; i < N; i++) {
        ys[i] = Integer.parseInt(st.nextToken());
      }
      E = Double.parseDouble(br.readLine());

      long L = prim();
      sb.append("#")
          .append(t)
          .append(" ")
          .append(Math.round(E * L))
          .append("\n");
    }
    System.out.println(sb);
  }

  static long prim() {
    long result = 0;
    boolean[] visited = new boolean[N];
    double[] distances = new double[N];

    Arrays.fill(distances, Double.MAX_VALUE);
    distances[0] = 0;

    for (int i = 0; i < N; i++) {
      int u = 0;
      double min = Double.MAX_VALUE;

      for (int v = 0; v < N; v++) {
        if (!visited[v] && min > distances[v]) {
          u = v;
          min = distances[v];
        }
      }

      visited[u] = true;
      result += min;

      for (int v = 0; v < N; v++) {
        double cost1 = Math.pow(xs[u] - xs[v], 2);
        double cost2 = Math.pow(ys[u] - ys[v], 2);
        double cost = cost1 + cost2;

        if (!visited[v] && cost < distances[v]) {
          distances[v] = cost;
        }
      }
    }
    return result;
  }
}
