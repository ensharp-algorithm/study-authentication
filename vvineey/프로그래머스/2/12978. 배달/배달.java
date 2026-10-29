import java.util.*;

class Solution {
    
    class Edge{
        int to;
        int cost;
        
        Edge(int to, int cost){
            this.to = to;
            this.cost = cost;
        }
    }
    
    static int[] distance;
    static int INF;
    static List<Edge>[] graph;
    
    public int solution(int N, int[][] road, int K) {
        
        distance = new int[N+1];
        INF = Integer.MAX_VALUE;
        graph = new List[N+1];
        
        for (int i = 1; i < N+1 ; i++){
            graph[i] = new ArrayList<>();
        }
        
        for (int[] row : road){
            graph[row[0]].add(new Edge(row[1],row[2]));
            graph[row[1]].add(new Edge(row[0],row[2]));
        }
        
        dijkstra(1);
        
        int answer = 0;
        for (int d : distance){
            if (d <= K){
                answer++;
            }
        }
        
        return answer;
    }
    
    private void dijkstra(int start){
                
        Arrays.fill(distance,INF);
        distance[start] = 0;
        
        PriorityQueue<Edge> pq = new PriorityQueue<>((o1,o2)->{
            return Integer.compare(o1.cost, o2.cost);
        });
        
        pq.offer(new Edge(start,0));
        
        while(!pq.isEmpty()){
            
            Edge current = pq.poll();
            
            if (distance[current.to] < current.cost) {
                continue;
            }
            
            for (Edge next : graph[current.to]){
                
                if (current.cost + next.cost < distance[next.to]){
                    
                    distance[next.to] = current.cost + next.cost;
                    pq.offer(new Edge(next.to, distance[next.to]));
                }
            }
        }
    }
}