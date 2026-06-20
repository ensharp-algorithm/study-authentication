import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Stack<int[]> stack = new Stack<>();
        List<Integer> list = new ArrayList<>();

        int N = Integer.parseInt(br.readLine());
        String[] input = br.readLine().split(" ");

        for (int i = 0; i < N; i++) {
            list.add(Integer.parseInt(input[i]));
        }

        for (int i = 0; i < N; i++) {
            int num = list.get(i);

            if (stack.isEmpty()) {
                bw.write("0 ");
            } else if (stack.lastElement()[1] < num) {
                while(!stack.isEmpty()) {
                    stack.pop();

                    if (stack.isEmpty()) {
                        bw.write("0 ");
                        break;
                    }

                    int[] stackNum = stack.lastElement();

                    if (stackNum[1] >= num) {
                        bw.write((stackNum[0] + 1) + " ");
                        break;
                    }
                }
            } else {
                bw.write((stack.lastElement()[0] + 1) + " ");
            }

            stack.push(new int[]{i, num});
        }

        bw.write("\n");
        bw.close();
    }
}