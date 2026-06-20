import java.io.*;
import java.util.*;

// Arrays.stream(br.readLine().split(" "))
//           .mapToInt(Integer::parseInt)
//           .toArray();

public class Main {

  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  static int N, M;
  static int[] arr, checkArr;

  public static void main(String[] args) throws Exception {
    N = Integer.parseInt(br.readLine());
    arr = Arrays.stream(br.readLine().split(" "))
        .mapToInt(Integer::parseInt)
        .toArray();
    M = Integer.parseInt(br.readLine());
    checkArr = Arrays.stream(br.readLine().split(" "))
        .mapToInt(Integer::parseInt)
        .toArray();
    
    Arrays.sort(arr);

    // for(int i = 0; i < N; i++) {
    //   System.out.print(arr[i] + " ");
    // }
    // System.out.println();

    StringBuilder sb = new StringBuilder();

    for (int i = 0; i < M; i++) {
      if (isExist(checkArr[i], 0, N - 1)) {
        sb.append(1).append(" ");
      } else {
        sb.append(0).append(" ");
      }
    }

    System.out.println(sb);
  }

  static boolean isExist(int target, int left, int right) {
    if (left > right) return false;

    int mid = (left + right) / 2;

    if (arr[mid] == target) {
      return true;
    }

    if (arr[mid] < target) {
      return isExist(target, mid + 1, right);
    }
    return isExist(target, left, mid - 1);
  }
}

// 2 3 1 2 3