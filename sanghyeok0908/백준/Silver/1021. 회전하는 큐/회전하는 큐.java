import java.io.*;
import java.util.*;

class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] inputs = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int N = inputs[0];
        int M = inputs[1];
        int[] nums = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        Deque<Integer> queue = new ArrayDeque<>();
        int result = 0;

        for (int i = 0; i < N; i++) {
            queue.addLast(i + 1);
        }

        for (int i : nums) {
            int idx = 0;
            for (Integer j : queue) {
                if (i == j) break;
                idx++;
            }

//            for (Integer j : queue)
//                System.out.print(j + " ");
//            System.out.println();

            if (idx <= queue.size() / 2) {
                while(i != queue.peekFirst()) {
                    queue.add(queue.pollFirst());
                    result++;
                }
            } else {
                while(i != queue.peekFirst()) {
                    queue.addFirst(queue.pollLast());
                    result++;
                }
            }
//            System.out.println("result = " + result);
            queue.pollFirst();
        }

//        for (Integer j : queue)
//            System.out.print(j + " ");
//        System.out.println();

        System.out.println(result);
        br.close();
    }
}