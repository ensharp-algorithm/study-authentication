import java.io.*;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static ArrayList<int[]> answerList = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());

        hanoi(N, 1, 2, 3);

        bw.write(answerList.size() + "\n");
        for(int[] i : answerList) {
            bw.write(i[0] + " " + i[1] + "\n");
        }
        br.close();
        bw.close();
    }

    static void hanoi(int N, int start, int assist, int target) {
        if (N == 1) {
            answerList.add(new int[]{start, target});
            return;
        }

        hanoi(N - 1, start, target, assist);
        answerList.add(new int[]{start, target});
        hanoi(N - 1, assist, start, target);
    }
}