import java.io.*;
import java.util.*;

public class Main {

  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

  public static void main(String[] args) throws Exception {
    int N = Integer.parseInt(br.readLine());
    int[][] input = new int[N][2];
    int answer = 0;
    int[] prev = new int[2];

    for (int i = 0; i < N; i++) {
      input[i] = Arrays.stream(br.readLine().split(" "))
          .mapToInt(Integer::parseInt)
          .toArray();
    }

    Arrays.sort(input, (a, b) -> {
      if (a[0] == b[0]) {
        return a[1] - b[1];
      }
      return a[0] - b[0];
    });

    prev[0] = input[0][0];
    prev[1] = input[0][1];

    for (int i = 1; i < N; i++) {

      if (prev[0] <= input[i][0] && input[i][0] <= prev[1]) {

        if (input[i][1] > prev[1]) {
          prev[1] = input[i][1];
        }
      } else {
        answer += calculate(prev[0], prev[1]);
        prev = input[i];
      }
    }

    answer += calculate(prev[0], prev[1]);
    System.out.println(answer);
  }

  static int calculate(int a, int b) {
    if (a < 0) {
      int s = Math.abs(a);
      int e = b + s * 2;
      return e - s;
    }
    return b - a;
  }
}