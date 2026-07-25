import java.util.*;

class Solution {

    public int solution(int N, int[][] road, int K) {
        List<int[]>[] nodes = new ArrayList[N + 1];
        Queue<int[]> queue = new PriorityQueue<>((o1, o2) -> {
            if (o1[1] != o2[1]) {
               return Integer.compare(o1[1], o2[1]);
            } 
            return Integer.compare(o1[0], o2[0]);
        });
        int[] dist = new int[N + 1];
        
        for (int i = 1; i <= N; i++) {
            nodes[i] = new ArrayList<>();
        }
        
        for (int[] r : road) {
            nodes[r[0]].add(new int[] { r[1], r[2] });
            nodes[r[1]].add(new int[] { r[0], r[2] });
        }
        
        queue.add(new int[] { 1, 0 });
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[1] = 0;
        
        while(!queue.isEmpty()) {
            int[] poll = queue.poll();
            int idx = poll[0];
            int cost = poll[1];
            
            if (cost > dist[idx]) {
                continue;
            }
            
            for (int[] near : nodes[idx]) {
                int curCost = cost + near[1];
                if (curCost < dist[near[0]]) {
                    dist[near[0]] = curCost;
                    queue.add(new int[] { near[0], curCost });
                }
            }
        }
        
        int answer = 0;
        for (int i = 1; i <= N; i++) {
            // System.out.println(dist[i]);
            if (dist[i] <= K) {
                answer++;
            }
        }
        return answer;
    }
}