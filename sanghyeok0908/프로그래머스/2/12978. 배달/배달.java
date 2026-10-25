import java.util.*;

class Solution {
    
    List<int[]>[] nodes;

    public int solution(int N, int[][] road, int K) {
        nodes = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            nodes[i] = new ArrayList<>();
        }
        
        for (int[] r : road) {
            nodes[r[0]].add(new int[] { r[1], r[2] });
            nodes[r[1]].add(new int[] { r[0], r[2] });
        }
        
        Queue<int[]> queue = new PriorityQueue<>((o1, o2) -> 
                                         Integer.compare(o1[1], o2[1]));
        int[] dist = new int[N + 1];
        
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[1] = 0;
        queue.add(new int[] { 1, 0 });
        
        while(!queue.isEmpty()) {
            int[] cur = queue.poll();
            
            if (cur[1] > dist[cur[0]]) {
                continue;
            }
            
            for (int[] near : nodes[cur[0]]) {
                int cost = cur[1] + near[1];
                
                if (cost < dist[near[0]]) {
                    dist[near[0]] = cost;
                    queue.add(new int[] { near[0], cost });
                }
            }
        }
        
        int cnt = 0;
        for (int i = 1; i <= N; i++) {
            // System.out.print(dist[i] + " ");
            if (dist[i] <= K) {
                cnt++;
            }
        }
        return cnt;
    }
}