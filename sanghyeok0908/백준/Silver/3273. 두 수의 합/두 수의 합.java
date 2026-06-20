import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        ArrayList<Integer> arr = new ArrayList<>();

        for(int i = 0; i < n; i++) {
            arr.add(scanner.nextInt());
        }

        int x = scanner.nextInt();
        int idx = 0;
        arr.sort(Comparator.naturalOrder());

        for(int i = 0; i < arr.size(); i++) {
            if (arr.get(i) > x) {
                if (i == 0) {
                    System.out.println(0);
                    return;
                }

                idx = i - 1;
                break;
            }
        }

        if (idx == 0) idx = arr.size() - 1;

        int i = 0;
        int count = 0;
        while(i < idx) {
            int sum = arr.get(i) + arr.get(idx);

            if (sum == x) {
                count++;
                i++;
                idx--;
            } else if (sum > x) {
                idx--;
            } else {
                i++;
            }
        }

        System.out.println(count);
    }
}
