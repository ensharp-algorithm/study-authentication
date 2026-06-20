
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N, K;
    static int[][] items;
    static int[][] dp;

    public static void main(String[] args) throws Exception {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        items = new int[N][2];
        dp = new int[N][100010];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            items[i][0] = Integer.parseInt(st.nextToken());
            items[i][1] = Integer.parseInt(st.nextToken());
        }

        int answer = dfs(0, 0);
        System.out.println(answer);
    }

    static int dfs(int depth, int W) {
        if (depth >= N || W > K) {
            return 0;
        }

        if (dp[depth][W] != 0) {
            return dp[depth][W];
        }

        int res = dfs(depth + 1, W);

        if (W + items[depth][0] <= K) {
            res = Math.max(res, items[depth][1] + dfs(depth + 1, W + items[depth][0]));
        }
        return dp[depth][W] = res;
    }
}
