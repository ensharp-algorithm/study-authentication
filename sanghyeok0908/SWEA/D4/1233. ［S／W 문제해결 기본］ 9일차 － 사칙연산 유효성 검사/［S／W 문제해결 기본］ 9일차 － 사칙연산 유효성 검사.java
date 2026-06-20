import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws Exception {
        int[] answer = new int[10];

        for (int i = 0; i < 10; i++) {
            answer[i] = 1;
        }

        for (int t = 1; t <= 10; t++) {
            int N = Integer.parseInt(br.readLine());

            for (int i = 0; i < N; i++) {
                String[] input = br.readLine().split(" ");
                char node = input[1].charAt(0);
                
                // 자식이 있는데, 숫자일 때
                if (Character.isDigit(node) && input.length > 2) {
                    answer[t - 1] = 0;
                }

                // 자식이 없는데, 연산기호일 때
                if (!Character.isDigit(node) && input.length < 2) {
                    answer[t - 1] = 0;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 10; i++) {
            sb.append("#" + (i + 1) + " " + answer[i] + "\n");
        }
        System.out.println(sb);
    }
}