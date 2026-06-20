//  그대로 출력하기

import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String str = "";

        while ((str = bufferedReader.readLine()) != null) {
            System.out.println(str);
        }

    }
}