//  색종이

import java.util.*;
import java.lang.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        boolean space[][] = new boolean[100][100];
        int total = 0;

        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());


            for (int j = x - 1; j < x + 9; j++) {
                for (int k = y - 1; k < y + 9; k++) {

                    space[j][k] = true;
                }
            }
        }

        for (int i = 0; i < 100; i++) {
            for (int j = 0; j < 100; j++) {
                if (space[i][j] == true) {
                    total++;
                }
            }
        }

        System.out.println(total);
    }
}