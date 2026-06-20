//  상수

import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String A = scanner.next();
        String B = scanner.next();

        StringBuilder stringBuilder1 = new StringBuilder(A);
        StringBuilder stringBuilder2 = new StringBuilder(B);

        int result1 = Integer.parseInt(stringBuilder1.reverse().toString());
        int result2 = Integer.parseInt(stringBuilder2.reverse().toString());

        if (result1 > result2) {
            System.out.println(result1);
        } else {
            System.out.println(result2);
        }

    }
}