import java.util.*;

class Solution {
    
    public int[] solution(String[] info, String[] query) {
        int n = info.length;
        int m = query.length;
        int[] answer = new int[m];
        Map<String, List<Integer>> map = new HashMap<>();
        
        for (int i = 0; i < n; i++) {
            String[] split = info[i].split(" ");
            String[] language = { split[0], "-" };
            String[] tech = { split[1], "-" };
            String[] history = { split[2], "-" };
            String[] food = { split[3], "-" };
            int score = Integer.parseInt(split[4]);
            
            for (String l : language) {
                for (String t : tech) {
                    for (String h : history) {
                        for (String f : food) {
                            String key = l + t + h + f;
                            
                            map.putIfAbsent(key, new ArrayList<>());
                            map.get(key).add(score);
                        }
                    }
                }
            }
        }
        
        for (List<Integer> list : map.values()) {
            Collections.sort(list);
        }
        
        for (int i = 0; i < m; i++) {
            String[] split = query[i].split(" ");
            String language = split[0];
            String tech = split[2];
            String history = split[4];
            String food = split[6];
            int score = Integer.parseInt(split[7]);
            String key = language + tech + history + food;
            List<Integer> list = map.get(key);
            
            if (list == null || list.isEmpty()) {
                continue;
            }
            
            int left = 0, right = list.size() - 1;
            
            while(left <= right) {
                int mid = (left + right) / 2;
                
                if (list.get(mid) < score) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
            
            answer[i] = list.size() - left;
        }
        return answer;
    }
}