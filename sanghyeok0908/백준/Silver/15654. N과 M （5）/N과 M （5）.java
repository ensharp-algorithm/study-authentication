import java.io.*;
import java.util.Arrays;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int N, M;
    static int[] answer;
    static int[] arr;
    static boolean[] isVisited;

    public static void main(String[] args) throws IOException {
        String[] s = br.readLine().split(" ");
        arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        N = Integer.parseInt(s[0]);
        M = Integer.parseInt(s[1]);
        answer = new int[M];
        isVisited = new boolean[N];

        Arrays.sort(arr);
        recursion(0);
        br.close();
        bw.close();
    }

    static void recursion(int depth) throws IOException {
        if (depth == M) {
            for(int i : answer) {
                bw.write(i + " ");
            }
            bw.write("\n");
            return;
        }

        for(int i = 0; i < N; i++) {
            if (isVisited[i]) continue;

            answer[depth] = arr[i];
            isVisited[i] = true;
            recursion(depth + 1);
            isVisited[i] = false;
        }
    }
}