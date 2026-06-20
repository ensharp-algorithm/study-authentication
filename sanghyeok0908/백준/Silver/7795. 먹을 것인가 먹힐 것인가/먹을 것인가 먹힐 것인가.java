import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  static int T;

  public static void main(String[] args) throws Exception {
    T = Integer.parseInt(br.readLine());

    while (T-- > 0) {
      int[] input = Arrays.stream(br.readLine().split(" "))
          .mapToInt(Integer::parseInt)
          .toArray();
      int N = input[0];
      int M = input[1];
      int[] A = Arrays.stream(br.readLine().split(" "))
          .mapToInt(Integer::parseInt)
          .toArray();
      int[] B = Arrays.stream(br.readLine().split(" "))
          .mapToInt(Integer::parseInt)
          .toArray();

      int answer = calculate(N, M, A, B);
      System.out.println(answer);
    }
  }

  static int calculate(int N, int M, int[] A, int[] B) {
    int result = 0;

    Arrays.sort(A);
    Arrays.sort(B);

    for (int a : A) {
      if (a > B[M - 1]) {
        result += M;
        continue;
      }

      result += findLowerBound(B, a, 0, M - 1);
    }

    return result;
  }

  /*
   * value보다 크면서 B 배열 중 가장 작은 값을 가진 B 배열의 index를 반환한다.
   */
  static int findLowerBound(int[] B, int value, int left, int right) {
    while (left <= right) {
      int mid = (right + left) / 2;

      if (B[mid] >= value) {
        right = mid - 1;
      } else {
        left = mid + 1;
      }
    }

    return left;
  }
}

/*
 * value = 4
 * 0 1 2 3 4 5
 */
