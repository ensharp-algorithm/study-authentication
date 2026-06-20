import java.io.*;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        while (true) {
            String answer = "yes";
            char[] inputStr = br.readLine().toCharArray();
            Stack<Character> stack = new Stack<>();

            if (inputStr.length == 1 && inputStr[0] == '.') break;

            for (char s : inputStr) {
                if (s == '(' || s == '[') {
                    stack.push(s);
                    continue;
                }

                if (s == ')' || s == ']') {
                    if (!stack.isEmpty()) {
                        if ((s == ')' && stack.peek() == '(') || (s == ']' && stack.peek() == '[')) {
                            stack.pop();
                            continue;
                        }
                    }

                    answer = "no";
                    break;
                }
            }

            if (!stack.isEmpty()) {
                answer = "no";
            }

            bw.write(answer + "\n");
        }

        bw.close();
    }
}