import java.io.*;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        int answer = -1;

        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(arr);

        for(int i = 0; i < N - 2; i++) {
            if (arr[N - 1 - i] < arr[N - 2 - i] + arr[N - 3 - i]) {
                answer = arr[N - 1 - i] + arr[N - 2 - i] + arr[N - 3 - i];
                break;
            }
        }

        bw.write(answer + "\n");
        br.close();
        bw.close();
    }
}