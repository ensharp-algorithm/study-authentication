import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;


public class Main {

  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  static int N, M;
  static int[] arr;

  public static void main(String[] args) throws Exception {
    String[] input = br.readLine().split(" ");
    
    N = Integer.parseInt(input[0]);
    M = Integer.parseInt(input[1]);
    arr = new int[M];

    solution(0, 1);
  }

  static public void solution(int k, int v) {
    if (k == M) {
      for(int a : arr) {
        System.out.print(a + " ");
      }
      System.out.println();
      return;
    }

    for(int i = v; i <= N; i++) {
      arr[k] = i;
      solution(k + 1, i + 1);
    }
  }
}