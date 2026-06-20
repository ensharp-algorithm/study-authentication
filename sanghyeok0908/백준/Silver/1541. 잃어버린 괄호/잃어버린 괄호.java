import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

  public static void main(String[] args) throws Exception {
    String input = br.readLine();
    String[] arr = input.split("-");
    List<Integer> numbers = new ArrayList<>();

    for (String a : arr) {
      int sum = 0;
      int[] nums = Arrays.stream(a.split("[+]"))
          .mapToInt(Integer::parseInt)
          .toArray();

      for (int i : nums) {
        sum += i;
      }
      numbers.add(sum);
    }

    int answer = numbers.get(0);
    for (int i = 1; i < numbers.size(); i++) {
      answer -= numbers.get(i);
    }

    System.out.println(answer);
  }
}