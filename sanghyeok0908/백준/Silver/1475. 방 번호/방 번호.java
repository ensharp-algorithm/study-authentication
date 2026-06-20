import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int max = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 0);
        map.put(1, 0);
        map.put(2, 0);
        map.put(3, 0);
        map.put(4, 0);
        map.put(5, 0);
        map.put(6, 0);
        map.put(7, 0);
        map.put(8, 0);
        map.put(9, 0);

        while(N / 10 > 0) {
            int digit = N % 10;

            if (digit == 6 || digit == 9) {
                if (map.get(6) == map.get(9)) {
                    map.replace(6, map.get(6) + 1);
                } else {
                    map.replace(9, map.get(9) + 1);
                }
            } else {
                map.replace(digit, map.get(digit) + 1);
            }
            N /= 10;
        }

        int digit = N % 10;

        if (digit == 6 || digit == 9) {
            if (map.get(6) == map.get(9)) {
                map.replace(6, map.get(6) + 1);
            } else {
                map.replace(9, map.get(9) + 1);
            }
        } else {
            map.replace(digit, map.get(digit) + 1);
        }

        for (Integer i : map.keySet()) {
            if (max < map.get(i)) max = map.get(i);
        }
        System.out.println(max);
    }
}
