import java.util.*;

class Solution {
    public int solution(int[] cards) {
        int answer = 0;
        int groupIdx = 1;
        int[][] list = new int[cards.length][2];
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        
        for (int i = 0; i < cards.length; i++) {
            list[i][0] = cards[i];
        }
        
        for (int i = 0; i < cards.length; i++) {
            int idx = i;
            
            while(list[idx][1] == 0) {

                list[idx][1] = groupIdx;
                idx = list[idx][0] - 1;
            }   
            groupIdx++;
        }
        
        for (int i = 0; i < cards.length; i++) {
            System.out.println(list[i][0] + " " + list[i][1]);
        }
        
        for (int i = 1; i < groupIdx; i++) {
            int cnt = 0;
            
            for (int j = 0; j < list.length; j++) {
                if (list[j][1] == i)
                    cnt++;
            }
            
            pq.add(cnt);
        }
        
        for(Integer i : pq) {
            System.out.println(i);
        }

        if (pq.size() > 1) {
            return pq.poll() * pq.poll();
        }
        return 0;
    }
}