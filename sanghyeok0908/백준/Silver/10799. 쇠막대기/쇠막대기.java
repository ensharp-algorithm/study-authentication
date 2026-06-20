import java.io.*;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        char[] str = br.readLine().toCharArray();
        Stack<Character> stack = new Stack<>();
        int answer = 0;

        for (int i = 0; i < str.length; i++) {
            if (str[i] == '(') {
                if (i + 1 < str.length && str[i + 1] == ')') {
                    // 레이저일 때
                    answer += stack.size();
                    i++;
                } else {
                    // 쇠 막대기 첫 부분일 때
                    stack.push(str[i]);
                }
            } else {
                // 쇠 막대기 끝 부분일 때
                stack.pop();
                answer++;
            }
        }
        answer += stack.size();

        bw.write(answer + "\n");
        bw.close();
    }
}