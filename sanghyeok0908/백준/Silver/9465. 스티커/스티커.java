import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N;
    static int T;
    static int[][] matrix;
    static int[][] dp;

    public static void main(String[] args) throws Exception {
        T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            N = Integer.parseInt(br.readLine());
            matrix = new int[2][N];
            dp = new int[2][N];

            for (int j = 0; j < 2; j++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int i = 0; i < N; i++) {
                    matrix[j][i] = Integer.parseInt(st.nextToken());
                }
            }

            dp[0][0] = matrix[0][0];
            dp[1][0] = matrix[1][0];

            if (N > 1) {
                dp[0][1] = matrix[1][0] + matrix[0][1];
                dp[1][1] = matrix[0][0] + matrix[1][1];

                for (int i = 2; i < N; i++) {
                    dp[0][i] = Math.max(dp[1][i - 1], dp[1][i - 2]) + matrix[0][i];
                    dp[1][i] = Math.max(dp[0][i - 1], dp[0][i - 2]) + matrix[1][i];
                }
            }

            System.out.println(Math.max(dp[0][N - 1], dp[1][N - 1]));
        }
    }
}
