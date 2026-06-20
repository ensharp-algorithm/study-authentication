import java.io.*;
import java.util.*;

// Arrays.stream(br.readLine().split(" "))
//           .mapToInt(Integer::parseInt)
//           .toArray();

public class Main {

  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  static int N, M;
  static int[] B;

  public static void main(String[] args) throws Exception {
    int[] input = Arrays.stream(br.readLine().split(" "))
        .mapToInt(Integer::parseInt)
        .toArray();
    N = input[0];
    M = input[1];
    int[] A = Arrays.stream(br.readLine().split(" "))
        .mapToInt(Integer::parseInt)
        .toArray();
    B = Arrays.stream(br.readLine().split(" "))
        .mapToInt(Integer::parseInt)
        .toArray();
    Queue<Integer> result = new PriorityQueue<>((a, b) -> a - b);

    Arrays.sort(B);

    for (int i = 0; i < N; i++) {
      if (!isExist(A[i], 0, M - 1)) {
        result.add(A[i]);
      }
    }

    System.out.println(result.size());
    while (!result.isEmpty()) {
      System.out.print(result.poll() + " ");
    }
    System.out.println();
  }

  static boolean isExist(int target, int left, int right) {
    if (left > right)
      return false;

    int mid = (left + right) / 2;

    if (B[mid] == target) {
      return true;
    }

    if (left == right)
      return false;

    if (B[mid] < target) {
      return isExist(target, mid + 1, right);
    }
    return isExist(target, left, mid - 1);
  }
}

// 4 7 9