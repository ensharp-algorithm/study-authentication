import java.util.*;

class Solution {
    
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        int ansIdx = 0;
        
        for (int[] command : commands) {
            int n = command[1] - command[0] + 1;
            int[] arr = new int[n];
            
            for (int i = command[0] - 1, arrIdx = 0; i < command[1]; i++, arrIdx++) {
                arr[arrIdx] = array[i];
            }
            Arrays.sort(arr);
            
            answer[ansIdx++] = arr[command[2] - 1];
        }
        
        return answer;
    }
}