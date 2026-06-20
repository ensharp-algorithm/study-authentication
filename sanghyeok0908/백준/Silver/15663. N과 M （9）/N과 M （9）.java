import java.io.*;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int N, M;
    static int[] arr;
    static int[] inputs;
    static boolean[] isVisited;

    public static void main(String[] args) throws IOException {
        String[] s = br.readLine().split(" ");
        inputs = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        N = Integer.parseInt(s[0]);
        M = Integer.parseInt(s[1]);
        arr = new int[M];
        isVisited = new boolean[N];

        Arrays.sort(inputs);
        recursion(0);
        br.close();
        bw.close();
    }

    static void recursion(int depth) throws IOException {
        if (depth == M) {
            for(int i = 0; i < M; i++) {
                bw.write(arr[i] + " ");
            }
            bw.write("\n");
            return;
        }

        int temp = 0;

        for (int i = 0; i < N; i++) {
            if (isVisited[i] || temp == inputs[i]) continue;

            temp = inputs[i];
            isVisited[i] = true;
            arr[depth] = inputs[i];
            recursion(depth + 1);
            isVisited[i] = false;
        }
    }
}