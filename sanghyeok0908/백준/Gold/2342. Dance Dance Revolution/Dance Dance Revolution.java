import java.io.*;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int[] arr;
    static int[][][] dp;

    public static void main(String[] args) throws IOException {
        arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        dp = new int[arr.length][5][5];

        bw.write(recursion(0, 0, 0) + "\n");
        br.close();
        bw.close();
    }

    static int recursion(int left, int right, int index) {
        if (arr[index] == 0) return 0;

        if (dp[index][left][right] != 0) return dp[index][left][right];

        int leftForce = getForce(left, arr[index]);
        int rightForce = getForce(right, arr[index]);

        dp[index][left][right] = Math.min(recursion(arr[index], right, index + 1) + leftForce,
                recursion(left, arr[index], index + 1) + rightForce);
        return dp[index][left][right];
    }

    static int getForce(int start, int target) {
        int abs = Math.abs(target - start);

        if (start == target) return 1;
        if (start == 0) return 2;
        if (abs == 1 || abs == 3) return 3;
        return 4;
    }
}