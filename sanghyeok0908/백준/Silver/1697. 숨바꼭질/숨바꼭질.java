import java.io.*;
import java.util.*;

public class Main {

    static int N, K;
    static int[] visited = new int[100001];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        Queue<Integer> queue = new ArrayDeque<>();
        String[] str = br.readLine().split(" ");
        N = Integer.parseInt(str[0]);
        K = Integer.parseInt(str[1]);

        queue.add(N);
        visited[N] = 1;

        while (!queue.isEmpty()) {
            int current = queue.poll();

            if (current == K) {
                bw.write((visited[current] - 1) + "\n");
                break;
            }
            if (current - 1 >= 0 && visited[current - 1] == 0) {
                visited[current - 1] = visited[current] + 1;
                queue.add(current - 1);
            }
            if (current + 1 < visited.length && visited[current + 1] == 0) {
                visited[current + 1] = visited[current] + 1;
                queue.add(current + 1);
            }
            if (current * 2 < visited.length && visited[current * 2] == 0) {
                visited[current * 2] = visited[current] + 1;
                queue.add(current * 2);
            }
        }
        bw.close();
    }
}