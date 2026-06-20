import java.io.*;
import java.util.*;

public class Main {

  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  static int N, L, R;
  static int[][] matrix;
  static int[][] area;
  static boolean[][] isVisited;
  static int[] dy = new int[] { -1, 1, 0, 0 };
  static int[] dx = new int[] { 0, 0, -1, 1 };
  static int areaIdx = 0;
  static Map<Integer, Integer> map = new HashMap<>();
  static Map<Integer, Integer> cntMap = new HashMap<>();

  public static void main(String[] args) throws Exception {
    StringTokenizer st = new StringTokenizer(br.readLine());
    int answer = 0;

    N = Integer.parseInt(st.nextToken());
    L = Integer.parseInt(st.nextToken());
    R = Integer.parseInt(st.nextToken());
    matrix = new int[N][N];

    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine());

      for (int j = 0; j < N; j++) {
        matrix[i][j] = Integer.parseInt(st.nextToken());
      }
    }

    while (true) {
      map = new HashMap<>();
      cntMap = new HashMap<>();
      isVisited = new boolean[N][N];
      area = new int[N][N];
      areaIdx = 0;

      for (int i = 0; i < N; i++) {
        for (int j = 0; j < N; j++) {
          if (!isVisited[i][j]) {
            areaIdx++;
            setArea(i, j);
          }
        }
      }

      if (areaIdx == N * N)
        break;

      for (int i = 0; i < N; i++) {
        for (int j = 0; j < N; j++) {
          matrix[i][j] = map.get(area[i][j]) / cntMap.get(area[i][j]);
        }
      }
      answer++;
    }

    System.out.println(answer);
  }

  static void setArea(int y, int x) {
    Queue<int[]> queue = new ArrayDeque<>();

    queue.add(new int[] { y, x });
    isVisited[y][x] = true;
    area[y][x] = areaIdx;

    map.put(areaIdx, matrix[y][x]);
    cntMap.put(areaIdx, 1);

    while (!queue.isEmpty()) {
      int[] poll = queue.poll();

      for (int i = 0; i < 4; i++) {
        int curY = poll[0] + dy[i];
        int curX = poll[1] + dx[i];

        if (curY < 0 || curY >= N || curX < 0 || curX >= N || isVisited[curY][curX])
          continue;

        int del = Math.abs(matrix[curY][curX] - matrix[poll[0]][poll[1]]);

        if (L <= del && del <= R) {
          isVisited[curY][curX] = true;
          area[curY][curX] = areaIdx;
          queue.add(new int[] { curY, curX });

          map.put(areaIdx, map.get(areaIdx) + matrix[curY][curX]);
          cntMap.put(areaIdx, cntMap.get(areaIdx) + 1);
        }
      }
    }
  }
}