//  팰린드롬인지 확인하기

import java.util.*;
import java.lang.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        String str2 = new StringBuilder(str).reverse().toString();
        System.out.println(str.equals(str2) ? 1 : 0);

    }
}