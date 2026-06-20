import java.util.*;

class Solution {
    
    public int[] solution(int[] progresses, int[] speeds) {
        int day = 0;
        int n = speeds.length;
        int[] result = new int[101];
        
        for (int i = 0; i < n; i++) {
            while(day * speeds[i] + progresses[i] < 100) {
                day++;
            }
            
            result[day]++;
        }
        
        List<Integer> list = new ArrayList<>();
        for (int i : result) {
            if (i != 0) {
                list.add(i);
            }
        }
        
        int[] answer = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }
        return answer;
    }
}