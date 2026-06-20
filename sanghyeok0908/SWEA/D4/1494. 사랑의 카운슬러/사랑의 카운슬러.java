import java.io.*;
import java.util.*;

public class Solution {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N;
    static int[][] worms;
    static boolean[] visited;
    static long answer;

    public static void main(String[] args) throws Exception {
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int t = 1; t <= T; t++) {
            N = Integer.parseInt(br.readLine());
            worms = new int[N][2];
            visited = new boolean[N];
            answer = Long.MAX_VALUE;

            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                worms[i][0] = Integer.parseInt(st.nextToken());
                worms[i][1] = Integer.parseInt(st.nextToken());
            }

            dfs(0, 0);
            sb.append("#" + t + " " + answer + "\n");
        }
        System.out.println(sb);
    }

    static void dfs(int depth, int start) {
        if (depth >= N / 2) {
            // System.out.println("==============");
            long y = 0, x = 0;

            for (int i = 0; i < N; i++) {
                if (visited[i]) {
                    // System.out.print(i + " ");
                    y += worms[i][0];
                    x += worms[i][1];
                } else {
                    y -= worms[i][0];
                    x -= worms[i][1];
                }
            }
            // System.out.println();

            long result = y * y + x * x;
            answer = Math.min(answer, result);
            return;
        }

        for (int i = start; i < N; i++) {
            if (!visited[i]) {
                visited[i] = true;
                dfs(depth + 1, i + 1);
                visited[i] = false;
            }
        }
    }
}
