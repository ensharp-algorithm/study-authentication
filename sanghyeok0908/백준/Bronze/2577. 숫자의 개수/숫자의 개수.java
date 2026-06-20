import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int A = scanner.nextInt();
        int B = scanner.nextInt();
        int C = scanner.nextInt();
        String result = String.valueOf(A * B * C);
        Map<Character, Integer> answer = new HashMap<>(Map.of(
                '0', 0,
                '1', 0,
                '2', 0,
                '3', 0,
                '4', 0,
                '5', 0,
                '6', 0,
                '7', 0,
                '8', 0,
                '9', 0
        ));

        for(char c : result.toCharArray()) {
            answer.replace(c, answer.get(c) + 1);
        }

        Collection<Integer> values = answer.values();
        for(Integer v : values) {
            System.out.println(v);
        }
    }
}
