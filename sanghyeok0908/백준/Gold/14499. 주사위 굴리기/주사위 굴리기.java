import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  static int N, M;
  static int[][] map;
  static int[] dice = new int[6];
  static int curY, curX;

  public static void main(String[] args) throws Exception {
    int K;
    int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

    N = input[0];
    M = input[1];
    curY = input[2];
    curX = input[3];
    K = input[4];
    map = new int[N][M];

    for (int i = 0; i < N; i++) {
      map[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
    }

    input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

    for (int i = 0; i < K; i++) {
      move(input[i]);
    }
  }

  static void move(int direction) {
    switch (direction) {
      case 1:
        if (isNotIn(curY, curX + 1))
          return;
        curX++;
        dice = new int[] {dice[3], dice[1], dice[0], dice[5], dice[4], dice[2]};
        break;
      case 2:
        if (isNotIn(curY, curX - 1))
          return;
        curX--;
        dice = new int[] {dice[2], dice[1], dice[5], dice[0], dice[4], dice[3]};
        break;
      case 3:
        if (isNotIn(curY - 1, curX))
          return;
        curY--;
        dice = new int[] {dice[4], dice[0], dice[2], dice[3], dice[5], dice[1]};
        break;
      case 4:
        if (isNotIn(curY + 1, curX))
          return;
        curY++;
        dice = new int[] {dice[1], dice[5], dice[2], dice[3], dice[0], dice[4]};
        break;
    }

    // System.out.println(String.format("direction = %d, cur = (%d, %d)", direction, curY, curX));

    if (map[curY][curX] == 0) {
      map[curY][curX] = dice[5];
    } else {
      dice[5] = map[curY][curX];
      map[curY][curX] = 0;
    }

    // for (int i = 0; i < 6; i++)
    //   System.out.print(dice[i] + " ");
    // System.out.println("");

    System.out.println(dice[0]);
  }

  static boolean isNotIn(int y, int x) {
    return y < 0 || y >= N || x < 0 || x >= M;
  }
}