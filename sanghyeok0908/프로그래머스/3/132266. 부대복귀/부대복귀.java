import java.util.*;

class Solution {
    
    List<Integer>[] edges;
    
    public int[] solution(int n, int[][] roads, int[] sources, int destination) {
        edges = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            edges[i] = new ArrayList<>();
        }
        
        for (int[] road : roads) {
            edges[road[0]].add(road[1]);
            edges[road[1]].add(road[0]);
        }
        
        int[] dist = dijkstra(n, destination);
        int[] result = new int[sources.length];
        for (int i = 0; i < sources.length; i++) {
            int s = sources[i];
            if (dist[s] == Integer.MAX_VALUE) {
                result[i] = -1;
            } else {
                result[i] = dist[s];   
            }
        }
        return result;
    }
    
    int[] dijkstra(int n, int destination) {
        int[] dist = new int[n + 1];
        Queue<int[]> queue = new PriorityQueue<>((o1, o2) -> {
            if (o1[1] != o2[1]) {
                return Integer.compare(o1[1], o2[1]);
            }
            return Integer.compare(o1[0], o2[0]);
        });
        
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[destination] = 0;
        queue.add(new int[] { destination, 0 });
        
        while(!queue.isEmpty()) {
            int[] poll = queue.poll();
            int cur = poll[0];
            int cost = poll[1];
            
            if (dist[cur] < cost) {
                continue;
            }
            
            for (int near : edges[cur]) {
                if (dist[near] > cost + 1) {
                    dist[near] = cost + 1;
                    queue.add(new int[] { near, cost + 1 });
                }
            }
        }
        return dist;
    }
}