//  암호 해독

import java.util.*;
import java.lang.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();
        int n = Integer.parseInt(br.readLine());

        String s[] = new String[n];

        for (int i = 0; i < n; i++) {
            s[i] = br.readLine();
        }

        for (int i = 0; i < 26; i++) {
            String tmp = "";

            for (int j = 0; j < str.length(); j++) {
                tmp += (char) ((str.charAt(j) - 'a' + i) % 26 + 'a');
            }

            for (int k = 0; k < n; k++) {
                if (tmp.contains(s[k])) {
                    System.out.println(tmp);
                    return;
                }
            }
        }
    }
}