import java.io.*;
import java.util.Arrays;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());
        int[] inputArr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] arr = new int[N];
        Deque<Integer> deque = new ArrayDeque<>();

        for (int i = 0; i < N; i++) {
            arr[i] = inputArr[i] - (N - 1 - i);
        }

        for (int i = 0; i < N; i++) {
            if (arr[N - 1 - i] < 0) {
                Stack<Integer> temp = new Stack<>();

                while (!deque.isEmpty() && arr[N - 1 - i] < 0) {
                    arr[N - 1 - i]++;
                    temp.add(deque.pollLast());
                }

                deque.addLast(N - i);

                while (!temp.isEmpty()) {
                    deque.addLast(temp.pop());
                }

            } else {
                deque.addLast(N - i);
            }
        }

        while (!deque.isEmpty()) {
            bw.write(deque.pollFirst() + " ");
        }
        bw.write("\n");
        br.close();
        bw.close();
    }
}