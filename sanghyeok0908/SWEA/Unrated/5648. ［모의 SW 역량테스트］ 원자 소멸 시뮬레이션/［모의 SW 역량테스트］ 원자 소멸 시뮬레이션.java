
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N;
    static List<int[]> elements = new ArrayList<>();
    static int[][] map = new int[4002][4002];

    public static void main(String[] args) throws Exception {
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int t = 1; t <= T; t++) {
            N = Integer.parseInt(br.readLine());
            elements.clear();

            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int[] temp = new int[4];

                for (int j = 0; j < 4; j++) {
                    temp[j] = Integer.parseInt(st.nextToken());
                }
                elements.add(temp);
            }

            for (int[] e : elements) {
                int temp = e[0];
                e[0] = e[1];
                e[1] = temp;

                e[0] = (e[0] + 1000) * 2;
                e[1] = (e[1] + 1000) * 2;
            }

            // System.out.println("============");
            // for (int[] e : elements) {
            //     System.out.printf("%d %d %d %d\n",
            //             e[0], e[1], e[2], e[3]);
            // }
            // System.out.println("============");

            int answer = solution();
            sb.append("#" + t + " " + answer + "\n");
        }

        System.out.println(sb);
    }

    static int solution() {
        int result = 0;

        while (!elements.isEmpty()) {
            List<int[]> visitedPos = new ArrayList<>();

            for (int i = elements.size() - 1; i >= 0; i--) {
                int[] e = elements.get(i);
                int[] next = move(e);
                e[0] = next[0];
                e[1] = next[1];

                if (isOut(e[0], e[1])) {
                    elements.remove(i);
                } else {
                    map[e[0]][e[1]] += e[3];
                    visitedPos.add(new int[] { e[0], e[1] });
                }
            }

            for (int i = elements.size() - 1; i >= 0; i--) {
                int[] e = elements.get(i);

                if (map[e[0]][e[1]] != e[3]) {
                    result += e[3];
                    elements.remove(i);
                }
            }

            for (int[] pos : visitedPos) {
                map[pos[0]][pos[1]] = 0;
            }
        }

        return result;
    }

    static int[] move(int[] element) {
        int y = element[0];
        int x = element[1];
        switch (element[2]) {
            case 0:
                y++;
                break;
            case 1:
                y--;
                break;
            case 2:
                x--;
                break;
            case 3:
                x++;
                break;
        }
        return new int[] { y, x };
    }

    static boolean isOut(int y, int x) {
        return y < 0 || y > 4001 || x < 0 || x > 4001;
    }
}
