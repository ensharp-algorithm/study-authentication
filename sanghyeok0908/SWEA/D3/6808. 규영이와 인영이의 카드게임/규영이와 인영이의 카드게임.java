import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.*;

public class Solution {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int[] guyongCards;
    static int[] inyougCards;
    static boolean[] isVisited;
    static int[] arr;
    static int guyongWin, inyougWin;

    public static void main(String[] args) throws Exception {
        int T = Integer.parseInt(br.readLine());
        StringBuilder answer = new StringBuilder();

        for (int t = 1; t <= T; t++) {
            guyongCards = new int[9];
            inyougCards = new int[9];
            isVisited = new boolean[9];
            arr = new int[9];
            guyongWin = 0;
            inyougWin = 0;
            StringTokenizer st = new StringTokenizer(br.readLine());
            Set<Integer> set = new HashSet<>();
            for (int i = 1; i <= 18; i++) {
                set.add(i);
            }
            for (int i = 0; i < 9; i++) {
                guyongCards[i] = Integer.parseInt(st.nextToken());
                set.remove(guyongCards[i]);
            }

            int j = 0;
            for (Integer i : set) {
                inyougCards[j++] = i;
            }

            bruthForce(0);
            answer.append("#" + t + " " + guyongWin + " " + inyougWin + "\n");
        }
        System.out.println(answer);
    }

    static void bruthForce(int depth) {
        if (depth == 9) {
            int guyongCnt = 0, inyongCnt = 0;
            for (int i = 0; i < 9; i++) {
                int guyong = guyongCards[i];
                int inyong = arr[i];

                if (guyong > inyong) {
                    guyongCnt += guyong + inyong;
                } else {
                    inyongCnt += guyong + inyong;
                }
            }

            if (guyongCnt > inyongCnt) {
                guyongWin++;
            } else {
                inyougWin++;
            }
            return;
        }

        for (int i = 0; i < 9; i++) {
            if (isVisited[i])
                continue;

            isVisited[i] = true;
            arr[depth] = inyougCards[i];
            bruthForce(depth + 1);
            isVisited[i] = false;
        }
    }
}