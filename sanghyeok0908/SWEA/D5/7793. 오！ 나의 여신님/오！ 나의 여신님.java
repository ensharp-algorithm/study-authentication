import java.io.*;
import java.util.*;

public class Solution {
  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  static char[][] matrix;
  static int N, M;
  static int[] dy = new int[] { -1, 1, 0, 0 };
  static int[] dx = new int[] { 0, 0, -1, 1 };
  static boolean[][][] develMap;
  static boolean[] isUpdated;

  public static void main(String[] args) throws Exception {
    int T = Integer.parseInt(br.readLine());
    StringBuilder sb = new StringBuilder();
    for (int t = 1; t <= T; t++) {
      int startY = 0, startX = 0, endY = 0, endX = 0;
      StringTokenizer st = new StringTokenizer(br.readLine());
      N = Integer.parseInt(st.nextToken());
      M = Integer.parseInt(st.nextToken());
      matrix = new char[N][M];
      develMap = new boolean[N * M + 10][N][M];
      isUpdated = new boolean[N * M + 10];

      for (int i = 0; i < N; i++) {
        String input = br.readLine();
        for (int j = 0; j < M; j++) {
          matrix[i][j] = input.charAt(j);
          if (matrix[i][j] == 'S') {
            startY = i;
            startX = j;
          } else if (matrix[i][j] == 'D') {
            endY = i;
            endX = j;
          } else if (matrix[i][j] == '*') {
            develMap[0][i][j] = true;
          }
        }
      }

      int answer = calculate(startY, startX, endY, endX);
      sb.append("#")
          .append(t)
          .append(" ")
          .append(answer == -1 ? "GAME OVER" : answer)
          .append("\n");
    }
    System.out.println(sb);
  }

  static int calculate(int startY, int startX, int endY, int endX) {
    Queue<int[]> queue = new ArrayDeque<>();
    boolean[][] visited = new boolean[N][M];

    queue.add(new int[] { startY, startX, 0 });
    visited[startY][startX] = true;

    isUpdated[0] = true;
    // System.out.println(develMap[0][0][1] ? "test" : "No");

    while (!queue.isEmpty()) {
      int[] poll = queue.poll();
      int time = poll[2];

      setDevel(time + 1);
      // printDevel(time + 1);

      for (int i = 0; i < 4; i++) {
        int curY = poll[0] + dy[i];
        int curX = poll[1] + dx[i];

        if (!isIn(curY, curX) || visited[curY][curX] || develMap[time + 1][curY][curX]) {
          continue;
        }

        if (curY == endY && curX == endX) {
          return time + 1;
        }

        // System.out.println("human " + curY + " " + curX);
        // printDevel(time + 1);

        visited[curY][curX] = true;
        queue.add(new int[] { curY, curX, time + 1 });
      }
    }
    return -1;
  }

  static void setDevel(int time) {
    if (isUpdated[time]) {
      return;
    }

    for (int i = 0; i < N; i++) {
      for (int j = 0; j < M; j++) {
        if (develMap[time - 1][i][j]) {
          develMap[time][i][j] = true;

          for (int k = 0; k < 4; k++) {
            int y = i + dy[k];
            int x = j + dx[k];

            if (isIn(y, x) && matrix[y][x] != 'D') {
              develMap[time][y][x] = true;
            }
          }
        }
      }
    }

    // printDevel(time);
    isUpdated[time] = true;
  }

  static boolean isIn(int y, int x) {
    return y >= 0 && y < N && x >= 0 && x < M && matrix[y][x] != 'X';
  }

  static void printDevel(int time) {
    System.out.println("===================");
    for (int i = 0; i < N; i++) {
      for (int j = 0; j < M; j++) {
        System.out.print(develMap[time][i][j] ? 1 : 0);
      }
      System.out.println();
    }
  }
}
