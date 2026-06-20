//  킹, 퀸, 룩, 비숍, 나이트, 폰

import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int k = 1 - Integer.parseInt(st.nextToken());
        int q = 1- Integer.parseInt(st.nextToken());
        int r = 2- Integer.parseInt(st.nextToken());
        int b = 2- Integer.parseInt(st.nextToken());
        int n = 2- Integer.parseInt(st.nextToken());
        int p = 8- Integer.parseInt(st.nextToken());

        System.out.printf("%d %d %d %d %d %d",k,q,r,b,n,p);

    }
}