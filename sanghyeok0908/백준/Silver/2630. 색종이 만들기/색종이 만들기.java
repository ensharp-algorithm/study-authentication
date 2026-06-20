import java.io.*;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int[][] matrix;
    static int blueCount = 0, whiteCount = 0;

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());
        matrix = new int[N][N];

        for (int i = 0; i < N; i++)
            matrix[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        recursion(0, 0, N);
        bw.write(whiteCount + "\n" + blueCount + "\n");
        br.close();
        bw.close();
    }

    static void recursion(int startY, int startX, int size) {
        if (size == 1 || isSamePaper(startY, startX, startY + size - 1, startX + size - 1)) {
            if (matrix[startY][startX] == 1) blueCount++;
            else whiteCount++;
            return;
        }

        recursion(startY, startX, size / 2);
        recursion(startY, startX + size / 2, size / 2);
        recursion(startY + size / 2, startX, size / 2);
        recursion(startY + size / 2, startX + size / 2, size / 2);
    }

    static boolean isSamePaper(int startY, int startX, int endY, int endX) {
        int firstNum = matrix[startY][startX];

        for (int i = startY; i <= endY; i++) {
            for (int j = startX; j <= endX; j++) {
                if (firstNum != matrix[i][j]) return false;
            }
        }
        return true;
    }
}