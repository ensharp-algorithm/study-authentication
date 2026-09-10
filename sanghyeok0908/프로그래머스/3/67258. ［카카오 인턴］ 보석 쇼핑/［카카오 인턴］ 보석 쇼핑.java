import java.util.*;

class Solution {
    
    public int[] solution(String[] gems) {
        Set<String> set = new HashSet<>();
        for (String g : gems) {
            set.add(g);
        }
        
        // System.out.println("size=" + set.size());
        
        Queue<int[]> answer = new PriorityQueue<>((o1, o2) -> {
            if (o1[1] - o1[0] != o2[1] - o2[0]) {
                return Integer.compare(o1[1] - o1[0], o2[1] - o2[0]);
            }
            return Integer.compare(o1[0], o2[0]);
        });
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0, start = 0; i < gems.length; i++) {
            map.put(gems[i], map.getOrDefault(gems[i], 0) + 1);
            
            // System.out.println("gem=" + gems[i] + ", cnt=" + map.get(gems[i]));
            
            while (start < i && map.get(gems[start]) > 1) {
                // System.out.println("increase startPoint " + start);
                map.put(gems[start], map.get(gems[start]) - 1);
                start++;
            }
            
            if (map.size() == set.size()) {
                // System.out.println("answer add " + (start + 1) + " " + (i + 1));
                answer.add(new int[] { start + 1, i + 1 });    
            }
        }
        
        return answer.poll();
    }
}