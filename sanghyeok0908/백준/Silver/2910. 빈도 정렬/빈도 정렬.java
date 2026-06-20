import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

  static class Number {
    public int num;
    public int count;
    public int idx;

    public Number(int num, int idx) {
      this.count = 1;
      this.num = num;
      this.idx = idx;
    }
  }

  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  static int N, C;
  static int[] arr;
  static Map<Integer, Number> map = new HashMap<>();

  public static void main(String[] args) throws Exception {
    int[] input = Arrays.stream(br.readLine().split(" "))
        .mapToInt(Integer::parseInt)
        .toArray();
    N = input[0];
    C = input[1];
    arr = Arrays.stream(br.readLine().split(" "))
        .mapToInt(Integer::parseInt)
        .toArray();

    for (int i = 0; i < N; i++) {
      if (map.containsKey(arr[i])) {
        Number number = map.get(arr[i]);
        number.count++;
        map.put(arr[i], number);
      } else {
        map.put(arr[i], new Number(arr[i], i));
      }
    }

    int size = map.keySet().size();
    for (int i = 0; i < size; i++) {
      Number number = null;

      for (Integer j : map.keySet()) {
        if (number == null || number.count < map.get(j).count) {
          number = map.get(j);
        } else if (number.count == map.get(j).count) {
          
          if (number.idx > map.get(j).idx) {
            number = map.get(j);
          }
        }
      }

      for (int j = 0; j < number.count; j++) {
        System.out.print(number.num + " ");
      }

      map.remove(number.num);
    }

  }
}
