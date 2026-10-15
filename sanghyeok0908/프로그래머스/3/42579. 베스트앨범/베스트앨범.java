import java.util.*;

class Solution {
    
    Map<String, Queue<int[]>> map = new HashMap<>();
    Map<String, Integer> genreCnt = new HashMap<>();
    
    public int[] solution(String[] genres, int[] plays) {
        int n = genres.length;
        
        for (int i = 0; i < n; i++) {
            Queue<int[]> q = map.getOrDefault(genres[i], new PriorityQueue<>((o1, o2) -> {
                if (o1[1] != o2[1]) {
                    return Integer.compare(o1[1], o2[1]) * -1;
                }
                return Integer.compare(o1[0], o2[0]);
            }));
            
            q.add(new int[] { i, plays[i] });
            map.put(genres[i], q);
            
            genreCnt.put(genres[i], genreCnt.getOrDefault(genres[i], 0) + plays[i]);
        }
        
        List<Integer> result = new ArrayList<>();
        
        while(!map.isEmpty()) {
            String maxKey = null;
            int max = 0;
            
            for (String key : map.keySet()) {
                if (max < genreCnt.get(key)) {
                    max = genreCnt.get(key);
                    maxKey = key;
                }
            }
            
            Queue<int[]> queue = map.get(maxKey);
            int cnt = 0;
            
            while(!queue.isEmpty() && cnt < 2) {
                result.add(queue.poll()[0]);
                cnt++;
            }
            
            map.remove(maxKey);
            genreCnt.remove(maxKey);
        }
        
        int[] answer = new int[result.size()];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = result.get(i);
        }
        return answer;
    }
}