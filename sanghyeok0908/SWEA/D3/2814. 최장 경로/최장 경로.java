import java.io.*;
import java.util.*;

public class Solution {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static List<Integer>[] edges;
    static boolean[] visited;
    static int maxPath;

    public static void main(String[] args) throws Exception {
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int t = 1; t <= T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            edges = new ArrayList[N + 1];
            maxPath = 0;

            for (int i = 1; i <= N; i++) {
                edges[i] = new ArrayList<>();
            }

            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());
                int from = Integer.parseInt(st.nextToken());
                int to = Integer.parseInt(st.nextToken());

                edges[from].add(to);
                edges[to].add(from);
            }

            for (int i = 1; i <= N; i++) {
                visited = new boolean[N + 1];
                dfs(i, 1);
            }
            sb.append("#" + t + " " + maxPath + "\n");
        }
        System.out.println(sb);
    }

    static void dfs(int node, int depth) {
        visited[node] = true;
        maxPath = Math.max(maxPath, depth);

        for (int near : edges[node]) {
            if (!visited[near]) {
                dfs(near, depth + 1);
            }
        }

        visited[node] = false;
    }
}
