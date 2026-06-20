import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

  public static void main(String[] args) throws Exception {
    int N = Integer.parseInt(br.readLine());
    List<int[]> list = new ArrayList<>();
    int answer = 0;

    for (int i = 0; i < N; i++) {
      list.add(Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray());
    }

    for (int i = 1; i < N; i++) {
      int[] prev = list.get(i - 1);
      int[] cur = list.get(i);

      cur[0] = cur[0] + prev[0];
      for (int j = 1; j < cur.length - 1; j++) {
        cur[j] = cur[j] + Math.max(prev[j], prev[j - 1]);
      }
      cur[cur.length - 1] = cur[cur.length - 1] + prev[prev.length - 1];
    }

    // for (int[] arr : list) {
    //   for (int i : arr) {
    //     System.out.print(i + " ");
    //   }
    //   System.out.println();
    // }

    for (int i : list.get(N - 1)) {
      answer = Math.max(answer, i);
    }
    System.out.println(answer);
  }
}