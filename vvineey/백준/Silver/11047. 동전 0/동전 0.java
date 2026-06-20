//  동전 0

import javax.naming.PartialResultException;
import java.util.*;
import java.lang.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] coin = new int[n];
        int cnt = 0;

        for (int i = 0; i < n; i++) {
            coin[i] = Integer.parseInt(br.readLine());
        }


        for (int i = n - 1; i >= 0; i--) {
            if (k >= coin[i]) {
                cnt += k / coin[i];
                k %= coin[i];
            }

        }


        System.out.println(cnt);
    }
}