import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N, M;
    static ArrayList<Integer>[] edges;
    static int[] degrees;
    static int[] result;

    public static void main(String[] args) throws Exception {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        edges = new ArrayList[N + 1];
        degrees = new int[N + 1];
        result = new int[N + 1];

        for (int i = 1; i < N + 1; i++) {
            edges[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            edges[from].add(to);
            degrees[to]++;
        }

        Queue<Integer> queue = new ArrayDeque<>();
        for (int i = 1; i <= N; i++) {
            if (degrees[i] == 0) {
                queue.add(i);
            }
        }

        for (int day = 1; !queue.isEmpty(); day++) {
            Queue<Integer> temp = new ArrayDeque<>();

            while (!queue.isEmpty()) {
                int from = queue.poll();
                ArrayList<Integer> edge = edges[from];

                result[from] = day;

                for (int i = 0; i < edge.size(); i++) {
                    Integer v = edge.get(i);

                    degrees[v]--;
                    if (degrees[v] == 0) {
                        temp.add(v);
                    }
                }
            }
            queue = temp;
        }

        for (int i = 1; i <= N; i++) {
            System.out.print(result[i] + " ");
        }
        System.out.println();
    }
}
