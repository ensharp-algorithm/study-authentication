import java.util.*;

class Solution {
    
    List<int[]>[] edges;
    
    public int solution(int n, int s, int a, int b, int[][] fares) {
        edges = new ArrayList[n + 1];
        
        for (int i = 1; i <= n; i++) {
            edges[i] = new ArrayList<>();
        }
        
        for (int[] f : fares) {
            edges[f[0]].add(new int[] { f[1], f[2] });
            edges[f[1]].add(new int[] { f[0], f[2] });
        }
        
        int[] sDist = dijkstra(n, s);
        int[] aDist = dijkstra(n, a);
        int[] bDist = dijkstra(n, b);
        int min = sDist[a] + sDist[b];
        
        for (int i = 1; i <= n; i++) {
            int temp = sDist[i] + aDist[i] + bDist[i];
            min = Math.min(min, temp);
        }
        return min;
    }
    
    int[] dijkstra(int n, int s) {
        int[] dist = new int[n + 1];
        Queue<int[]> q = new PriorityQueue<>((o1, o2) -> {
            if (o1[1] != o2[1]) {
                return Integer.compare(o1[1], o2[1]);
            }
            return Integer.compare(o1[0], o2[0]);
        });
        
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[s] = 0;
        q.add(new int[] { s, 0 });
        
        while(!q.isEmpty()) {
            int[] cur = q.poll();
            
            if (dist[cur[0]] < cur[1]) {
                continue;
            }
            
            for (int[] near : edges[cur[0]]) {
                int nextCost = cur[1] + near[1];
                
                if (dist[near[0]] > nextCost) {
                    dist[near[0]] = nextCost;
                    q.add(new int[] { near[0], nextCost });
                }
            }
        }
        return dist;
    }
}