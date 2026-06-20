
import java.io.*;
import java.util.*;

public class Solution {

  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  static int N, W, H;
  static int[][] matrix;
  static int[] arr;
  static int removedCnt;

  public static void main(String[] args) throws Exception {
    int T = Integer.parseInt(br.readLine());
    StringBuilder sb = new StringBuilder();
    for (int t = 1; t <= T; t++) {
      int brickCnt = 0;
      StringTokenizer st = new StringTokenizer(br.readLine());
      N = Integer.parseInt(st.nextToken());
      W = Integer.parseInt(st.nextToken());
      H = Integer.parseInt(st.nextToken());
      matrix = new int[H][W];
      arr = new int[N];
      removedCnt = 0;
      for (int i = 0; i < H; i++) {
        st = new StringTokenizer(br.readLine());
        for (int j = 0; j < W; j++) {
          matrix[i][j] = Integer.parseInt(st.nextToken());
          if (matrix[i][j] != 0)
            brickCnt++;
        }
      }

      bruthForce(0);
      sb.append("#")
          .append(t)
          .append(" ")
          .append(brickCnt - removedCnt)
          .append("\n");
    }
    System.out.println(sb);
  }

  static void bruthForce(int depth) {
    if (depth == N) {
      // System.out.println("============");
      // for (int i = 0; i < N; i++) {
      // System.out.print(arr[i] + " ");
      // }
      // System.out.println();

      int value = calculate();

      // System.out.println(value);
      removedCnt = Math.max(removedCnt, value);
      return;
    }

    for (int i = 0; i < W; i++) {
      arr[depth] = i;
      bruthForce(depth + 1);
    }
  }

  static int calculate() {
    int result = 0;
    int[][] copy = new int[H][W];

    for (int i = 0; i < H; i++) {
      copy[i] = matrix[i].clone();
    }

    for (int i = 0; i < N; i++) {
      int startY = 0;
      int startX = arr[i];

      while (startY < H && copy[startY][startX] == 0) {
        startY++;
      }

      if (startY < H) {
        result += spread(copy, startY, startX);
        sort(copy);

        // if (arr[0] == 2 && arr[1] == 2 && arr[2] == 6) {
        //   print(copy);
        // }
      }
    }

    return result;
  }

  static int spread(int[][] copy, int y, int x) {
    if (!isIn(y, x) || copy[y][x] == 0)
      return 0;

    int result = 1;
    int value = copy[y][x];

    copy[y][x] = 0;

    for (int i = 1; i < value; i++) {
      result += spread(copy, y - i, x);
      result += spread(copy, y, x - i);
      result += spread(copy, y, x + i);
      result += spread(copy, y + i, x);
    }
    return result;
  }

  static void sort(int[][] copy) {
    for (int i = 0; i < W; i++) {
      for (int j = 0; j < H; j++) {
        if (copy[H - 1 - j][W - 1 - i] == 0) {
          down(copy, H - 1 - j, W - 1 - i);
        }
      }
    }
  }

  static void down(int[][] copy, int y, int x) {
    int curY = y;
    int moveY = y - 1;
    while (moveY >= 0 && copy[moveY][x] == 0) {
      moveY--;
    }

    if (moveY < 0)
      return;

    for (int i = moveY; i >= 0; i--, curY--) {
      copy[curY][x] = copy[i][x];
      copy[i][x] = 0;
    }
  }

  static boolean isIn(int y, int x) {
    return y >= 0 && y < H && x >= 0 && x < W;
  }

  static void print(int[][] copy) {
    System.out.println("================");
    for (int i = 0; i < H; i++) {
      for (int j = 0; j < W; j++) {
        System.out.print(copy[i][j] + " ");
      }
      System.out.println();
    }
  }
}