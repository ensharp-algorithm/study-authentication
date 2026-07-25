import java.util.*;

class Solution {
    
    static class Node {
        int v;
        int distance;
        
        Node(int v, int distance) {
            this.v = v;
            this.distance = distance;
        }
    }
    
    static class Edge {
        int to;
        int cost;
        
        Edge(int to, int cost) {
            this.to = to;
            this.cost = cost;
        }
    }
    
    static List<Edge>[] graph;
    static int[] distances;
    static int K;
    static int N;
    
    public int solution(int N, int[][] road, int K) {
        
        int answer = 0;
        
        graph = new ArrayList[N + 1];
        distances = new int[N + 1];
        this.K = K;
        this.N = N;
        
        for (int i = 0; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }
        
        for (int i = 0; i < road.length; i++) {
            int v1 = road[i][0];
            int v2 = road[i][1];
            int cost = road[i][2];
            
            graph[v1].add(new Edge(v2, cost));
            graph[v2].add(new Edge(v1, cost));
        }
        
        //graph[0] :0에 연결된 간선들 [Edge0, Edge1 ...]
        
        dijkstra(1);
        
        for (int i = 1; i <= N; i++) {
            if (distances[i] <= K) {
                answer++;
            }
        }
        
        return answer;
    }
    
    private void dijkstra(int start) {
        
        Arrays.fill(distances, Integer.MAX_VALUE);
        
        PriorityQueue<Node> queue = new PriorityQueue<>((o1, o2) -> {
            
            if (o1.distance != o2.distance) {
                return Integer.compare(o1.distance, o2.distance);
            } 
            
            else {
                return Integer.compare(o1.v, o2.v);
            }
        });
        
        queue.offer(new Node(start, 0));
        distances[start] = 0;
        
        while (!queue.isEmpty()) {
            System.out.println(Arrays.toString(distances));
            
            Node current = queue.poll();
            
            if (current.distance > K) {
                break;
            }
            
            if (current.distance > distances[current.v]) {
                continue;
            }

            for (Edge edge : graph[current.v]) {

                int nextDistance = current.distance + edge.cost;

                // 기존 거리보다 짧음 !!  발견
                if (nextDistance < distances[edge.to]) {
                    distances[edge.to] = nextDistance;

                    queue.offer(new Node(edge.to, nextDistance));
                }
            }
        }
    }
}