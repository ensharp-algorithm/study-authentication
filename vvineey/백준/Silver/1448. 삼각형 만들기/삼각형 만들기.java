

import java.lang.*;
import java.io.*;
import java.util.*;


public class Main {
    public static void main(String[] argc) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        Integer[] arr = new Integer[n];

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(arr);

        for (int i = n-3; i >=0; i--) {
            if (arr[i] + arr[i + 1] > arr[i + 2]) {
                System.out.println(arr[i] + arr[i + 1] + arr[i + 2]);
                return;
            }
        }
        System.out.println("-1");
    }
}