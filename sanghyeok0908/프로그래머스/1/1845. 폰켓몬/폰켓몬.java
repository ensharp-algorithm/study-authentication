import java.util.*;

class Solution {
    public int solution(int[] nums) {
        int total = nums.length / 2;
        Map<Integer, Integer> map = new HashMap<>();
        
        for (int n : nums) {
            map.put(n, map.getOrDefault(n, 0) + 1);
        }
        
        int answer = map.keySet().size();
        if (answer < total) return answer;
        return total;
    }
}