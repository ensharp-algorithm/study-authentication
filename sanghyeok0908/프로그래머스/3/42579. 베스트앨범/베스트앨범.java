import java.util.*;

class Solution {
    
    class Node {
        String key;
        int cnt;
        
        Node(String key, int cnt) {
            this.key = key;
            this.cnt = cnt;
        }
    }
    
    public int[] solution(String[] genres, int[] plays) {
        int n = genres.length;
        Map<String, Integer> genreCnt = new HashMap<>();
        Map<String, Queue<int[]>> queueMap = new HashMap<>();
        
        for (int i = 0; i < n; i++) {
            genreCnt.put(genres[i], genreCnt.getOrDefault(genres[i], 0) + plays[i]);    
            Queue<int[]> q = null;
            
            if (queueMap.containsKey(genres[i])) {
                q = queueMap.get(genres[i]);
            } else {
                q = new PriorityQueue<>((o1, o2) -> {
                   if (o1[1] != o2[1]) {
                       return Integer.compare(o2[1], o1[1]);
                   } 
                    return Integer.compare(o1[0], o2[0]);
                });
            }
            
            q.add(new int[] {i, plays[i]});
            queueMap.put(genres[i], q);
        }
        
        // for (String k : genreCnt.keySet()) {
        //     System.out.println(k + " : " + genreCnt.get(k));
        //     for (int[] i : queueMap.get(k)) {
        //         System.out.println(i[0] + " " + i[1]);
        //     }
        // }
        
        Queue<Node> genreQueue = new PriorityQueue<>((o1, o2) -> Integer.compare(o2.cnt, o1.cnt));
        for (String k : genreCnt.keySet()) {
            genreQueue.add(new Node(k, genreCnt.get(k)));
        }
        
        List<Integer> result = new ArrayList<>();
        while(!genreQueue.isEmpty()) {
            Node node = genreQueue.poll();
            Queue<int[]> q = queueMap.get(node.key);
            
            result.add(q.poll()[0]);
            if (!q.isEmpty()) {
                result.add(q.poll()[0]);
            }
        }
        
        int[] answer = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            answer[i] = result.get(i);
        }
        return answer;
    }
}