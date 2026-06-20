import java.util.*;

class Solution {
        
    public int[] solution(int n, int s) {
        int max = 0;
        int[] set = new int[n];
        int value = s / n;            
        int idx = 0;    
        int copyS = s;

        if (value == 0) {
            return new int[] {-1};
        }
        
        while(true) {
            set[idx++] = value;
            copyS -= value;

            if (copyS == 0) {
                break;
            }
            
            if (n - idx == 0) {
                return new int[] {-1};
            }

            value = copyS / (n - idx);
        }

        if (idx != n) {
            return new int[] {-1};
        }
        
        return set;
    }
}