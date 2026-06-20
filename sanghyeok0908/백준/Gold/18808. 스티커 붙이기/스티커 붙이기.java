import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  static int N, M, K;
  static int[][] paper;

  public static void main(String[] args) throws Exception {
    int count = 0;
    String[] input = br.readLine().split(" ");
    N = Integer.parseInt(input[0]);
    M = Integer.parseInt(input[1]);
    K = Integer.parseInt(input[2]);
    paper = new int[N][M];

    for (int i = 0; i < K; i++) {
      input = br.readLine().split(" ");
      int R = Integer.parseInt(input[0]);
      int C = Integer.parseInt(input[1]);
      int[][] sticker = new int[R][C];

      for (int j = 0; j < R; j++) {
        sticker[j] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
      }

      pushSticker(sticker);
    }

    // System.out.println("============");
    for (int i = 0; i < N; i++) {
      for (int j = 0; j < M; j++) {
        // System.out.print(paper[i][j] + " ");
        if (paper[i][j] == 1) {
          count++;
        }
      }
      // System.out.println("");
    }

    System.out.println(count);
  }

  static void pushSticker(int[][] sticker) {
    for (int rotationCount = 0; rotationCount < 4; rotationCount++) {
      for (int i = 0; i < N; i++) {
        if (N - i < sticker.length)
          break;

        for (int j = 0; j < M; j++) {
          if (M - j < sticker[0].length)
            break;

          if (paper[i][j] == 0 || sticker[0][0] == 0) {
            if (checkPush(sticker, i, j)) {
              push(sticker, i, j);
              return;
            }
          }
        }
      }

      sticker = rotate(sticker);

      // System.out.println("============");
      // for(int i = 0; i < sticker.length; i++) {
      //   for(int j = 0; j < sticker[0].length; j++) {
      //     System.out.print(sticker[i][j] + " ");
      //   }
      //   System.out.println("");
      // }
    }
  }

  static boolean checkPush(int[][] sticker, int startY, int startX) {
    for (int i = 0, y = startY; i < sticker.length; i++, y++) {
      for (int j = 0, x = startX; j < sticker[0].length; j++, x++) {
        if (paper[y][x] == 1 && sticker[i][j] == 1)
          return false;
      }
    }
    return true;
  }

  static void push(int[][] sticker, int startY, int startX) {
    for (int i = 0, y = startY; i < sticker.length; i++, y++) {
      for (int j = 0, x = startX; j < sticker[0].length; j++, x++) {
        if (sticker[i][j] == 1)
          paper[y][x] = 1;
        // else if (paper[y][x] == 1 && sticker[i][j] == 1)
          // System.out.println("ERROR!!!");
      }
    }
  }

  static int[][] rotate(int[][] sticker) {
    int row = sticker.length;
    int col = sticker[0].length;
    int[][] copy = new int[col][row];

    for (int i = 0; i < row; i++) {
      for (int j = 0; j < col; j++) {
        copy[j][row - 1 - i] = sticker[i][j];
      }
    }
    return copy;
  }
}


/*
1, 1, 1, 1, 1
0, 0, 0, 1, 0

0, 1
0, 1
0, 1
1, 1
0, 1

(0, 0) -> (0, 1)
(0, 1) -> (1, 1)
(0, 2) -> (1, 2)
(0, 3) -> (1, 3)
(0, 4) -> (1, 4)

(1, 0) -> (0, 0)
(1, 1) -> (1, 0)
(1, 2) -> (2, 0)
(1, 3) -> (3, 0)
 */