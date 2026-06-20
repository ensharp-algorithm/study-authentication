import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        int[][] direction = new int[][]{{1, 2}, {-1, 2}, {1, -2}, {-1, -2}, {2, 1}, {2, -1}, {-2, 1}, {-2, -1}};

        for(int i = 0; i < T; i++) {
            int I = Integer.parseInt(br.readLine());
            int[][] graph = new int[I][I];
            boolean[][] isVisited = new boolean[I][I];
            int[] first = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int[] target = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            Queue<int[]> queue = new ArrayDeque<>();

            queue.add(new int[]{first[1], first[0]});
            isVisited[first[1]][first[0]] = true;

            while(!queue.isEmpty()) {
                int[] poll = queue.poll();
                boolean isBreak = false;

                for(int[] d : direction) {
                    int curX = poll[1] + d[1];
                    int curY = poll[0] + d[0];

                    if (curX < 0 || curX >= I || curY < 0 || curY >= I || isVisited[curY][curX]) continue;

                    isVisited[curY][curX] = true;
                    queue.add(new int[]{curY, curX});
                    graph[curY][curX] = graph[poll[0]][poll[1]] + 1;

                    if (target[0] == curX && target[1] == curY) {
                        isBreak = true;
                        break;
                    }
                }

                if (isBreak) break;
            }

            bw.write(graph[target[1]][target[0]] + "\n");
        }
        bw.close();
    }
}