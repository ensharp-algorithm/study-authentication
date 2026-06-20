import java.util.*;

class Solution {
    
    public int solution(String[][] clothes) {
        Map<String, Integer> map = new HashMap<>();
        
        for (String[] c : clothes) {
            map.put(c[1], map.getOrDefault(c[1], 0) + 1);
        }
        
        int answer = 1;
        
        for (String key : map.keySet()) {
            // System.out.println(key + " " + map.get(key));
            answer *= map.get(key) + 1;
        }
        
        return answer - 1;
    }
}