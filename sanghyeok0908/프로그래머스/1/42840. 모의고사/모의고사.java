import java.util.*;

class Solution {
    public int[] solution(int[] answers) {
        int[] one = new int[] { 1, 2, 3, 4, 5 };
        int[] two = new int[] { 2, 1, 2, 3, 2, 4, 2, 5 };
        int[] three = new int[] { 3, 3, 1, 1, 2, 2, 4, 4, 5, 5 };
        int oneCnt = 0, twoCnt = 0, threeCnt = 0;
        
        for (int i = 0; i < answers.length; i++) {
            int ans = answers[i];
            if (one[i % one.length] == ans)
                oneCnt++;
            
            if (two[i % two.length] == ans)
                twoCnt++;
            
            if (three[i % three.length] == ans)
                threeCnt++;
        }
        
        int maxCnt = Math.max(Math.max(oneCnt, twoCnt), threeCnt);
        int idx = 0;
        List<Integer> list = new ArrayList<>();
        
        if (maxCnt == oneCnt) {
            list.add(1);
        }
        if (maxCnt == twoCnt) {
            list.add(2);
        }
        if (maxCnt == threeCnt) {
            list.add(3);
        }
        
        int[] answer = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }
        return answer;
    }
}