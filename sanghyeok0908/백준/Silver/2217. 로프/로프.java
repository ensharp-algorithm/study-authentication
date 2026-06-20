import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  static int N;
  static int[] arr;

  public static void main(String[] args) throws Exception {
    N = Integer.parseInt(br.readLine());
    arr = new int[N];

    for (int i = 0; i < N; i++) {
      arr[i] = Integer.parseInt(br.readLine());
    }

    Arrays.sort(arr);

    int max = arr[N - 1];
    for (int i = 0; i < N; i++) {
      max = Math.max(max, arr[i] * (N - i));
    }
    System.out.println(max);
  }
}