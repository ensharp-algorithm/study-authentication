import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Stack<Integer> stack = new Stack<>();
        LinkedList<Integer> array = new LinkedList<>();
        Queue<Character> answerList = new LinkedList<>();
        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            array.add(i + 1);
        }
        for (int i = 0; i < N; i++) {
            int inputNum = Integer.parseInt(br.readLine());

            if (stack.isEmpty() || stack.lastElement() < inputNum) {
                while (!array.isEmpty() && array.getFirst() <= inputNum) {
                    stack.push(array.pop());
                    answerList.add('+');
                }

                if (stack.isEmpty() || stack.lastElement() != inputNum) {
                    bw.write("NO\n");
                    bw.close();
                    return;
                }

                stack.pop();
                answerList.add('-');
            } else {
                while (!stack.isEmpty() && stack.lastElement() >= inputNum) {
                    stack.pop();
                    answerList.add('-');
                }
            }
        }

        while (!answerList.isEmpty()) {
            bw.write(answerList.remove() + "\n");
        }
        bw.close();
    }
}
