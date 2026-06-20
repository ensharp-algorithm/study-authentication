//  그룹 단어 체커

import java.util.*;
import java.lang.*;
import java.io.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {

        int N = Integer.parseInt(br.readLine());
        int cnt = 0;

        for (int i = 0; i < N; i++) {

            if (checkWord()) {
                cnt++;
            }
        }

        System.out.println(cnt);
    }


    private static boolean checkWord() throws IOException {
        boolean isChecked[] = new boolean[26];
        String word = br.readLine();
        char tmp = 0;

        for (int i = 0; i < word.length(); i++) {

            char now = word.charAt(i);

            if (now != tmp) {

                if (isChecked[now - 'a']) {
                    return false;
                }

                isChecked[now - 'a'] = true;
                tmp = now;
            }
        }
        return true;
    }
}