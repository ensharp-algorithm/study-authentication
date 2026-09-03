import java.util.*;

class Solution {
    
    public int solution(int N, int number) {
        
        // dp[i] = N을 i개 써서 만들 수 있는 숫자 집합
        HashSet<Integer>[] dp = new HashSet[9];
        
        for (int i = 0; i < 9; i++) {
            dp[i] = new HashSet<>();
        }
        
        dp[1].add(N);
        
        if (N == number) {
            return 1;
        }
        
        for (int i = 2; i < 9; i++) {
            
            int k = 0;
            
            for (int j = 0; j < i; j++) {
                k = k * 10 + N;
            }
            
            dp[i].add(k);
            
        
            for (int j = 1; j < i; j++) {
                
                calc(dp[i], dp[j], dp[i-j]);
            }
            
            
            if (dp[i].contains(number)) {
                return i;
            }
        }
        
        return -1;
    }
    
    
    private void calc(HashSet<Integer> dp,HashSet<Integer> set1,HashSet<Integer> set2) {
        
        for (Integer n1 : set1) {
            
            for (Integer n2 : set2) {
                
                // +
                dp.add(n1 + n2);
                
                // -
                dp.add(n1 - n2);
                
                // *
                dp.add(n1 * n2);
                
                // /
                if (n2 != 0) {
                    dp.add(n1 / n2);
                }
            }
        }
    }
}