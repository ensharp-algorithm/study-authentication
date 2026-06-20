import java.io.*;
import java.util.Arrays;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int N, M;
    static int[] answer;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        String[] s = br.readLine().split(" ");
        arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        N = Integer.parseInt(s[0]);
        M = Integer.parseInt(s[1]);
        answer = new int[M];

        Arrays.sort(arr);
        recursion(0, 0);
        br.close();
        bw.close();
    }

    static void recursion(int depth, int startIdx) throws IOException {
        if (depth == M) {
            for(int i : answer) {
                bw.write(i + " ");
            }
            bw.write("\n");
            return;
        }

        for(int i = startIdx; i < N; i++) {
            answer[depth] = arr[i];
            recursion(depth + 1, i);
        }
    }
}