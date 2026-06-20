import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  static int n, w, L;
  static Queue<Integer> trucks = new ArrayDeque();

  public static void main(String[] args) throws Exception {
    int[] input = Arrays.stream(br.readLine().split(" "))
        .mapToInt(Integer::parseInt)
        .toArray();
    n = input[0];
    w = input[1];
    L = input[2];

    Arrays.stream(br.readLine().split(" "))
        .mapToInt(Integer::parseInt)
        .forEach(trucks::add);
    System.out.println(calculate());
  }

  static int calculate() {
    int count = 0;
    int sum = 0;
    Queue<Integer> bridge = new ArrayDeque();

    while (!trucks.isEmpty()) {
      // 다리에 트럭이 가득 찼다면,
      // 맨 앞 트럭 빼주기
      if (bridge.size() == w) {
        sum -= bridge.poll();
      }

      // 다리에 트럭 올리기
      while (bridge.size() < w) {

        if (!trucks.isEmpty() && sum + trucks.peek() <= L) {
          int truck = trucks.poll();

          bridge.add(truck);
          sum += truck;
        } else {
          bridge.add(0);
        }

        count++;
      }

      // System.out.println(String.format("count = %d, sum = %d", count, sum));
      // for (Integer b : bridge) {
      //   System.out.print(b + " ");
      // }
      // System.out.println();
    }

    int lastIdx = 0;
    int idxCount = 0;
    for (Integer b : bridge) {
      if (b != 0) {
        lastIdx = idxCount;
      }
      idxCount++;
    }

    return count + lastIdx + 1;
  }

}