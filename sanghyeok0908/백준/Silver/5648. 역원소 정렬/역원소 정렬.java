import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  static int N;
  static long[] arr;
  static int idx = 0;
  static long[] reversedArr;

  public static void main(String[] args) throws Exception {
    long[] input = Arrays.stream(br.readLine().split(" "))
        .filter(s -> !s.isEmpty())
        .mapToLong(Long::parseLong)
        .toArray();
    N = (int) input[0];
    arr = new long[N];
    reversedArr = new long[N];

    for (int i = 1; i < input.length; i++) {
      arr[idx++] = input[i];
    }

    while (idx < N) {
      input = Arrays.stream(br.readLine().split(" "))
          .filter(s -> !s.isEmpty())
          .mapToLong(Long::parseLong)
          .toArray();
      for (int j = 0; j < input.length; j++) {
        arr[idx++] = input[j];
      }
    }

    // for (int i = 0; i < idx; i++) {
    // System.out.println(arr[i]);
    // }

    idx = 0;
    for (int i = 0; i < N; i++) {
      long temp = arr[i];
      long result = 0;
      int j = 10;

      while (temp > 0) {
        result *= j;
        result += temp % 10;
        temp /= 10;
      }

      reversedArr[idx++] = result;
    }

    Arrays.sort(reversedArr);
    for (int i = 0; i < N; i++) {
      System.out.println(reversedArr[i]);
    }
  }
}
