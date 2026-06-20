import java.io.*;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Stack<Character> stack = new Stack<>();
        char[] str = br.readLine().toCharArray();
        int answer = 0, number = 1;

        for (int i = 0; i < str.length; i++) {
            //==== 열린괄호일 때 ====//
            if (str[i] == '(') {
                stack.push('(');
                number *= 2;
                continue;
            } else if (str[i] == '[') {
                stack.push('[');
                number *= 3;
                continue;
            }

            //==== 닫힌 괄호일 때 ====//
            if (stack.empty() || (stack.peek() != '(' && str[i] == ')') || stack.peek() != '[' && str[i] == ']') {
                bw.write("0\n");
                bw.close();
                return;
            }

            if (str[i] == ')') {
                if (str[i - 1] == '(') answer += number;
                stack.pop();
                number /= 2;
            } else {
                if (str[i - 1] == '[') answer += number;
                stack.pop();
                number /= 3;
            }
        }

        if (stack.isEmpty()) bw.write(answer + "\n");
        else bw.write("0\n");
        bw.close();
    }
}