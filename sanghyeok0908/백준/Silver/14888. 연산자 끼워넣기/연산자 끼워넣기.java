import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  static int N;
  static int[] arr;
  static int[] trackingArr;
  static boolean[] isUsed;
  static int[] operations;
  static int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;

  public static void main(String[] args) throws Exception {
    N = Integer.parseInt(br.readLine());
    isUsed = new boolean[N - 1];
    operations = new int[N - 1];
    trackingArr = new int[N - 1];
    arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

    int[] temps = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
    int idx = 0;
    for (int i = 0; i < 4; i++) {
      for (int j = 0; j < temps[i]; j++) {
        operations[idx++] = i;
      }
    }

    backTracking(0);
    System.out.println(max);
    System.out.println(min);
  }

  static void backTracking(int depth) {
    if (depth == N - 1) {
      int result = calculate();
      max = Math.max(max, result);
      min = Math.min(min, result);
      return;
    }

    for (int i = 0; i < N - 1; i++) {
      if (isUsed[i]) {
        continue;
      }

      isUsed[i] = true;
      trackingArr[depth] = operations[i];
      backTracking(depth + 1);
      isUsed[i] = false;
    }
  }

  static int calculate() {
    int result = arr[0];

    for (int i = 0; i < N - 1; i++) {
      switch (trackingArr[i]) {
        case 0:
          result += arr[i + 1];
          break;
        case 1:
          result -= arr[i + 1];
          break;
        case 2:
          result *= arr[i + 1];
          break;
        case 3:
          result /= arr[i + 1];
          break;
      }
    }

    return result;
  }
}
