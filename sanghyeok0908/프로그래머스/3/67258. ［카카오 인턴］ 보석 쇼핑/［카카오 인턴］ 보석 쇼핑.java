import java.util.*;

class Solution {
    
    int n, size;
    Map<String, Integer> map = new HashMap<>();
    
    public int[] solution(String[] gems) {
        n = gems.length;
        size = new HashSet<>(Arrays.asList(gems)).size();
        
        int[] answer = new int[] { 1, n };
        int left = 0;
        int minLen = Integer.MAX_VALUE;
        
        for (int right = 0; right < n; right++) {
            map.put(gems[right], map.getOrDefault(gems[right], 0) + 1);
            
            while (map.get(gems[left]) > 1) {
                map.put(gems[left], map.get(gems[left]) - 1);
                left++;
            }
            
            // System.out.printf("left = %d, leftCnt = %d, right = %d, rightCnt = %d, size = %d\n",
                             // left, map.get(gems[left]), right, map.get(gems[right]), map.size());
            
            if (map.size() == size && minLen > right - left) {
                minLen = right - left;
                answer[0] = left + 1;
                answer[1] = right + 1;
                // System.out.println(answer[0] + " " + answer[1]);
            }
        }
        return answer;
    }
}