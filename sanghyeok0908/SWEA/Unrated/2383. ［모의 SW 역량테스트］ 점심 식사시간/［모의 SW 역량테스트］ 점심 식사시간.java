import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N;
    static int[][] matrix;
    static List<int[]> people;
    static List<Integer>[][] distances;
    static int[][] stairs;
    static int[] willGoStep; // step1, step2
    static int answer;

    public static void main(String[] args) throws Exception {
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int t = 1; t <= T; t++) {
            int stepIdx = 0;
            N = Integer.parseInt(br.readLine());
            stairs = new int[2][2];
            matrix = new int[N][N];
            distances = new ArrayList[2][30];
            people = new ArrayList<>();
            answer = Integer.MAX_VALUE;

            for (int j = 0; j < 2; j++) {
                for (int i = 0; i < 30; i++) {
                    distances[j][i] = new ArrayList<>();
                }
            }

            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    matrix[i][j] = Integer.parseInt(st.nextToken());
                    if (matrix[i][j] > 1) {
                        stairs[stepIdx][0] = i;
                        stairs[stepIdx++][1] = j;
                    } else if (matrix[i][j] == 1) {
                        people.add(new int[] { i, j });
                    }
                }
            }

            for (int i = 0; i < people.size(); i++) {
                int[] pos = people.get(i);
                int time1 = Math.abs(stairs[0][0] - pos[0]) + Math.abs(stairs[0][1] - pos[1]);
                int time2 = Math.abs(stairs[1][0] - pos[0]) + Math.abs(stairs[1][1] - pos[1]);
                distances[0][time1].add(i);
                distances[1][time2].add(i);
            }

            willGoStep = new int[people.size()];
            dfs(0);
            sb.append("#" + t + " " + answer + "\n");

            // for (int i = 0; i < 20; i++) {
            // System.out.println("time = " + i);
            // for (Integer j : distances[0][i]) {
            // System.out.print(j + " ");
            // }
            // System.out.println();
            // }
            // System.out.println("=============");
            // for (int i = 0; i < 20; i++) {
            // System.out.println("time = " + i);
            // for (Integer j : distances[1][i]) {
            // System.out.print(j + " ");
            // }
            // System.out.println();
            // }
            // System.out.println("=============");

            // for (int i = 0; i < people.size(); i++) {
            // System.out.print(willGoStep[i] + " ");
            // }
            // System.out.println();

            // play();
        }
        System.out.println(sb);
    }

    static void dfs(int depth) {
        if (depth == people.size()) {
            // System.out.println("print combination ==============");
            // for (int i = 0; i < people.size(); i++) {
            // System.out.print(willGoStep[i] + " ");
            // }
            // System.out.println();

            int result = play();
            answer = Math.min(answer, result);
            return;
        }

        willGoStep[depth] = 1;
        dfs(depth + 1);
        willGoStep[depth] = 0;
        dfs(depth + 1);
    }

    static int play() {
        int time = 0;
        int count = 0;
        Map<Integer, Integer>[] map = new HashMap[2];
        Queue<Integer> waitQ[] = new ArrayDeque[2];
        boolean[] isWalking = new boolean[people.size()];

        map[0] = new HashMap<>();
        map[1] = new HashMap<>();
        waitQ[0] = new ArrayDeque<>();
        waitQ[1] = new ArrayDeque<>();

        while (count < people.size()) {
            time++;

            // System.out.println("==================");
            // System.out.println("time = " + time);

            for (int i = 0; i < 2; i++) {
                List<Integer> popList = new ArrayList<>();
                int stairsNum = matrix[stairs[i][0]][stairs[i][1]];

                for (Integer key : map[i].keySet()) {
                    Integer t = map[i].get(key);
                    t++;

                    if (stairsNum < t) {
                        popList.add(key);
                    }

                    map[i].put(key, t);
                }

                for (Integer pop : popList) {
                    map[i].remove(pop);
                    count++;
                }
            }

            if (time < 30) {
                for (int i = 0; i < 2; i++) {
                    for (Integer human : distances[i][time]) {
                        if (isWalking[human]) {
                            continue;
                        }

                        if (i == willGoStep[human]) {
                            waitQ[i].add(human);
                        }
                    }
                }
            }

            for (int i = 0; i < 2; i++) {
                while (!waitQ[i].isEmpty() && map[i].size() < 3) {
                    Integer human = waitQ[i].poll();

                    map[i].put(human, 1);
                    isWalking[human] = true;
                }
            }

            // for (int i = 0; i < 2; i++) {
            // System.out.println("i = " + i);
            // System.out.println("print stair info");
            // for (Integer key : map[i].keySet()) {
            // System.out.println(key + " " + map[i].get(key));
            // }

            // System.out.println("print waitQ");
            // for (Integer q : waitQ[i]) {
            // System.out.print(q + " ");
            // }
            // System.out.println();
            // }
        }

        return time + 1;
    }
}