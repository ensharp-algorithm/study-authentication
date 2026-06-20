import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        List<Integer> list = new ArrayList<>();
        int prev = -1;
        
        for (int i = 0; i < arr.length; i++) {
            if (prev == arr[i]) {
                continue;
            }
            
            prev = arr[i];
            list.add(arr[i]);
        }

        int[] answer = list.stream().mapToInt(Integer::intValue).toArray();
        return answer;
    }
}