

import java.lang.*;
import java.io.*;
import java.util.*;


public class Main {

    static int n;
    static int s;
    static int result = 0;
    static int[] arr;

    public static void main(String[] argc) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        s = Integer.parseInt(st.nextToken());

        arr = new int[n];
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        dfs(0, 0, 0);
        System.out.println(result);

    }

    public static void dfs(int idx, int sum, int cnt) {

        if (idx == n) {
            if (cnt > 0 && sum == s) {
                result++;
            }
            return;
        }


        //System.out.printf("idx = %d, arr[idx] = %d, sum = %d,  cnt = %d, result = %d \n", idx, arr[idx],sum, cnt,result);

        dfs(idx + 1, sum + arr[idx], cnt + 1);
        dfs(idx + 1, sum, cnt);



    }
}