import java.io.*;
import java.util.Stack;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Stack<Integer> stack = new Stack<>();
        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            String command = br.readLine();

            if (command.contains("push")) {
                stack.push(Integer.parseInt(command.split(" ")[1]));
            } else if (command.equals("pop")) {
                if (stack.isEmpty()) {
                    bw.write("-1\n");
                    continue;
                }
                bw.write(stack.pop() + "\n");
            } else if (command.equals("top")) {
                if (stack.isEmpty()) {
                    bw.write("-1\n");
                    continue;
                }

                bw.write(stack.lastElement() + "\n");
            } else if (command.equals("size")) {
                bw.write(stack.size() + "\n");
            } else if (command.equals("empty")) {
                if (stack.isEmpty()) {
                    bw.write("1\n");
                    continue;
                }
                bw.write("0\n");
            }
        }
        bw.close();
    }
}
