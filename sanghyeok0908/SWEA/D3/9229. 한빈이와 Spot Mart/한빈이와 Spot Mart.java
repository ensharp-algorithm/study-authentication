import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws Exception {
        int TC = Integer.parseInt(br.readLine());
        StringBuilder answer = new StringBuilder();

        for (int t = 1; t <= TC; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            int[] arr = new int[N];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            Arrays.sort(arr);
            answer.append("#" + t + " " + calculate(arr, N, M) + "\n");
        }
        System.out.println(answer);
    }

    static int calculate(int[] arr, int N, int M) {
        int left = 0, right = N - 1;
        int result = -1;

        while (left < right) {
            int temp = arr[left] + arr[right];

            if (temp <= M) {
                result = Math.max(result, temp);
                left++;
            } else {
                right--;
            }
        }
        return result;
    }
}