import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

  static class Time {
    int start, end;

    public Time(int start, int end) {
      this.start = start;
      this.end = end;
    }
  }

  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  static int N;
  static Time[] times;

  public static void main(String[] args) throws Exception {
    N = Integer.parseInt(br.readLine());
    times = new Time[N];

    for (int i = 0; i < N; i++) {
      int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
      times[i] = new Time(arr[0], arr[1]);
    }

    Arrays.sort(times, (s1, s2) -> {
      int start = s2.start - s1.start;
      int end = s2.end - s1.end;

      if (end == 0) {
        if (start == 0)
          return 0;
        return start > 0 ? -1 : 1;
      }
      return end > 0 ? -1 : 1;
    });

    int endTime = 0;
    int count = 0;
    for (int i = 0; i < N; i++) {
      // System.out.println(times[i].start + ", " + times[i].end);
      if (endTime <= times[i].start) {
        endTime = times[i].end;
        count++;
        // System.out.println(times[i].start + ", " + times[i].end);
      }
    }
    System.out.println(count);
  }
}