
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  static int N, M;
  static int[] parent, rank;

  public static void main(String[] args) throws Exception {
    StringTokenizer st = new StringTokenizer(br.readLine());
    int answer = 0;

    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());
    parent = new int[N];
    rank = new int[N];
    for (int i = 0; i < N; i++) {
      parent[i] = i;
      rank[i] = 1;
    }

    for (int i = 0; i < M; i++) {
      st = new StringTokenizer(br.readLine());
      int from = Integer.parseInt(st.nextToken());
      int to = Integer.parseInt(st.nextToken());
      int rootFrom = find(from);
      int rootTo = find(to);

      if (rootFrom != rootTo) {
        union(rootFrom, rootTo);
      } else if (answer == 0) {
        answer = i + 1;
      }
    }

    System.out.println(answer);
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
