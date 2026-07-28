import java.util.*;

class Solution {

    static int[] distance;
    static List<int[]>[] graph;

    public int solution(int n, int[][] edge) {
        
        //1과 나머지 노드와의 거리
        this.distance = new int[n+1];
        this.graph = new ArrayList[n+1];
        
        for (int i = 0; i <= n; i++){
            graph[i] = new ArrayList<>();
        }
        
        for (int[] row: edge){
            int v1 = row[0];
            int v2 = row[1];
            
            graph[v1].add(new int[]{v2,1});
            graph[v2].add(new int[]{v1,1});
        }
        
        dijkstra(1);
        
        // System.out.println("---------");
        // for (int i : distance ){
        //     System.out.print(i + " ");
        // }
        // System.out.println("\n---------");
    
        int maxNum = Integer.MIN_VALUE;
        
         for (int i = 1; i < distance.length;i++){
            maxNum = Math.max(maxNum, distance[i]);
        }
        
        int cnt = 0;
        for (int i = 1; i < distance.length;i++){
            if (distance[i] == maxNum){ cnt++;}
        }
        
        return cnt;
    }
    
    private void dijkstra (int start){
        Arrays.fill(distance, Integer.MAX_VALUE);
        
        PriorityQueue<int[]> queue = new PriorityQueue<>((o1,o2)->{
            if (o1[1] != o2[1]){
                return Integer.compare(o1[1],o2[1]);
            }
            
            return Integer.compare(o1[0],o2[0]);
        });
        
        queue.offer(new int[]{start,0});
        distance[start] = 0;
        
        while(!queue.isEmpty()){
            
            int[] currentNode = queue.poll();

            if (currentNode[1] > distance[currentNode[0]]) {
                continue;
            }
            
            for (int[] edge : graph[currentNode[0]]){

                if (distance[edge[0]] > currentNode[1] + edge[1]){
                    distance[edge[0]] = currentNode[1] + edge[1]; //갱신
                    queue.offer(new int[]{edge[0], currentNode[1] + edge[1]});
                }
                
                // for (int i = 1; i < distance.length;i++){
                //     System.out.print(distance[i] + " ");
                // }
                // System.out.println();
            }
        }  
    }
}