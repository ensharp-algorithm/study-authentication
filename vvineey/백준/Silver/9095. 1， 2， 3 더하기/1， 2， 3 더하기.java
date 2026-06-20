//  1, 2, 3 더하기

import java.util.*;
import java.lang.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        int[] arr = new int[T];
        int maxN = 0;


        for (int i = 0; i < T; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            if (arr[i] > maxN) {
                maxN = arr[i];
            }
        }


        int[] dp = new int[Math.max(4, maxN + 1)];
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;


        for (int j = 4; j <= maxN; j++) {
            dp[j] = dp[j - 1] + dp[j - 2] + dp[j - 3];
        }


        for (int i = 0; i < T; i++) {
            System.out.println( dp[arr[i]]);
        }


    }
}