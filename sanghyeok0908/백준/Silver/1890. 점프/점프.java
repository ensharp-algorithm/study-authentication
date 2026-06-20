import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N;
    static int[][] matrix;
    static long[][] dp;

    public static void main(String[] args) throws Exception {
        N = Integer.parseInt(br.readLine());
        matrix = new int[N][N];
        dp = new long[N][N];
        dp[N - 1][N - 1] = 1;

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                matrix[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = N - 1; i >= 0; i--) {
            for (int j = N - 1; j >= 0; j--) {
                dfs(i, j);
            }
        }

        // System.out.println(Math.pow(2, 63) - 1);
        System.out.println(dp[0][0]);
        // for (int i = 0; i < N; i++) {
        //     for (int j = 0; j < N; j++) {
        //         System.out.print(dp[i][j] + " ");
        //     }
        //     System.out.println();
        // }
    }

    static void dfs(int y, int x) {
        if (!isIn(y, x) || matrix[y][x] == 0)
            return;

        int value = matrix[y][x];
        if (isIn(y + value, x)) {
            if (dp[y + value][x] == 0) {
                dfs(y + value, x);
            }
            dp[y][x] += dp[y + value][x];
        }

        if (isIn(y, x + value)) {
            if (dp[y][x + value] == 0) {
                dfs(y, x + value);
            }
            dp[y][x] += dp[y][x + value];
        }
    }

    static boolean isIn(int y, int x) {
        return y >= 0 && y < N && x >= 0 && x < N;
    }
}
