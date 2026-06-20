import java.io.*;
import java.util.*;

public class Solution {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N, M;
    static List<Integer>[] in, out;
    static boolean[] visited;

    public static void main(String[] args) throws Exception {
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int t = 1; t <= T; t++) {
            N = Integer.parseInt(br.readLine());
            M = Integer.parseInt(br.readLine());
            in = new ArrayList[N + 1];
            out = new ArrayList[N + 1];

            for (int i = 1; i <= N; i++) {
                in[i] = new ArrayList<>();
                out[i] = new ArrayList<>();
            }

            for (int i = 0; i < M; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int small = Integer.parseInt(st.nextToken());
                int big = Integer.parseInt(st.nextToken());

                in[big].add(small);
                out[small].add(big);
            }

            int answer = 0;
            for (int i = 1; i <= N; i++) {
                visited = new boolean[N + 1];
                int inCnt = dfs(false, i) - 1;

                visited = new boolean[N + 1];
                int outCnt = dfs(true, i) - 1;
                // System.out.printf("node = %d, inCnt = %d, outCnt = %d\n", i, inCnt, outCnt);

                if (inCnt + outCnt + 1 == N) {
                    answer++;
                }
            }
            sb.append("#" + t + " " + answer + "\n");
        }
        System.out.println(sb);
    }

    static int dfs(boolean isOut, int node) {
        if (visited[node]) {
            return 0;
        }

        int result = 1;
        visited[node] = true;

        if (isOut) {
            for (Integer near : out[node]) {
                result += dfs(isOut, near);
            }
        } else {
            for (Integer near : in[node]) {
                result += dfs(isOut, near);
            }
        }

        return result;
    }
}