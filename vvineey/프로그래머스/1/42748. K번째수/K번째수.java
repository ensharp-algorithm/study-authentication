import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
          
        for (int i = 0; i < commands.length; i++){
            int start = commands[i][0]-1;
            int end = commands[i][1]-1;
            int k = commands[i][2]-1;
            
            int[] tmp = new int[end-start+1];
            int cnt = 0;
            
            // System.out.println();
            for (int j = start ; j <= end; j++){
                tmp[cnt++] = array[j];
                // System.out.println(tmp[cnt-1]);
            }
        
            Arrays.sort(tmp);
            answer[i] = tmp[k];
        }
        return answer;
        
        
        
    }
}