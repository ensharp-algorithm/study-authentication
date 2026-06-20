
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {

    static public class Position {
        public int y, x;

        public Position(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N, M, C;
    static int[][] matrix;
    static List<Position> positions = new ArrayList<>();
    static Position[] arr;
    static int[] honeys;
    static int maxOfHoney, result;

    public static void main(String[] args) throws Exception {
        int T = Integer.parseInt(br.readLine());
        StringBuilder answer = new StringBuilder();
        for (int t = 1; t <= T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            C = Integer.parseInt(st.nextToken());
            matrix = new int[N][N];
            positions.clear();
            arr = new Position[2];
            result = 0;

            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    matrix[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            for (int i = 0; i < N; i++) {
                for (int j = 0; j + M <= N; j++) {
                    positions.add(new Position(i, j));
                }
            }

            bruthForce(0, 0);
            answer.append("#" + t + " " + result + "\n");
        }
        System.out.println(answer);
    }

    static void bruthForce(int depth, int start) {
        if (depth == 2) {
            // 겹친다면 return
            if (arr[0].y == arr[1].y && arr[0].x + M > arr[1].x) {
                return;
            }

            maxOfHoney = 0;
            for (int i = 1; i <= M; i++) {
                honeys = new int[i];
                setMaxOfHoney(0, i, arr[0].x, arr[0]);
            }

            int first = maxOfHoney;
            maxOfHoney = 0;

            for (int i = 1; i <= M; i++) {
                honeys = new int[i];
                setMaxOfHoney(0, i, arr[1].x, arr[1]);
            }
            result = Math.max(result, first + maxOfHoney);
            return;
        }

        for (int i = start; i < positions.size(); i++) {
            Position temp = positions.get(i);
            arr[depth] = new Position(temp.y, temp.x);
            bruthForce(depth + 1, i + 1);
        }
    }

    static void setMaxOfHoney(int depth, int maxOfDepth, int start, Position pos) {
        if (depth == maxOfDepth) {
            int sum = 0, temp = 0;
            for (int i = 0; i < depth; i++) {
                sum += honeys[i];
                temp += honeys[i] * honeys[i];
            }

            if (sum <= C) {
                maxOfHoney = Math.max(maxOfHoney, temp);
            }
            return;
        }

        for (int i = start; i < pos.x + M; i++) {
            honeys[depth] = matrix[pos.y][i];
            setMaxOfHoney(depth + 1, maxOfDepth, i + 1, pos);
        }
    }
}
