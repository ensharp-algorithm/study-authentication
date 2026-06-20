//  진법 변환

import java.util.*;
import java.lang.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        String N = st.nextToken();
        int B = Integer.parseInt(st.nextToken());

        int result = 0;
        int power = 1;

        for (int i = N.length() - 1; i >= 0; i--) {
            char c = N.charAt(i);

            if (c >= '0' && c <= '9') {
                result += (c - '0') * power;

            } else {
                result += (c - 'A' + 10) * power;
            }

            power *= B;
        }

        System.out.println(result);

    }
}