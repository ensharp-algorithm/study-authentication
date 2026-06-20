import java.io.*;

public class Main {

    static int[] root;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] s = br.readLine().split(" ");
        int n = Integer.parseInt(s[0]);
        int m = Integer.parseInt(s[1]);

        root = new int[n + 1];

        for (int i = 0; i < n + 1; i++) root[i] = i;

        for (int i = 0; i < m; i++) {
            s = br.readLine().split(" ");
            int a = Integer.parseInt(s[1]);
            int b = Integer.parseInt(s[2]);

            if (s[0].charAt(0) == '0') {
                union(a, b);
            } else {
                int findA = find(a);
                int findB = find(b);

                if (findA == findB) bw.write("YES\n");
                else bw.write("NO\n");
            }
        }
        bw.close();
    }

    static void union(int x, int y) {
        x = find(x);
        y = find(y);

        if (x == y) return;

        if (x < y) {
            root[x] = y;
        } else {
            root[y] = x;
        }
    }

    static int find(int x) {
        if (root[x] == x) return x;

        return root[x] = find(root[x]);
    }
}