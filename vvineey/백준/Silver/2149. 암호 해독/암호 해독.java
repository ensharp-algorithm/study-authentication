
import java.lang.*;
import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] argc) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String key = br.readLine();
        String str = br.readLine();

        int col = key.length();
        int row = str.length() / col;
        char[][] table = new char[row][col];

        Integer[] order = new Integer[col];
        for (int i = 0; i < col; i++) {
            order[i] = i;
        }

        Arrays.sort(order, (a, b) -> key.charAt(a) - key.charAt(b));


        int idx = 0;

        for (int i = 0; i < col; i++) {
            for (int j = 0; j < row; j++) {
                table[j][order[i]] = str.charAt(idx++);
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int r = 0; r < row; r++) {
            for (int c = 0; c < col; c++) {
                sb.append(table[r][c]);
            }
        }

        System.out.print(sb.toString());

    }

}
