import java.util.*;

class Solution {

    public int solution(int[][] scores) {
        int[] wanho = scores[0];
        // int wanho = scores[0][0] + scores[0][1];
        
        Arrays.sort(scores, (o1, o2) -> {
            if (o1[0] != o2[0])
                return Integer.compare(o1[0], o2[0]) * -1;
            return Integer.compare(o1[1], o2[1]);
        });
        
        int rank = 0, max = 0;
        for (int[] score : scores) {
            if (score[1] < max) {
                if (wanho[0] == score[0] && wanho[1] == score[1])
                    return -1;
            } else {
                max = score[1];
                
                if (wanho[0] + wanho[1] < score[0] + score[1])
                    rank++;
            }
        }
        return rank + 1;
    }
}