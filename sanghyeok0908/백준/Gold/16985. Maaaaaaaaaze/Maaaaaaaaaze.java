import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  static int[] arr = new int[5];
  static int[][][] cube = new int[5][5][5];
  static int answer = Integer.MAX_VALUE;
  static int[] dz = new int[] { -1, 1, 0, 0, 0, 0 };
  static int[] dy = new int[] { 0, 0, -1, 1, 0, 0 };
  static int[] dx = new int[] { 0, 0, 0, 0, -1, 1 };
  static boolean[] isUsed = new boolean[5];
  static int[] orderArr = new int[5];

  public static void main(String[] args) throws Exception {
    for (int i = 0; i < 5; i++) {
      for (int j = 0; j < 5; j++) {
        cube[i][j] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
      }
    }

    // System.out.println("============= start ");

    backTrackingForCubeOrder(0);

    if (answer != Integer.MAX_VALUE) {
      System.out.println(answer);
    } else {
      System.out.println(-1);
    }
  }

  static void backTrackingForCubeOrder(int depth) {
    if (depth == 5) {
      backTracking(0);
      return;
    }

    for (int i = 0; i < 5; i++) {
      if (isUsed[i])
        continue;

      isUsed[i] = true;
      orderArr[depth] = i;
      backTrackingForCubeOrder(depth + 1);
      isUsed[i] = false;
    }
  }

  static void backTracking(int depth) {
    if (depth == 5) {
      int[][][] rotatedCube = new int[5][5][5];

      for (int i = 0; i < 5; i++) {
        int idx = orderArr[i];
        rotatedCube[i] = rotate(cube[idx], arr[i]);
      }

      // 입구와 출구가 막혀있다면 종료
      if (rotatedCube[0][0][0] == 0 || rotatedCube[4][4][4] == 0) {
        return;
      }

      // print(rotatedCube);

      answer = Math.min(answer, bfs(rotatedCube));

      // System.out.println("answer = " + answer);
      return;
    }

    for (int i = 0; i < 4; i++) {
      arr[depth] = i;
      backTracking(depth + 1);
    }
  }

  static int[][] rotate(int[][] matrix, int count) {
    int[][] copy = new int[5][5];

    for (int i = 0; i < 5; i++) {
      copy[i] = matrix[i].clone();
    }

    for (int c = 0; c < count; c++) {
      int[][] temp = new int[5][5];

      for (int i = 0; i < 5; i++) {
        for (int j = 0; j < 5; j++) {
          temp[j][5 - 1 - i] = copy[i][j];
        }
      }

      copy = temp;
    }
    return copy;
  }

  static int bfs(int[][][] matrix) {
    Queue<int[]> queue = new ArrayDeque();
    boolean[][][] isVisited = new boolean[5][5][5];

    queue.add(new int[] { 0, 0, 0, 0 });
    isVisited[0][0][0] = true;

    while (!queue.isEmpty()) {
      int[] prev = queue.poll();

      for (int i = 0; i < 6; i++) {
        int curZ = prev[0] + dz[i];
        int curY = prev[1] + dy[i];
        int curX = prev[2] + dx[i];
        int count = prev[3];

        if (isNotIn(curZ, curY, curX)
            || matrix[curZ][curY][curX] == 0
            || isVisited[curZ][curY][curX]) {
          continue;
        }

        // 출구에 도착했을 때 이동 거리 반환
        if (curZ == 4 && curY == 4 && curX == 4) {
          return count + 1;
        }

        isVisited[curZ][curY][curX] = true;
        queue.add(new int[] { curZ, curY, curX, count + 1 });
      }
    }

    return Integer.MAX_VALUE;
  }

  static boolean isNotIn(int z, int y, int x) {
    return z < 0 || z >= 5 || y < 0 || y >= 5 || x < 0 || x >= 5;
  }

  static void print(int[][][] matrix) {
    for (int i = 0; i < 5; i++) {
      System.out.println("=============== i = " + i);
      for (int j = 0; j < 5; j++) {
        for (int k = 0; k < 5; k++) {
          System.out.print(matrix[i][j][k] + " ");
        }
        System.out.println("");
      }
    }
  }
}