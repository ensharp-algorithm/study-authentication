import java.io.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int count = 0;

    public static void main(String[] args) throws IOException {
        String[] str = br.readLine().split(" ");
        int N = Integer.parseInt(str[0]);
        int r = Integer.parseInt(str[1]);
        int c = Integer.parseInt(str[2]);
        int maxSize = (int) Math.pow(2, N);

        recursion(maxSize, r, c);
        bw.write(count + "\n");
        br.close();
        bw.close();
    }

    static void recursion(int size, int row, int col) {
        if (size == 1) return;

        if (row < size / 2 && col < size / 2) {
            recursion(size / 2, row, col);
        } else if (row < size / 2 && col >= size / 2) {
            count += size * size / 4;
            recursion(size / 2, row, col - size / 2);
        } else if (row >= size / 2 && col < size / 2) {
            count += (size * size / 4) * 2;
            recursion(size / 2, row - size / 2, col);
        } else {
            count += (size * size / 4) * 3;
            recursion(size / 2, row - size / 2, col - size / 2);
        }
    }
}