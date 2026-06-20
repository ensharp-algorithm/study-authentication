import java.io.*;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int N, M;
    static int[] arr;
    static int[] inputs;

    public static void main(String[] args) throws IOException {
        String[] s = br.readLine().split(" ");
        inputs = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        N = Integer.parseInt(s[0]);
        M = Integer.parseInt(s[1]);
        arr = new int[M];

        Arrays.sort(inputs);
        recursion(0, 0);
        br.close();
        bw.close();
    }

    static void recursion(int depth, int startIdx) throws IOException {
        if (depth == M) {
            for(int i = 0; i < M; i++) {
                bw.write(arr[i] + " ");
            }
            bw.write("\n");
            return;
        }

        int temp = 0;

        for (int i = startIdx; i < N; i++) {
            if (temp == inputs[i]) continue;

            temp = inputs[i];
            arr[depth] = inputs[i];
            recursion(depth + 1, i + 1);
        }
    }
}