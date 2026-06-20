import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  static int N;
  static int[][] arr;

  public static void main(String[] args) throws Exception {
    N = Integer.parseInt(br.readLine());
    arr = new int[N][4];

    for (int i = 0; i < N; i++) {
      int[] input = Arrays.stream(br.readLine().split(" "))
          .mapToInt(Integer::parseInt)
          .toArray();
      arr[i][0] = input[0];
      arr[i][1] = input[1];
      arr[i][2] = input[2];
      arr[i][3] = input[3];
    }

    Arrays.sort(arr, (a, b) -> {
      // 시작일이 더 빠를 수록 우선순위 높음
      if (a[0] < b[0]) {
        return -1;
      } else if (a[0] > b[0]) {
        return 1;
      }

      if (a[1] < b[1]) {
        return -1;
      } else if (a[1] > b[1]) {
        return 1;
      }

      // 종료일이 더 늦을 수록 우선순위 높음
      if (a[2] > b[2]) {
        return -1;
      } else if (a[2] < b[2]) {
        return 1;
      }

      if (a[3] > b[3]) {
        return -1;
      } else if (a[3] < b[3]) {
        return 1;
      }
      return 0;
    });

    // System.out.println("==========");
    // for (int i = 0; i < N; i++) {
    // System.out.println(arr[i][0] + " " + arr[i][1] + " " + arr[i][2] + " " +
    // arr[i][3]);
    // }
    // System.out.println("==========");

    int[] start = new int[] { 3, 1 };
    int[] end = new int[] { 12, 1 };
    int[] max = new int[] { 0, 0 };
    int idx = 0;
    int cnt = 0;

    while (start[0] < end[0] || (start[0] == end[0] && start[1] < end[1])) {
      boolean isFinded = false;

      for (int i = idx; i < N; i++) {
        if (start[0] < arr[i][0] || (start[0] == arr[i][0] && start[1] < arr[i][1]))
          break;

        if (max[0] < arr[i][2] || (max[0] == arr[i][2] && max[1] < arr[i][3])) {
          max = new int[] { arr[i][2], arr[i][3] };
          isFinded = true;
          idx = i + 1;
        }
      }

      if (!isFinded)
        break;

      cnt++;
      start = new int[] { max[0], max[1] };
    }

    if (max[0] < 12)
      System.out.println(0);
    else
      System.out.println(cnt);
  }
}