import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws Exception {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int Q = Integer.parseInt(st.nextToken());
        int[] ducks = new int[Q];
        int[] graph = new int[N + 1];
        StringBuilder answer = new StringBuilder();
        for (int i = 0; i < Q; i++) {
            ducks[i] = Integer.parseInt(br.readLine());
        }

        for (int i = 0; i < Q; i++) {
            // System.out.println("wanting ground = " + ducks[i]);

            int currentNode = 1;
            while (currentNode <= N) {
                // System.out.println("currentNode = " + currentNode);

                // 이미 막혔을 때
                if (graph[currentNode] == 1) {
                    answer.append(currentNode + "\n");
                    break;
                }

                // 원하는 땅에 도달했을 때
                if (ducks[i] == currentNode) {
                    answer.append("0\n");
                    graph[currentNode] = 1;
                    break;
                }

                int childNode = ducks[i];
                boolean isLeft = false;
                while (childNode > currentNode) {
                    if (childNode % 2 == 0) {
                        isLeft = true;
                        childNode /= 2;
                    } else {
                        isLeft = false;
                        childNode /= 2;
                    }
                }

                if (isLeft) {
                    currentNode *= 2;
                } else {
                    currentNode = currentNode * 2 + 1;
                }
            }
        }

        System.out.println(answer);
    }
}
