import java.io.*;
import java.util.Deque;
import java.util.LinkedList;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            String inputCommand = br.readLine();
            char[] commands = inputCommand.toCharArray();
            int N = Integer.parseInt(br.readLine());
            String inputNums = br.readLine().replace("[", "").replace("]", "");
            Deque<Integer> deque = new LinkedList<>();
            int[] arr = new int[0];
            boolean isReverse = false;
            boolean isError = false;

            if (N == 0) {
                if (inputCommand.contains("D")) {
                    isError = true;
                }
            } else {
                if (N == 1) {
                    arr = new int[]{Integer.parseInt(inputNums)};
                } else {
                    arr = Stream.of(inputNums.split(",")).mapToInt(Integer::parseInt).toArray();
                }
            }

            for (int num : arr) {
                deque.addLast(num);
            }
            
            for (char c : commands) {
                if (c == 'R') {
                    isReverse = !isReverse;
                    continue;
                }

                if (deque.isEmpty()) {
                    isError = true;
                    break;
                }

                if (isReverse) {
                    deque.pollLast();
                } else {
                    deque.pollFirst();
                }
            }

            if (isError) {
                bw.write("error\n");
                continue;
            }

            bw.write("[");
            while (deque.size() > 1) {
                if (isReverse) {
                    bw.write(deque.pollLast() + ",");
                } else {
                    bw.write(deque.pollFirst() + ",");
                }
            }

            if (deque.size() == 1)
                bw.write(deque.pop() + "]\n");
            else
                bw.write("]\n");
        }

        bw.close();
    }
}