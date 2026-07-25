import java.util.*;

class Solution {
    
    int[] students;

    public int solution(int n, int[] lost, int[] reserve) {
        students = new int[n + 1];
        Arrays.fill(students, 1);
        
        students[0] = 0;
        for (int l : lost) {
            students[l]--;
        }
        for (int r : reserve) {
            students[r]++;
        }
        
        for (int i = 1; i <= n; i++) {
            if (students[i] == 0) {
                if (i > 1 && students[i - 1] > 1) {
                    students[i - 1] = 1;
                    students[i] = 1;
                } else if (i < n && students[i + 1] > 1) {
                    students[i + 1] = 1;
                    students[i] = 1;
                }
            }
        }

        int answer = 0;
        
        for (int i = 0; i <= n; i++) {
            if (students[i] != 0) {
                answer++;
            }
        }
        return answer;
    }
}