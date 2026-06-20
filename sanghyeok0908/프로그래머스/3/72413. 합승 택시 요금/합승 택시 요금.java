import java.util.*;

class Solution {
    
    int n;
    List<int[]>[] edges;
    
    public int solution(int n, int s, int a, int b, int[][] fares) {
        this.n = n;
        this.edges = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            edges[i] = new ArrayList<>();
        }
        
        for (int[] f : fares) {
            edges[f[0]].add(new int[] { f[1], f[2] });
            edges[f[1]].add(new int[] { f[0], f[2] });
        }
        
        int answer = Integer.MAX_VALUE;
        int[] distS = dijkstra(s);
        int[] distA = dijkstra(a);
        int[] distB = dijkstra(b);
        
        for (int i = 1; i <= n; i++) {
            int cCost = distS[i];
            int aCost = distA[i];
            int bCost = distB[i];
            
            if (aCost != Integer.MAX_VALUE && bCost != Integer.MAX_VALUE && cCost != Integer.MAX_VALUE)
                answer = Math.min(answer, aCost + bCost + cCost);
        }
        
        return answer;
    }
    
    int[] dijkstra(int s) {
        int[] dist = new int[n + 1];
        Queue<int[]> queue = new PriorityQueue<>((o1, o2) -> {
            return Integer.compare(o1[1], o2[1]);
        });
        
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[s] = 0;
        queue.add(new int[] { s, 0 });
        
        while(!queue.isEmpty()) {
            int[] poll = queue.poll();
            
            if (dist[poll[0]] < poll[1])
                continue;
            
            for (int[] near : edges[poll[0]]) {
                int cost = poll[1] + near[1];
                
                if (dist[near[0]] > cost) {
                    dist[near[0]] = cost;
                    queue.add(new int[] { near[0], cost });
                }
            }
        }
        return dist;
    }
}