import java.io.*;
import java.util.*;

public class Main {

    static int[] students;
    static boolean[] isCycle;
    static boolean[] isVisited;
    static int cycleCount;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            int N = Integer.parseInt(br.readLine());

            cycleCount = 0;
            isCycle = new boolean[N];
            isVisited = new boolean[N];
            students = Arrays.stream(br.readLine().split(" ")).mapToInt(value -> {
                // index 값으로 받기 위해 -1씩 계산하여 저장
                return Integer.parseInt(value) - 1;
            }).toArray();

//            for(int i = 0; i < N; i++) {
//                if (students[i] == i) {
//                    isVisited[i] = true;
//                    isCycle[i] = true;
//                    cycleCount++;
//                }
//            }

            for(int i = 0; i < N; i++) {
                if (!isCycle[i]) dfs(i);
            }

            bw.write((N - cycleCount) + "\n");
        }
        bw.close();
    }

    static void dfs(int index) {
        if (isVisited[index]) {
            isCycle[index] = true;
            cycleCount++;
        } else {
            isVisited[index] = true;
        }

        if (!isCycle[students[index]]) dfs(students[index]);

        isVisited[index] = false;
        isCycle[index] = true;
    }
}