import java.io.*;
import java.util.LinkedList;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        LinkedList<Integer> list = new LinkedList<>();
        LinkedList<Integer> result = new LinkedList<>();

        String[] str = br.readLine().split(" ");
        int N = Integer.parseInt(str[0]);
        int K = Integer.parseInt(str[1]);

        for (int i = 0; i < N; i++) {
            list.add(i + 1);
        }

        while (!list.isEmpty()) {
            for (int i = 0; i < K - 1; i++) {
                list.add(list.pop());
            }

            result.add(list.pop());
        }

        int size = result.size();
        bw.write("<");
        for(int i = 0; i < size - 1; i++) {
            bw.write(result.pop() + ", ");
        }
        bw.write(result.pop() + ">" + "\n");
        bw.close();
    }
}
