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

    StringBuilder sb = new StringBuilder();
    Arrays.sort(arr);

    for (int i = N - 1; i > 0; i--) {
      sb.append(arr[i]).append("\n");
    }
    sb.append(arr[0]);

    System.out.println(sb.toString());
  }
}
