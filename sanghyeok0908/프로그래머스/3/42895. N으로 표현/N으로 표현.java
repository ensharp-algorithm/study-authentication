import java.util.*;

class Solution {

    public int solution(int N, int number) {
        Set<Long>[] dp = new HashSet[9];
        
        if (N == number) {
            return 1;
        }
        
        for (int i = 1; i <= 8; i++) {
            dp[i] = new HashSet<>();
        }
        
        long num = 0;
        for (int i = 1; i <= 8; i++) {
            num = num * 10 + N;
            dp[i].add(num);
            
            for (int j = 1; j < i; j++) {
                for (long a : dp[j]) {
                    for (long b : dp[i - j]) {
                        dp[i].add(a + b);
                        dp[i].add(a - b);
                        dp[i].add(a * b);
                        if (b > 0) {
                            dp[i].add(a / b);
                        }
                    }
                }
            }
            
            if (dp[i].contains((long)number)) {
                return i;
            }
            
            // System.out.println("i = " + i);
            // for (int num : dp[i]) {
            //     System.out.print(num + " ");
            // }
            // System.out.println();
        }
        
        return -1;
    }
}