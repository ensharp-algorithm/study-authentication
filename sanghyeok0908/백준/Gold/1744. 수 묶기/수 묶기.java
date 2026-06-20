import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

  public static void main(String[] args) throws Exception {
    int answer = 0;
    int N = Integer.parseInt(br.readLine());
    Queue<Integer> plusQueue = new PriorityQueue<>((a, b) -> b - a);
    Queue<Integer> minusQueue = new PriorityQueue<>((a, b) -> a - b);
    int zeroCount = 0;

    for (int i = 0; i < N; i++) {
      int input = Integer.parseInt(br.readLine());
      if (input > 0) {
        plusQueue.add(input);
      } else if (input < 0) {
        minusQueue.add(input);
      } else {
        zeroCount++;
      }
    }

    while (plusQueue.size() > 1) {
      int a = plusQueue.poll();
      int b = plusQueue.poll();

      if (a * b > a + b) {
        answer += a * b;
      } else {
        answer += a + b;
      }
    }

    if (!plusQueue.isEmpty()) {
      answer += plusQueue.poll();
    }

    while (minusQueue.size() > 1) {
      int a = minusQueue.poll();
      int b = minusQueue.poll();

      answer += a * b;
    }

    while (zeroCount-- > 0 && !minusQueue.isEmpty()) {
      minusQueue.poll();
    }

    while(!minusQueue.isEmpty()) {
      answer += minusQueue.poll();
    }

    System.out.println(answer);
  }
}