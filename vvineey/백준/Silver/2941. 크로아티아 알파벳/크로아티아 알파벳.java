import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        int cnt = 0;

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);

            if (c == 'c') {
                if (i + 1 < str.length() && (str.charAt(i + 1) == '=' || str.charAt(i + 1) == '-')) {
                    i++;
                }
            } else if (c == 'd') {
                if (i + 1 < str.length() && str.charAt(i + 1) == '-') {
                    i++;
                } else if (i + 2 < str.length() && str.charAt(i + 1) == 'z' && str.charAt(i + 2) == '=') {
                    i += 2;
                }
            } else if (c == 'l' || c == 'n') {
                if (i + 1 < str.length() && str.charAt(i + 1) == 'j') {
                    i++;
                }
            } else if (c == 's' || c == 'z') {
                if (i + 1 < str.length() && str.charAt(i + 1) == '=') {
                    i++;
                }
            }

            cnt++;
        }

        System.out.println(cnt);
    }
}
