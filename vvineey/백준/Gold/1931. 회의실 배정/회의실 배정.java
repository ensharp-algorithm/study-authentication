//  회의실 배정

import java.util.*;
import java.lang.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[][] timeTable = new int[n][2];

        StringTokenizer st;

        //입력
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            timeTable[i][0] = Integer.parseInt(st.nextToken());
            timeTable[i][1] = Integer.parseInt(st.nextToken());
        }

        //종료 시간 기점으로 정렬하는데
        //어어어ㅓㅓㅓ어어어ㅓㅓ어어ㅓ 시작이 빠른 회의가 앞으로 (그니까 종료가 같으면!!)
        Arrays.sort(timeTable, (a, b) -> {
            if (a[1] == b[1]) {
                return a[0] - b[0];
            }
            return a[1] - b[1];
        });

        int cnt = 0;
        int tmp = 0;

        //1 4
        //3 7
        //5 7
        //6 7

        for (int i = 0; i < n; i++) {

            if (tmp <= timeTable[i][0]) {
                //끝 시간 저장함 ㄷ
                tmp = timeTable[i][1];
                cnt++;
            }
        }

        System.out.println(cnt);

    }
}