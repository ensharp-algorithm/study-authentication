import java.util.*;

class Solution {

    public int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;
        int[] students = new int[n + 1];
        Arrays.fill(students, 1);
        
        for (int i : lost) {
            students[i]--;
        }
        
        for (int i : reserve) {
            students[i]++;
        }
        
        for (int i = 1; i <= n; i++) {
            if (students[i] == 0) {
                if (i >= 2 && students[i - 1] > 1) {
                    students[i]++;
                    students[i - 1]--;
                    continue;
                }
                
                if (i <= n - 1 && students[i + 1] > 1) {
                    students[i]++;
                    students[i + 1]--;
                }
            }
        }
        
        for (int i = 1; i <= n; i++) {
            if (students[i] >= 1) {
                answer++;
            }
        }
        
        return answer;
    }
}