import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

  public static void main(String[] args) throws Exception {
    int T = Integer.parseInt(br.readLine());

    while (T-- > 0) {
      int N = Integer.parseInt(br.readLine());
      int[] arr = Arrays.stream(br.readLine().split(" "))
          .mapToInt(Integer::parseInt)
          .toArray();
      long answer = 0;
      int maxIdx = N - 1;

      for (int i = N - 2; i >= 0; i--) {
        if (arr[maxIdx] > arr[i]) {
          answer += arr[maxIdx] - arr[i];
        } else {
          maxIdx = i;
        }
      }
      System.out.println(answer);
    }
  }
}