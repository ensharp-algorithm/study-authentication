import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  static int N;
  static int[] A, B;

  public static void main(String[] args) throws Exception {
    int answer = 0;

    N = Integer.parseInt(br.readLine());
    A = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
    B = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

    Arrays.sort(A);
    int[] sortedB = Arrays.stream(B)
        .boxed()
        .sorted(Comparator.reverseOrder())
        .mapToInt(Integer::intValue)
        .toArray();

    for (int i = 0; i < N; i++) {
      answer += A[i] * sortedB[i];
    }
    System.out.println(answer);
  }
}