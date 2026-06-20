import java.io.*;
import java.util.*;

class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] inputs = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int N = inputs[0];
        int M = inputs[1];
        int count = 0;

//        Arrays.sort(arr);

//        for(int i = 0; i < N; i++){
//            System.out.print(arr[i] + " ");
//        }
//        System.out.println();

        int left = 0, right = 0, sum = 0;

        while (true) {
            if (sum > M) {
                sum -= arr[left++];
            } else if (right == N) break;
            else {
                sum += arr[right++];
            }

            if (sum == M) {
//                System.out.println(String.format("right = %d left = %d", right, left));
                count++;
            }
        }

        System.out.println(count);
        br.close();
    }
}