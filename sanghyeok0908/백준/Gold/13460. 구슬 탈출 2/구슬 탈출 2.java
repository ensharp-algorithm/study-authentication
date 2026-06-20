import java.io.*;
import java.util.*;

public class Main {

  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  static int N, M;
  static char[][] matrix;

  public static void main(String[] args) throws Exception {
    int[] redIdx = null;
    int[] blueIdx = null;
    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());
    matrix = new char[N][M];

    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine());
      matrix[i] = st.nextToken().toCharArray();

      for (int j = 0; j < M; j++) {
        if (matrix[i][j] == 'R') {
          redIdx = new int[] { i, j };
        } else if (matrix[i][j] == 'B') {
          blueIdx = new int[] { i, j };
        }
      }
    }

    int result = move(redIdx, blueIdx);
    System.out.println(result);
  }

  static int move(int[] redIdx, int[] blueIdx) {
    Queue<int[]> queue = new ArrayDeque<>();
    boolean[][][][] isVisited = new boolean[N][M][N][M];
    int[] dy = new int[] { -1, 1, 0, 0 };
    int[] dx = new int[] { 0, 0, -1, 1 };

    queue.add(new int[] { redIdx[0], redIdx[1], blueIdx[0], blueIdx[1], 0 });

    while (!queue.isEmpty()) {
      int[] poll = queue.poll();

      for (int i = 0; i < 4; i++) {
        int redY = poll[0];
        int redX = poll[1];
        int blueY = poll[2];
        int blueX = poll[3];
        int result = poll[4];
        boolean redGoal = false;
        boolean blueGoal = false;

        if (result >= 10) {
          return -1;
        }

        // red ball 움직이기
        while (matrix[redY + dy[i]][redX + dx[i]] != '#') {
          redY += dy[i];
          redX += dx[i];

          if (matrix[redY][redX] == 'O') {
            redGoal = true;
            break;
          }
        }

        // blue ball 움직이기
        while (matrix[blueY + dy[i]][blueX + dx[i]] != '#') {
          blueY += dy[i];
          blueX += dx[i];

          if (matrix[blueY][blueX] == 'O') {
            blueGoal = true;
            break;
          }
        }

        if (redGoal && !blueGoal) {
          return result + 1;
        } else if (blueGoal) {
          continue;
        }

        if (redY == blueY && redX == blueX) {
          int diffRed = Math.abs(redY - poll[0] + redX - poll[1]);
          int diffBlue = Math.abs(blueY - poll[2] + blueX - poll[3]);

          if (diffRed > diffBlue) {
            redY -= dy[i];
            redX -= dx[i];
          } else {
            blueY -= dy[i];
            blueX -= dx[i];
          }
        }

        if (isVisited[redY][redX][blueY][blueX])
          continue;

        isVisited[redY][redX][blueY][blueX] = true;
        queue.add(new int[] { redY, redX, blueY, blueX, result + 1 });
      }
    }

    return -1;
  }
}