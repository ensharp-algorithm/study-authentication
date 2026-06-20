import java.io.*;
import java.util.*;

public class Main {

    static int K, W, H;
    static int[][] graph;
    static boolean[][][] isVisited;
    static Queue<Node> queue = new ArrayDeque<>();

    static class Node {
        int x, y;
        int count;
        int k;

        Node(int y, int x, int count, int k) {
            this.x = x;
            this.y = y;
            this.count = count;
            this.k = k;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        K = Integer.parseInt(br.readLine());
        String[] s = br.readLine().split(" ");
        W = Integer.parseInt(s[0]);
        H = Integer.parseInt(s[1]);
        graph = new int[H][W];
        isVisited = new boolean[H][W][K + 1];

        for (int i = 0; i < H; i++) {
            graph[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        bw.write(bfs() + "\n");
        bw.close();
    }

    static int bfs() {
        int[] horseDx = new int[]{-2, -2, 2, 2, -1, -1, 1, 1};
        int[] horseDy = new int[]{-1, 1, -1, 1, -2, 2, -2, 2};
        int[] monkeyDx = new int[]{-1, 1, 0, 0};
        int[] monkeyDy = new int[]{0, 0, -1, 1};

        queue.add(new Node(0, 0, 0, K));
        isVisited[0][0][K] = true;

        while (!queue.isEmpty()) {
            Node node = queue.poll();

            if (node.y == H - 1 && node.x == W - 1) return node.count;

            move(monkeyDy, monkeyDx, node);
            if (node.k <= 0) continue;
            move(horseDy, horseDx, node);
        }
        return -1;
    }

    static void move(int[] dy, int[] dx, Node node) {
        for (int i = 0; i < dy.length; i++) {
            // horse move일 때 curK = K - 1, monkey move일 때 curK = K
            int curK = dy.length == 8 ? node.k - 1 : node.k;
            int curY = node.y + dy[i];
            int curX = node.x + dx[i];

            if (curY < 0 || curX < 0 || curY >= H || curX >= W || graph[curY][curX] == 1
                    || isVisited[curY][curX][curK])
                continue;

            queue.add(new Node(curY, curX, node.count + 1, curK));
            isVisited[curY][curX][curK] = true;
        }
    }
}