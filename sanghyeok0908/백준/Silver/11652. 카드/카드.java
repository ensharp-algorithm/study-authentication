import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  static int N;
  static Map<Long, Integer> map = new HashMap<>();
  static long answer = 0;
  static int count = 0;

  public static void main(String[] args) throws Exception {
    N = Integer.parseInt(br.readLine());

    for (int i = 0; i < N; i++) {
      Long input = Long.parseLong(br.readLine());
      if (map.containsKey(input)) {
        map.put(input, map.get(input) + 1);
      } else {
        map.put(input, 1);
      }

      if (map.get(input) > count) {
        answer = input;
        count = map.get(input);
      } else if (map.get(input) == count) {
        if (answer > input) {
          answer = input;
          count = map.get(input);
        }
      }

      // System.out.println("map.get = " + map.get(input) + " answer = " + answer + " count = " + count);
    }

    // map.forEach((a, b) -> {
    //   System.out.println(a + ": " + b);
    // });

    System.out.println(answer);
  }
}
