import java.util.*;

class Solution {
    
    //상하좌우(row 먼저 처리)
    static int[] dx = {0,0,-1,1};
    static int[] dy = {1,-1,0,0};
    static ArrayList<int[]>[] robots ;
    static boolean [][] visited;
    
    public int solution(int[][] points, int[][] routes) {
    
        
        //경로 계산
        robots = new ArrayList[routes.length];
        
        for (int i = 0; i < routes.length;i++){
            robots[i] = new ArrayList<>();
        }
        
        
        int maxCnt = Integer.MIN_VALUE;
        
        for (int i = 0; i < routes.length;i++){
            int[] route = routes[i];
            robots[i].addFirst(points[route[0]-1]);
            
            for (int j = 0; j < route.length-1; j++){
                visited = new boolean[101][101];
                
                bfs(i, points[route[j]-1] , points[route[j+1]-1]);
            }
            maxCnt = Math.max(robots[i].size(),maxCnt);
        }
        
//         for (int i = 0; i < routes.length;i++){
//             System.out.println(i + "번째 로봇의 경로");
            
//             for (int[] p : robots[i]) {
//                 System.out.println(p[0] + " " + p[1]);
//             }
//         }
        
        //충돌 계산
        System.out.println(maxCnt);
        int total = 0 ;
        
        for (int i = 0; i < maxCnt;i++){
            HashMap<List<Integer>, Integer > hm = new HashMap<>();
            
            for (int j = 0; j < robots.length;j++){
                if (robots[j].size() <= i){
                    continue;
                }
            
                List<Integer> key = List.of(robots[j].get(i)[0], robots[j].get(i)[1]);
                // System.out.println(key);
                hm.put(key, hm.getOrDefault(key, 0) + 1);
            }

            // System.out.println(hm);
            for (int value : hm.values()) {
                if (value >= 2) {
                    total++;
                }
            }
        }
     
        
        return total;
    }
    
    private void bfs(int robotIdx, int[] start, int[] end){
        
//         System.out.println(robotIdx + "번째 로봇의 경로 탐색");
//         System.out.println("출발지점 " + start[0] + " " + start[1] +" " + end[0] + " " + end[1]);
        
        Queue<int[]> queue = new ArrayDeque<>();
        int[][][] parent = new int[101][101][2];

        visited[start[0]][start[1]] = true;
        queue.offer(start);
        
        while(!queue.isEmpty()){
            int [] curr = queue.poll();
            
            if (curr[0] == end[0] && curr[1] == end[1]){
                break;
            }
            
            for (int i = 0 ; i < 4; i++){
                int nx = curr[1] + dx[i];
                int ny = curr[0] + dy[i];
                
                
                if (nx <= 0 || ny <= 0 || nx > 100 || ny > 100){
                    continue;
                }
                
                if (visited[ny][nx]){
                    continue;
                }
                
                visited[ny][nx] = true;
                
                int [] next = new int []{ny, nx};
                parent[ny][nx][0] = curr[0];
                parent[ny][nx][1] = curr[1];

                queue.offer(next);
            } 
        }
        
        ArrayList<int[]> path = new ArrayList<>();

        int[] cur = end;

        while (!(cur[0] == start[0] && cur[1] == start[1])) {
            path.add(cur);
            cur = parent[cur[0]][cur[1]];
        }
        
        Collections.reverse(path);
        
        for (int[] p : path) {
            robots[robotIdx].add(p);
        }
    }
}