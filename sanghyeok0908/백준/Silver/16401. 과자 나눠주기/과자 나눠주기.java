import java.io.*;
import java.util.*;

// Arrays.stream(br.readLine().split(" "))
//           .mapToInt(Integer::parseInt)
//           .toArray();

public class Main {

  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  static int M, N;
  static int[] snacks;

  public static void main(String[] args) throws Exception {
    StringTokenizer st = new StringTokenizer(br.readLine());
    M = Integer.parseInt(st.nextToken());
    N = Integer.parseInt(st.nextToken());
    snacks = new int[N];
    st = new StringTokenizer(br.readLine());

    for (int i = 0; i < N; i++) {
      snacks[i] = Integer.parseInt(st.nextToken());
      
    }

    Arrays.sort(snacks);

    int left = 1;
    int right = snacks[N - 1];
    int answer = 0;

    while(left <= right) {
      int mid = (left + right) / 2;

      int count = getCount(mid);
      if (count >= M) {
        answer = mid;
        left = mid + 1;
      } else {
        right = mid - 1;
      }
    }
    
    System.out.println(answer);
  }

  static int getCount(int mid) {
    int result = 0;

    for (int i = N - 1; i >= 0; i--) {
      int value = snacks[i] / mid;
      
      if (value == 0) break;
      result += value;
    }
    return result;
  }
}

// 4 7 9