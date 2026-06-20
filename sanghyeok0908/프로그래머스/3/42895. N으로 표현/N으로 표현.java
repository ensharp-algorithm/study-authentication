import java.util.*;

class Solution {

    public int solution(int N, int number) {
        if (N == number) {
            return 1;
        }

        Set<Integer>[] set = new HashSet[9];
        
        for (int i = 1; i <= 8; i++) {
            set[i] = new HashSet<>();
            set[i].add(createSameNum(N, i));
        }
        
        for (int i = 2; i <= 8; i++) {
            for (int j = 1; j < i; j++) {
                int k = i - j;
                
                for (int num1 : set[j]) {
                    for (int num2 : set[k]) {
                        set[i].add(num1 + num2);
                        set[i].add(num1 - num2);
                        set[i].add(num1 * num2);
                        if (num2 != 0) {
                            set[i].add(num1 / num2);
                        }
                    }
                }
            }
            
            if (set[i].contains(number)) {
                return i;
            }
        }
        return -1;
    }
    
    int createSameNum(int N, int size) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < size; i++) {
            sb.append(N);
        }
        return Integer.parseInt(sb.toString());
    }
}