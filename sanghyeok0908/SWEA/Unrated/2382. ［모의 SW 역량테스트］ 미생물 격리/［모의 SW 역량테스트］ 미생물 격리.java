

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {

  static class Node {

    public int y, x;
    public int num, dy, dx;

    public Node(int y, int x, int num, int d) {
      this.y = y;
      this.x = x;
      this.num = num;

      switch (d) {
        case 1:
          dy = -1;
          break;
        case 2:
          dy = 1;
          break;
        case 3:
          dx = -1;
          break;
        case 4:
          dx = 1;
          break;
      }
    }
  }

  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  static int N, M, K;
  static Node[] nodes;

  public static void main(String[] args) throws Exception {
    int T = Integer.parseInt(br.readLine());
    StringBuilder sb = new StringBuilder();
    for (int t = 1; t <= T; t++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      N = Integer.parseInt(st.nextToken());
      M = Integer.parseInt(st.nextToken());
      K = Integer.parseInt(st.nextToken());
      nodes = new Node[K + 1];

      for (int i = 1; i <= K; i++) {
        st = new StringTokenizer(br.readLine());
        int y = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());
        int num = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        nodes[i] = new Node(y, x, num, d);
      }

      for (int i = 0; i < M; i++) {
        moveAndAdd();
      }

      int answer = 0;
      for (int i = 1; i <= K; i++) {
        answer += nodes[i].num;
      }

      sb.append("#")
          .append(t)
          .append(" ")
          .append(answer)
          .append("\n");
    }
    System.out.println(sb);
  }

  static void moveAndAdd() {
    // {idx, num}
    int[][][] original = new int[N][N][2];

    for (int i = 1; i <= K; i++) {
      int nextY = nodes[i].y += nodes[i].dy;
      int nextX = nodes[i].x += nodes[i].dx;

      if (isEdge(nextY, nextX)) {
        nodes[i].num /= 2;
        nodes[i].dy *= -1;
        nodes[i].dx *= -1;
      }

      if (nodes[i].num == 0) {
        continue;
      }

      if (original[nextY][nextX][0] == 0) {
        original[nextY][nextX][0] = i;
        original[nextY][nextX][1] = nodes[i].num;
      } else if (original[nextY][nextX][1] < nodes[i].num) {
        int prevIdx = original[nextY][nextX][0];

        original[nextY][nextX][0] = i;
        original[nextY][nextX][1] = nodes[i].num;

        nodes[i].num += nodes[prevIdx].num;
        nodes[prevIdx].num = 0;
      } else {
        nodes[original[nextY][nextX][0]].num += nodes[i].num;
        nodes[i].num = 0;
      }
    }
  }

  static boolean isEdge(int y, int x) {
    return y == 0 || y == N - 1 || x == 0 || x == N - 1;
  }

  static void printNode() {
    for (int i = 1; i <= K; i++) {
      System.out.printf("y = %d, x = %d, num = %d dy = %d, dx = %d\n",
          nodes[i].y, nodes[i].x, nodes[i].num, nodes[i].dy, nodes[i].dx);
    }
  }
}
