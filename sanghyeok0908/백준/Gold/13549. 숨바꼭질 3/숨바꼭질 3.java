import java.io.*;
import java.util.ArrayDeque;
import java.util.Queue;

public class Main {

    static int N, K;
    static int[] road = new int[110000];
    static boolean[] isVisited = new boolean[110000];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] s = br.readLine().split(" ");

        N = Integer.parseInt(s[0]);
        K = Integer.parseInt(s[1]);

        road[N] = 1;
        bfs();

//        for (int i = 0; i < K * 2; i++) bw.write(road[i] + " ");
//        bw.write("\n");
//        for (int i = 0; i < K * 2; i++) bw.write(i + " ");
//        bw.write("\n");

        int answer = road[K] - 1;
        if (answer == -1) bw.write("0\n");
        else bw.write(answer + "\n");
        bw.close();
    }

    static void bfs() {
        Queue<Integer> queue = new ArrayDeque<>();

        queue.add(N);
        isVisited[N] = true;

        while (!queue.isEmpty() && road[K] == 0) {
            int x = queue.poll();

            if (isMove(x * 2)) {
                road[x * 2] = road[x];
                isVisited[x * 2] = true;
                queue.add(x * 2);
            }
            if (isMove(x - 1)) {
                road[x - 1] = road[x] + 1;
                isVisited[x - 1] = true;
                queue.add(x - 1);
            }
            if (isMove(x + 1)) {
                road[x + 1] = road[x] + 1;
                isVisited[x + 1] = true;
                queue.add(x + 1);
            }
        }
    }

    static boolean isMove(int x) {
        return x >= 0 && x < road.length && !isVisited[x];
    }
}