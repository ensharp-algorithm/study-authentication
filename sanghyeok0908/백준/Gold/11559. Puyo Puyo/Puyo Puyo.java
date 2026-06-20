import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  static char[][] matrix = new char[12][6];
  static int colSize = -1;
  static int[] dy = new int[] { -1, 1, 0, 0 };
  static int[] dx = new int[] { 0, 0, -1, 1 };

  public static void main(String[] args) throws Exception {
    int count = 0;

    for (int i = 0; i < 12; i++) {
      String input = br.readLine();
      char[] arr = input.toCharArray();

      if (colSize == -1) {
        for (char a : arr) {
          if (a == 'R' || a == 'G' || a == 'P' || a == 'Y') {
            colSize = 0;
            matrix = new char[12 - i][6];
            break;
          }
        }
      }

      if (colSize != -1) {
        matrix[colSize++] = arr.clone();
      }
    }

    while (func()) {

      // System.out.println("=============시작 전 출력 시작");
      // for (int i = 0; i < colSize; i++) {
      //   for (int k = 0; k < 6; k++) {
      //     System.out.print(matrix[i][k] + " ");
      //   }
      //   System.out.println("");
      // }
      // System.out.println("=============시작 전 출력 종료");

      // 연쇄가 일어났다면 뿌요 떨어트리기
      count++;
      for (int j = 0; j < 6; j++) {
        List<Integer> puyos = new ArrayList();
        int dropIdx = -1;

        for (int i = colSize - 1; i >= 0; i--) {
          if (dropIdx == -1 && matrix[i][j] == '.') {
            dropIdx = i;
          } else if (dropIdx != -1 && matrix[i][j] != '.') {
            puyos.add(i);
          }
        }

        // System.out.println("뿌요 수 = " + puyos.size());

        for (int idx : puyos) {
          matrix[dropIdx--][j] = matrix[idx][j];
        }

        for (int i = dropIdx; i >= 0; i--) {
          matrix[i][j] = '.';
        }

        // System.out.println("=============j = " + j);
        // for (int ii = 0; ii < colSize; ii++) {
        //   for (int k = 0; k < 6; k++) {
        //     System.out.print(matrix[ii][k] + " ");
        //   }
        //   System.out.println("");
        // }
      }
    }

    System.out.println(count + "");
  }

  static boolean func() {
    boolean isExist = false;

    for (int i = 0; i < colSize; i++) {
      for (int j = 0; j < 6; j++) {
        if (matrix[i][j] != '.') {
          Queue<int[]> puyos = bfs(i, j);

          if (puyos.size() >= 4) {
            isExist = true;

            while (!puyos.isEmpty()) {
              int[] poll = puyos.poll();
              matrix[poll[0]][poll[1]] = '.';
            }
          }
        }
      }
    }

    return isExist;
  }

  static Queue<int[]> bfs(int y, int x) {
    Queue<int[]> puyos = new ArrayDeque();
    Queue<int[]> queue = new ArrayDeque();
    boolean[][] isVisited = new boolean[colSize][6];
    queue.add(new int[] { y, x });
    isVisited[y][x] = true;

    while (!queue.isEmpty()) {
      int[] poll = queue.poll();
      puyos.add(poll);

      for (int i = 0; i < 4; i++) {
        int curY = poll[0] + dy[i];
        int curX = poll[1] + dx[i];

        if (!isIn(curY, curX) || isVisited[curY][curX] || matrix[curY][curX] != matrix[poll[0]][poll[1]])
          continue;

        queue.add(new int[] { curY, curX });
        isVisited[curY][curX] = true;
      }
    }

    return puyos;
  }

  static boolean isIn(int y, int x) {
    return 0 <= y && y < colSize && 0 <= x && x < 6;
  }
}