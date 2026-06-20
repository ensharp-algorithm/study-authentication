import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

  static class Cycle {
    int[] numbers = new int[8];

    Cycle(String input) {
      char[] inputArr = input.toCharArray();

      for (int j = 0; j < inputArr.length; j++) {
        numbers[j] = Integer.parseInt(inputArr[j] + "");
      }
    }

    void rotation(int direction) {
      if (direction == 1) {
        int last = numbers[7];

        for (int i = 6; i >= 0; i--) {
          numbers[i + 1] = numbers[i];
        }

        numbers[0] = last;
      } else {
        int first = numbers[0];

        for (int i = 1; i < 8; i++) {
          numbers[i - 1] = numbers[i];
        }

        numbers[7] = first;
      }
    }
  }

  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  // static int[][] cycles = new int[4][8]; // left = 6번 쨰, right = 2번 째
  static Cycle[] cycles = new Cycle[4];

  public static void main(String[] args) throws Exception {
    int answer = 0;

    for (int i = 0; i < 4; i++) {
      String input = br.readLine();
      cycles[i] = new Cycle(input);
    }

    int K = Integer.parseInt(br.readLine());
    for (int i = 0; i < K; i++) {
      String[] input = br.readLine().split(" ");
      rotation(Integer.parseInt(input[0]) - 1, Integer.parseInt(input[1]), new boolean[4]);
    }

    if (cycles[0].numbers[0] == 1) answer += 1;
    if (cycles[1].numbers[0] == 1) answer += 2;
    if (cycles[2].numbers[0] == 1) answer += 4;
    if (cycles[3].numbers[0] == 1) answer += 8;

    System.out.println(answer + "");
  }

  static void rotation(int cycleIdx, int direction, boolean[] isVisited) {
    // System.out.println("Idx = " + cycleIdx + ", direction = " + direction + ",
    // rotat 전");
    // for (int i = 0; i < 8; i++) {
    // System.out.print(cycles[cycleIdx].numbers[i] + " ");
    // }
    // System.out.println();

    boolean leftPlanned = false, rightPlanned = false;
    if (cycleIdx - 1 >= 0 && cycles[cycleIdx - 1].numbers[2] != cycles[cycleIdx].numbers[6] && !isVisited[cycleIdx - 1])
      leftPlanned = true;
    if (cycleIdx + 1 < 4 && cycles[cycleIdx].numbers[2] != cycles[cycleIdx + 1].numbers[6] && !isVisited[cycleIdx + 1])
      rightPlanned = true;

    isVisited[cycleIdx] = true;
    cycles[cycleIdx].rotation(direction);

    // System.out.println("Idx = " + cycleIdx + ", rotat 후");
    // for (int i = 0; i < 8; i++) {
    // System.out.print(cycles[cycleIdx].numbers[i] + " ");
    // }
    // System.out.println();

    if (leftPlanned)
      rotation(cycleIdx - 1, direction == -1 ? 1 : -1, isVisited);
    if (rightPlanned)
      rotation(cycleIdx + 1, direction == -1 ? 1 : -1, isVisited);
  }
}