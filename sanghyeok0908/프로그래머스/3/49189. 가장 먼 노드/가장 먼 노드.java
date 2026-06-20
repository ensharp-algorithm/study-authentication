import java.util.*;

class Solution {
    public int solution(int n, int[][] initEdges) {
        int answer = 0;
        List<Integer>[] edges = new ArrayList[n + 1];
        int[] distance = new int[n + 1];
        Queue<int[]> queue = new ArrayDeque<>(); 
        
        for (int i = 1; i <= n; i++) {
            edges[i] = new ArrayList<>();
        }
        
        for (int[] e : initEdges) {
            int from = e[0];
            int to = e[1];
            edges[from].add(to);
            edges[to].add(from);
        }
        
//         for (int i = 1; i <= n; i++) {
//             System.out.println("node = " + i);
            
//             for (int near : edges[i]) {
//                 System.out.print(near + " ");
//             }
//             System.out.println();
//         }
        
        queue.add(new int[]{1, 0});
        
        while(!queue.isEmpty()) {
            int[] poll = queue.poll();
            int node = poll[0];
            int dist = poll[1];
            
            for (int near : edges[node]) {
                if (near == 1 || distance[near] != 0) {
                    continue;
                }
                
                distance[near] = dist + 1;
                queue.add(new int[]{near, dist + 1});
                
                // System.out.println(near + " " + (dist + 1));
            }
        }
        
        // for (int i = 1; i <= n; i++) {
        //     System.out.print(distance[i] + " ");
        // }
        
        int max = 0;
        for (int i = 1; i <= n; i++) {
            max = Math.max(distance[i], max);
        }
        
        for (int i = 1; i <= n; i++) {
            if (max == distance[i]) {
                answer++;
            }
        }
        
        return answer;
    }
}