import java.util.*;

class Solution {
    public int[] solution(int e, int[] starts) {
        
        //등장횟수? 계산
        int [] arr = new int[e+1];
        
        for (int i = 1; i <= e; i++){
            for (int j = i; j <=e; j+=i){
                arr[j]++;
            }              
        }
        
        // System.out.println(Arrays.toString(arr));
        
        int[] result = new int[e+1];
        int maxIdx = 0;
        
        for (int i = e; i >= 0; i--){
            
            // System.out.println("현재 최대 위치  " + maxIdx);
            
            if (arr[i] >= arr[maxIdx]){
                maxIdx = i;
            }
            
            result[i] = maxIdx;
            
        }
        
        // System.out.println(Arrays.toString(result));
        
        int[] answer = new int[starts.length];
        for (int i = 0; i < starts.length; i++){
            answer[i] = result[starts[i]];
        }
        
        return answer;
    }
}