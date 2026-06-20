import java.io.*;
import java.util.*;

public class Main {
    static int[][] graph;
    static int n, m;
    static boolean[][] isVisited;
    static int dfsCount;
    static int[][] position = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};


    static int bfs(int x, int y) {
        int result = 1;
        Queue<int[]> queue = new LinkedList<>();

        queue.add(new int[]{x, y});
        isVisited[x][y] = true;

        while (!queue.isEmpty()) {
            int[] poll = queue.poll();

            for (int[] pos : position) {
                int currentX = poll[0] + pos[0];
                int currentY = poll[1] + pos[1];

                if (currentX >= n || currentY >= m || currentX < 0 || currentY < 0) continue;

                if (graph[currentX][currentY] == 1 && !isVisited[currentX][currentY]) {
                    result++;
                    isVisited[currentX][currentY] = true;
                    queue.add(new int[]{currentX, currentY});
                }
            }
        }
        return result;
    }

    static void dfs(int x, int y) {
        isVisited[x][y] = true;
        dfsCount++;

        for (int[] pos : position) {
            int currentX = x + pos[0];
            int currentY = y + pos[1];

            if (currentX >= n || currentY >= m || currentX < 0 || currentY < 0) continue;

            if (graph[currentX][currentY] == 1 && !isVisited[currentX][currentY]) dfs(currentX, currentY);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");
        List<Integer> answer = new ArrayList<>();

        n = Integer.parseInt(input[0]);
        m = Integer.parseInt(input[1]);
        graph = new int[n][m];
        isVisited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            graph[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        // bfs
//        for (int i = 0; i < n; i++) {
//            for (int j = 0; j < m; j++) {
//                if (!isVisited[i][j] && graph[i][j] == 1) {
//                    answer.add(bfs(i, j));
//                }
//            }
//        }

        // dfs
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                dfsCount = 0;
                if (!isVisited[i][j] && graph[i][j] == 1) {
                    dfs(i, j);
                    answer.add(dfsCount);
                }
            }
        }

        if (answer.isEmpty()) {
            bw.write("0\n0\n");
            bw.close();
            return;
        }

        Collections.sort(answer);
        bw.write(answer.size() + "\n" + answer.get(answer.size() - 1) + "\n");
        bw.close();
    }
}