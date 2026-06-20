import java.io.*;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int count = 0;
        for(int i = 0; i < N; i++) {
            char[] commands = br.readLine().toCharArray();
            Stack<Character> stack = new Stack<>();

            for(char c : commands) {
                if (stack.isEmpty() || stack.peek() != c) {
                    stack.push(c);
                    continue;
                }

                if (stack.peek() == c) {
                    stack.pop();
                }
            }

            if (stack.isEmpty()) {
                count++;
            }
        }

        bw.write(count + "\n");
        bw.close();
    }
}