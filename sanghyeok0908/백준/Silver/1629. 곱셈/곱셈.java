import java.io.*;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        String[] str = br.readLine().split(" ");
        int A = Integer.parseInt(str[0]);
        int B = Integer.parseInt(str[1]);
        int C = Integer.parseInt(str[2]);

        bw.write((pow(A, B, C) % C) + "\n");
        br.close();
        bw.close();
    }

    static long pow(int a, int b, int c) {
        if (b == 1) return a;

        long x = pow(a, b / 2, c);

        if (b % 2 == 1) {
            return ((pow(a, 1, c) % c) * ((x * x) % c)) % c;
        }

        return (x * x) % c;
    }
}