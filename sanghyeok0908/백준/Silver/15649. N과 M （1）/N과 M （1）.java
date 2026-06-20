import java.io.*;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int N, M;
    static int[] arr;
    static boolean[] isUsed;

    public static void main(String[] args) throws IOException {
        String[] s = br.readLine().split(" ");
        N = Integer.parseInt(s[0]);
        M = Integer.parseInt(s[1]);
        arr = new int[9];
        isUsed = new boolean[9];

        recursion(0);
        br.close();
        bw.close();
    }

    static void recursion(int k) throws IOException {
        if (k == M) {
            for (int i = 0; i < M; i++) bw.write(arr[i] + " ");
            bw.write("\n");
            return;
        }

        for(int i = 1; i <= N; i++) {
            if (isUsed[i]) continue;

            arr[k] = i;
            isUsed[i] = true;
            recursion(k + 1);
            isUsed[i] = false;
        }
    }
}