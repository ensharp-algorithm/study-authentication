import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  static int N, M;
  static boolean[] arr;
  static int answer = Integer.MAX_VALUE;
  static List<int[]> chickens = new ArrayList<>();
  static List<int[]> houses = new ArrayList<>();

  public static void main(String[] args) throws Exception {
    String[] split = br.readLine().split(" ");
    N = Integer.parseInt(split[0]);
    M = Integer.parseInt(split[1]);
    int[][] matrix = new int[N][N];

    for (int i = 0; i < N; i++) {
      matrix[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

      for (int j = 0; j < N; j++) {
        if (matrix[i][j] == 2) {
          chickens.add(new int[] { i, j });
        } else if (matrix[i][j] == 1) {
          houses.add(new int[] { i, j });
        }
      }
    }

    arr = new boolean[chickens.size()];

    func(0, 0);
    System.out.println(answer + "");
  }

  static void func(int start, int depth) {
    if (depth == M) {
      int sum = 0;
      for (int[] house : houses) {
        int min = Integer.MAX_VALUE;

        for (int i = 0; i < chickens.size(); i++) {
          if (arr[i]) {
            int distance = Math.abs(house[0] - chickens.get(i)[0]) + Math.abs(house[1] - chickens.get(i)[1]);
            min = Math.min(min, distance);
          }
        }

        sum += min;
      }

      // for (int i = 0; i < arr.length; i++)
      //   System.out.print(arr[i] + " ");
      // System.out.println("");

      answer = Math.min(answer, sum);
      return;
    }

    for (int i = start; i < chickens.size(); i++) {
      arr[i] = true;

      // System.out.println(String.format("start = %d, i = %d, depth = %d", start, i,
      // depth));
      // for (int j = 0; j < arr.length; j++)
      // System.out.print(arr[j] + " ");
      // System.out.println("");

      func(i + 1, depth + 1);
      arr[i] = false;
    }
  }
}