import java.io.*;
import java.util.*;

class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] inputs = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int N = inputs[0];
        int M = inputs[1];
        int right = 0, left = 0, sum = 0;
        int min = Integer.MAX_VALUE;

        while(true) {
            if (sum >= M) {
                sum -= arr[left++];
            } else if (right == N) break;
            else {
                sum += arr[right++];
            }

//            System.out.println(String.format("sum = %d right = %d left = %d min = %d", sum, right, left, min));
            if (sum >= M && min > right - left)
                min = right - left;
        }

        if (min == Integer.MAX_VALUE)
            System.out.println("0");
        else
            System.out.println(min);
        br.close();
    }
}