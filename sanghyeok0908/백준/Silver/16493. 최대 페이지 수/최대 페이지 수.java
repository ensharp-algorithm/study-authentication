import java.io.*;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        String[] s = br.readLine().split(" ");
        int N = Integer.parseInt(s[0]);
        int M = Integer.parseInt(s[1]);
        int[][] dp = new int[M + 1][N + 1];

        for (int i = 1; i <= M; i++) {
            String[] s1 = br.readLine().split(" ");
            int day = Integer.parseInt(s1[0]);
            int page = Integer.parseInt(s1[1]);

            for(int j = 1; j <= N; j++) {
                dp[i][j] = dp[i - 1][j];

                if (j >= day) {
                    dp[i][j] = Math.max(dp[i][j], page + dp[i - 1][j - day]);
                }
            }
        }

        bw.write(dp[M][N] + "\n");
        br.close();
        bw.close();
    }
}