

import java.lang.*;
import java.io.*;
import java.util.*;


public class Main {
    public static void main(String[] argc) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] A = new int[n];
        int[] sum2 = new int[n * n];

        for (int i = 0; i < n; i++) {
            A[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(A);

        int idx = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                sum2[idx++] = A[i] + A[j];
            }
        }

        Arrays.sort(sum2);

        for (int i = 0; i < n; i++) {

            for (int j = 0; j < n; j++) {
                int target = A[n - 1 - i] - A[j];

                //System.out.println(target);
                if (binarySearch(sum2, target)) {
                    System.out.println(A[n - 1 - i]);
                    return;
                }
            }

        }
    }


    public static boolean binarySearch(int[] arr, int target) {

        int start = 0;
        int end = arr.length - 1;

        while (start <= end) {
            int mid = (start + end) / 2;

            if (arr[mid] == target) {
                return true;
            } else if (arr[mid] < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return false;
    }
}