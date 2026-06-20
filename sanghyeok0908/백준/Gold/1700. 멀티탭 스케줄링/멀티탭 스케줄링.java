import java.io.*;
import java.util.*;

// Arrays.stream(br.readLine().split(" "))
//           .mapToInt(Integer::parseInt)
//           .toArray();

public class Main {

  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  static int N, K;
  static int[] products;
  static Map<Integer, Integer> socket = new HashMap<>();

  public static void main(String[] args) throws Exception {
    int[] input = Arrays.stream(br.readLine().split(" "))
        .mapToInt(Integer::parseInt)
        .toArray();
    int answer = 0;

    N = input[0];
    K = input[1];
    products = Arrays.stream(br.readLine().split(" "))
        .mapToInt(Integer::parseInt)
        .toArray();

    for (int i = 0; i < K; i++) {
      if (socket.containsKey(products[i])) {
        continue;
      }

      if (socket.size() < N) {
        socket.put(products[i], 1);
        continue;
      }

      int removedKey = -1;
      int maxFutureIdx = -1;

      for (Integer key : socket.keySet()) {
        int tempIdx = Integer.MAX_VALUE;

        for (int j = i + 1; j < K; j++) {

          if (products[j] == key) {
            tempIdx = j;
            break;
          }
        }

        if (tempIdx > maxFutureIdx) {
          maxFutureIdx = tempIdx;
          removedKey = key;
        }
      }

      socket.remove(removedKey);
      socket.put(products[i], 1);
      answer++;
    }

    System.out.println(answer);
  }
}

// 2 3 1 2 3