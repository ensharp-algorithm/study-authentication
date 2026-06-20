
import java.lang.*;
import java.util.*;

public class Main {

    public static void main(String[] argc) {

        Scanner scanner = new Scanner(System.in);
        int S = scanner.nextInt();

        for (int i = 0; i < S; i++) {
            int R = scanner.nextInt();
            String P = scanner.next();
            for (int j = 0; j < P.length(); j++) {
                for (int k = 0; k < R; k++) {
                    System.out.print(P.charAt(j));
                }

            }

            System.out.println();
        }
    }

}
