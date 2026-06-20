import java.util.*;

class Solution {
    public int[] solution(int brown, int yellow) {
        int n = (int) ((brown - 4) / 2 + Math.sqrt(Math.pow(brown - 4, 2) / 4 - 4 * yellow)) / 2;
        int m = yellow / n;
        
        // System.out.println(Math.sqrt(Math.pow(brown - 4, 2) / 4 - 4 * yellow));
        
        if (m > n) return new int[]{m + 2, n + 2};
        return new int[]{n + 2, m + 2};
    }
}