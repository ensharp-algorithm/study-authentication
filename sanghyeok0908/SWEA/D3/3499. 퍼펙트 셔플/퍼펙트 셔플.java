import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

class Solution
{
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String args[]) throws Exception
	{
int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int t = 1; t <= T; t++) {
            int N = Integer.parseInt(br.readLine());
            String[] cards = br.readLine().split(" ");
            Stack<String> left = new Stack<>();
            Stack<String> right = new Stack<>();
            int middleIdx = cards.length % 2 == 0 ? cards.length / 2 - 1 : cards.length / 2;

            for (int i = middleIdx; i >= 0; i--) {
                left.add(cards[i]);
            }

            for (int i = N - 1; i > middleIdx; i--) {
                right.add(cards[i]);
            }

            sb.append("#" + t + " ");

            while (!left.isEmpty()) {
                sb.append(left.pop() + " ");

                if (!right.isEmpty())
                    sb.append(right.pop() + " ");
            }
            sb.append('\n');
        }

        System.out.println(sb);
	}
}