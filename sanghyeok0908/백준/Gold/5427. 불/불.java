import java.io.*;
import java.util.*;

public class Main {

    static int[] dx = new int[]{-1, 1, 0, 0};
    static int[] dy = new int[]{0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            String[] str = br.readLine().split(" ");
            int w = Integer.parseInt(str[0]);
            int h = Integer.parseInt(str[1]);
            char[][] graph = new char[h][w];
            Queue<int[]> humanQueue = new ArrayDeque<>();
            Queue<int[]> fireQueue = new ArrayDeque<>();
            boolean isPossible = false;
            int count = 0;

            for (int j = 0; j < h; j++) {
                graph[j] = br.readLine().toCharArray();

                for (int k = 0; k < w; k++) {
                    if (graph[j][k] == '@') {
                        humanQueue.add(new int[]{j, k});
                    } else if (graph[j][k] == '*') {
                        fireQueue.add(new int[]{j, k});
                    }
                }
            }

            while (!humanQueue.isEmpty() && !isPossible) {
                count++;
                bfs(graph, fireQueue, true);
                isPossible = bfs(graph, humanQueue, false);
            }

//            for(int j = 0; j < h; j++) {
//                for(int k = 0; k < w; k++) {
//                    bw.write(graph[j][k] + " ");
//                }
//                bw.write("\n");
//            }

            if (isPossible) bw.write(count + "\n");
            else bw.write("IMPOSSIBLE\n");
        }
        bw.close();
    }

    static boolean bfs(char[][] graph, Queue<int[]> queue, boolean isFire) {
        int size = queue.size();

        for (int i = 0; i < size; i++) {
            int[] poll = queue.poll();

            for (int j = 0; j < 4; j++) {
                int curX = poll[1] + dx[j];
                int curY = poll[0] + dy[j];

                if (isFire) {
                    if (curX < 0 || curY < 0 || curX >= graph[0].length || curY >= graph.length) continue;

                    if (graph[curY][curX] == '.' || graph[curY][curX] == '@') {
                        graph[curY][curX] = '*';
                        queue.add(new int[]{curY, curX});
                    }
                } else {
                    if (curX < 0 || curY < 0 || curX >= graph[0].length || curY >= graph.length) {
                        return true;
                    }

                    if (graph[curY][curX] == '.') {
                        graph[curY][curX] = '@';
                        queue.add(new int[]{curY, curX});
                    }
                }
            }
        }

//        for (int j = 0; j < graph.length; j++) {
//            for (int k = 0; k < graph[0].length; k++) {
//                System.out.print(graph[j][k] + " ");
//            }
//            System.out.println();
//        }
//        System.out.println("============");
        return false;
    }
}