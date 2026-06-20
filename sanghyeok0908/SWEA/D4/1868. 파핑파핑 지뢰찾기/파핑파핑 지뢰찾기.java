
import java.io.*;
import java.util.*;

public class Solution {

  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  static int N;
  static char[][] matrix;
  static boolean[][] visited;
  static int[] dy = new int[] { -1, 1, 0, 0, -1, -1, 1, 1 };
  static int[] dx = new int[] { 0, 0, -1, 1, -1, 1, -1, 1 };

  public static void main(String[] args) throws Exception {
    int T = Integer.parseInt(br.readLine());
    StringBuilder sb = new StringBuilder();
    for (int t = 1; t <= T; t++) {
      N = Integer.parseInt(br.readLine());
      matrix = new char[N][N];
      visited = new boolean[N][N];
      for (int i = 0; i < N; i++) {
        String input = br.readLine();
        for (int j = 0; j < N; j++) {
          matrix[i][j] = input.charAt(j);
        }
      }

      List<int[]> zeroList = new ArrayList<>();
      for (int i = 0; i < N; i++) {
        for (int j = 0; j < N; j++) {
          if (matrix[i][j] == '.') {
            setMatrix(i, j);

            if (matrix[i][j] == '0') {
              zeroList.add(new int[] { i, j });
            }
          }
        }
      }

      // print();

      int answer = 0;
      for (int[] pos : zeroList) {
        int y = pos[0];
        int x = pos[1];

        if (matrix[y][x] == '0' && !visited[y][x]) {
          spread(y, x);
          answer++;
        }
      }

      for (int i = 0; i < N; i++) {
        for (int j = 0; j < N; j++) {
          if (matrix[i][j] == '.' && !visited[i][j]) {
            answer++;
          }
        }
      }

      sb.append("#")
          .append(t)
          .append(" ")
          .append(answer)
          .append("\n");
    }
    System.out.println(sb);
  }

  static void setMatrix(int y, int x) {
    boolean hasBoom = false;

    for (int i = 0; i < 8; i++) {
      int nearY = y + dy[i];
      int nearX = x + dx[i];

      if (isIn(nearY, nearX) && matrix[nearY][nearX] == '*') {
        hasBoom = true;
      }
    }
    matrix[y][x] = hasBoom ? matrix[y][x] : '0';
  }

  static void spread(int y, int x) {
    if (!isIn(y, x) || visited[y][x]) {
      return;
    }

    visited[y][x] = true;
    for (int i = 0; i < 8; i++) {
      int nearY = y + dy[i];
      int nearX = x + dx[i];

      if (isIn(nearY, nearX)) {
        if (matrix[nearY][nearX] == '0') {
          spread(nearY, nearX);
        } else {
          visited[nearY][nearX] = true;
        }
      }
    }
  }

  static boolean isIn(int y, int x) {
    return y >= 0 && y < N && x >= 0 && x < N;
  }

  static void print() {
    System.out.println("====================");
    for (int i = 0; i < N; i++) {
      for (int j = 0; j < N; j++) {
        System.out.print(matrix[i][j] + " ");
      }
      System.out.println();
    }
  }
}
