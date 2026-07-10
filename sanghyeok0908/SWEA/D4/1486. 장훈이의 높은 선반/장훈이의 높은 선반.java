import java.io.*;
import java.util.*;

public class Solution {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int result = 0;
    static int N, B, S;
    static int[] arr;

    public static void main(String[] args) throws Exception {
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();    

        for (int t = 1; t <= T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            B = Integer.parseInt(st.nextToken());
            S = 0;
            result = Integer.MAX_VALUE;
            arr = new int[N];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
                S += arr[i];
            }

            dfs(0, 0);
            sb.append("#")
            .append(t)
            .append(" ")
            .append(result - B)
            .append("\n");
            // System.out.println(S + " " + result);
        }
        System.out.println(sb);
    }

    static void dfs(int depth, int sum) {
        // System.out.printf("depth = %d, sum = %d\n", depth - 1, sum);

        if (sum >= B) {
            result = Math.min(result, sum);
        }

        if (depth == N) {
            return;
        }

        dfs(depth + 1, sum + arr[depth]);
        dfs(depth + 1, sum);
    }
}
