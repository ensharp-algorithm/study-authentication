import java.util.*;

class Solution {

    public int solution(int[] a) {
        int n = a.length;
        
        if (n <= 2) {
            return 2;
        }
        
        int[] leftMin = new int[n];
        int[] rightMin = new int[n];
        leftMin[0] = a[0];
        rightMin[n - 1] = a[n - 1];
        
        for (int i = 1; i < n; i++) {
            leftMin[i] = Math.min(leftMin[i - 1], a[i]);
            rightMin[n - 1 - i] = Math.min(rightMin[n - i], a[n - 1 - i]);
        }
        
        // System.out.println(Arrays.toString(leftMin));
        // System.out.println(Arrays.toString(rightMin));
        
        int answer = 2;
        for (int i = 1; i < n - 1; i++) {
            int l = leftMin[i - 1];
            int r = rightMin[i + 1];
            
            if (l > a[i] || r > a[i]) {
                answer++;
                // System.out.print(a[i] + " ");
            }
        }
        // System.out.println();
        return answer;
    }
}