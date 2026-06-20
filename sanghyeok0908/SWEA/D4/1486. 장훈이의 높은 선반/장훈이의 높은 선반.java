
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N, B;
    static int[] arr;
    static int answer;

    public static void main(String[] args) throws Exception {
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int t = 1; t <= T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            B = Integer.parseInt(st.nextToken());
            arr = new int[N];
            answer = Integer.MAX_VALUE;

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            backTracking(0, 0);
            sb.append("#" + t + " " + answer + "\n");
        }
        System.out.println(sb);
    }

    static void backTracking(int idx, int sum) {
        // System.out.println(idx + " " + sum);

        if (sum >= B) {
            answer = Math.min(answer, sum - B);
            return;
        }

        if (idx >= N)
            return;

        backTracking(idx + 1, sum + arr[idx]);
        backTracking(idx + 1, sum);
    }
}
