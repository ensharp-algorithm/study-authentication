

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  static int N, M;
  static int[] parent, rank;

  public static void main(String[] args) throws Exception {
    int T = Integer.parseInt(br.readLine());
    StringBuilder sb = new StringBuilder();
    for (int t = 1; t <= T; t++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      N = Integer.parseInt(st.nextToken());
      M = Integer.parseInt(st.nextToken());
      parent = new int[N + 1];
      rank = new int[N + 1];

      for (int i = 1; i <= N; i++) {
        parent[i] = i;
        rank[i] = 1;
      }

      for (int i = 0; i < M; i++) {
        st = new StringTokenizer(br.readLine());
        int to = Integer.parseInt(st.nextToken());
        int from = Integer.parseInt(st.nextToken());
        union(to, from);
      }

      int answer = 0;
      for (int i = 1; i <= N; i++) {
        // System.out.println(i + ", " + parent[i] + " " + rank[i]);
        if (i == find(i))
          answer++;
      }

      sb.append("#")
          .append(t)
          .append(" ")
          .append(answer)
          .append("\n");
    }
    System.out.println(sb);
  }

  static int find(int a) {
    if (parent[a] == a)
      return a;

    return parent[a] = find(parent[a]);
  }

  static void union(int a, int b) {
    int rootA = find(a);
    int rootB = find(b);

    if (rootA == rootB)
      return;

    if (rank[rootA] < rank[rootB]) {
      parent[rootA] = rootB;
    } else if (rank[rootA] > rank[rootB]) {
      parent[rootB] = rootA;
    } else {
      parent[rootB] = rootA;
      rank[rootA]++;
    }
  }
}
