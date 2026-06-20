import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  static int N, K;
  static int[] arr;

  public static void main(String[] args) throws Exception {
    int count = 0;
    int[] input = Arrays.stream(br.readLine().split(" "))
        .mapToInt(Integer::parseInt)
        .toArray();
    N = input[0];
    K = input[1];
    arr = new int[N];
    for (int i = 0; i < N; i++) {
      arr[i] = Integer.parseInt(br.readLine());
    }

    for (int i = N - 1; i >= 0; i--) {
      if (K == 0) {
        break;
      }
      if (arr[i] > K) {
        continue;
      }

      int x = K / arr[i];
      K -= arr[i] * x;
      count += x;
      // System.out.println(String.format("K = %d, arr[i] = %d, x = %d", K, arr[i], x));
    }

    System.out.println(count);
  }
}