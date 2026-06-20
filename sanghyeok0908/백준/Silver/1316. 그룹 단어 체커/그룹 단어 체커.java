import java.io.*;
import java.util.*;

// Arrays.stream(br.readLine().split(" "))
//           .mapToInt(Integer::parseInt)
//           .toArray();

public class Main {

  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  static int N;

  public static void main(String[] args) throws Exception {
    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    int count = 0;

    for (int n = 0; n < N; n++) {
      st = new StringTokenizer(br.readLine());
      String s = st.nextToken();
      char[] c = s.toCharArray();
      boolean isDupli = false;

      for(int i = 0; i < s.length(); i++) {
        int j = i + 1;

        while(j < s.length() && c[i] == c[j]) j++;

        for (; j < s.length(); j++) {
          if (c[i] == c[j]) {
            isDupli = true;
            break;
          }
        }

        if (isDupli) {
          break;
        }
      }

      if (!isDupli) count++;
    }  
    System.out.println(count);
  }
}

// 4 7 9