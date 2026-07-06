import java.util.*;

class Solution {

    public int solution(int[] people, int limit) {
        TreeSet<int[]> set = new TreeSet<>((o1, o2) -> {
            if (o1[1] != o2[1]) {
                return Integer.compare(o1[1], o2[1]);
            }
            return Integer.compare(o1[0], o2[0]);
        });
        int cnt = 0;
        
        for (int i = 0; i < people.length; i++) {
            if (people[i] < limit) {
                set.add(new int[] { i, people[i] });    
            } else {
                cnt++;   
            }
        }
        
        while(!set.isEmpty()) {
            cnt++;
            
            int[] big = set.pollLast();
            
            // System.out.println("cnt = " + cnt);
            // System.out.println("big poll " + big[1]);
            
            if (set.size() >= 1 && set.first()[1] + big[1] <= limit) {
                int[] small = set.pollFirst();
                // System.out.println("small poll " + small[1]);
            }
        }
        return cnt;
    }
}