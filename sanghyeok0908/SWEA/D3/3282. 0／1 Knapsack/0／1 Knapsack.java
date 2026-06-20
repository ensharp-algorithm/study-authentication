
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws Exception {
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int t = 1; t <= T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());
            int[][] dp = new int[N + 1][K + 10];

            for (int i = 1; i <= N; i++) {
                st = new StringTokenizer(br.readLine());
                int V = Integer.parseInt(st.nextToken());
                int C = Integer.parseInt(st.nextToken());

                for (int k = 1; k <= K; k++) {
                    dp[i][k] = dp[i - 1][k];

                    if (k - V >= 0) {
                        dp[i][k] = Math.max(dp[i][k], C + dp[i - 1][k - V]);
                    }
                }
            }

            sb.append("#" + t + " " + dp[N][K] + "\n");
        }
        System.out.println(sb);
    }
}
