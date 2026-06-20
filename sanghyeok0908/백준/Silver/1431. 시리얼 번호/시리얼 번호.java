import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  static int N;
  static String[] arr;

  public static void main(String[] args) throws Exception {
    N = Integer.parseInt(br.readLine());
    arr = new String[N];

    for (int i = 0; i < N; i++) {
      arr[i] = br.readLine();
    }

    Arrays.sort(arr, (a, b) -> {
      if (a.length() < b.length()) {
        return -1;
      } else if (a.length() > b.length()) {
        return 1;
      }

      char[] aaa = a.toCharArray();
      char[] bbb = b.toCharArray();
      int aa = 0;
      int bb = 0;

      for (char c : aaa) {
        if (Character.isDigit(c))
          aa += Character.getNumericValue(c);
      }

      for (char c : bbb) {
        if (Character.isDigit(c))
          bb += Character.getNumericValue(c);
      }

      if (aa < bb) {
        return -1;
      } else if (aa > bb) {
        return 1;
      }

      for (int i = 0; i < a.length(); i++) {
        if (aaa[i] < bbb[i]) {
          return -1;
        } else if (aaa[i] > bbb[i]) {
          return 1;
        }
      }

      return 0;
    });

    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < N - 1; i++) {
      sb.append(arr[i]).append("\n");
    }
    sb.append(arr[N - 1]);

    System.out.println(sb.toString());
  }
}
