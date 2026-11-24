import java.util.*;

class Solution {
    
    public int[] solution(String[] gems) {
        Set<String> set = new HashSet<>();
        Map<String, Integer> map = new HashMap<>();
        int start = 0, cnt = 0;
        int[] answer = { 0, gems.length };
        
        for (String g : gems) {
            set.add(g);
        }
        
        for (int i = 0; i < gems.length; i++) {
            map.put(gems[i], map.getOrDefault(gems[i], 0) + 1);
            
            if (map.get(gems[i]) == 1) {
                cnt++;
            }
            
            while(start < i && map.get(gems[start]) > 1) {
                map.put(gems[start], map.get(gems[start]) - 1);
                start++;
            }
            
            if (cnt == set.size()) {                
                if (i - start < answer[1] - answer[0]) {
                    answer[0] = start + 1;
                    answer[1] = i + 1;    
                }
                
                map.put(gems[start], 0);
                cnt--;
                start++;
            }
        }
        return answer;
    }
}