import java.util.*;

class Solution {

    List<int[]> list = new ArrayList<>();
    
    public int solution(int[][] targets) {
        int answer = 0, prevEnd = 0;
        Arrays.sort(targets, (o1, o2) -> Integer.compare(o1[1], o2[1]));
        
        for(int[] target : targets) {
            if (prevEnd <= target[0]) {
                answer++;
                prevEnd = target[1];
            }
        }
        return answer;
    }
}