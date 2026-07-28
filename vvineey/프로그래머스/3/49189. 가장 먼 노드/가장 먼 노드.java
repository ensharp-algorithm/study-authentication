import java.util.*;

class Solution {

    static int[] distance;
    static List<Integer>[] graph;

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
            
            graph[v1].add(v2);
            graph[v2].add(v1);
        }
    
        bfs(1);
    
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

    
    private void bfs(int start){
        Arrays.fill(distance, -1);
        
        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(start);
        distance[start] = 0;
        
        while(!queue.isEmpty()){
            int current = queue.poll();
//             System.out.println(current);
            
//             for (int i = 1; i<distance.length;i++){
//                 System.out.print(distance[i] + " ");
//             }
//             System.out.println();
            
            for (int adj : graph[current]) {
                            
                if (distance[adj] != -1){
                    continue;
                }
                distance[adj] = distance[current]+1;
                queue.offer(adj);
            }
        }
    }
}