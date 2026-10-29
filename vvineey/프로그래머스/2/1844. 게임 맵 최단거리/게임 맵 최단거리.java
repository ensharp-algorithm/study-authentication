import java.util.*;

class Solution {
    static int[] dx = {0,0,-1,1};
    static int[] dy = {1,-1,0,0};
    
    public int solution(int[][] maps) {
                
        return bfs(maps, List.of(0,0));
    }
    
    private int bfs(int[][] maps, List<Integer> start){
        
        int n = maps.length;
        int m = maps[0].length;
        
        boolean[][] visited = new boolean[n][m];
        Queue<List<Integer>> queue = new ArrayDeque<>();
        int[][][] parent = new int[n][m][2];
    
        visited[0][0] = true;
        queue.offer(start);
        
        while(!queue.isEmpty()){
            List<Integer> curr = queue.poll();
            
            if (curr.get(0) == n-1 && curr.get(1) == m-1){
                System.out.println("도착");
                return getDistance(parent,n,m);
            }
            
            for (int i = 0; i < 4; i++){
                int nextY = curr.get(0) + dy[i];
                int nextX = curr.get(1) + dx[i];
                
                if (nextX < 0 || nextY < 0 || nextY >= n || nextX >= m){
                    continue;
                }
                if (visited[nextY][nextX] || maps[nextY][nextX] == 0){
                    continue;
                }
                
                parent[nextY][nextX][0] = curr.get(0);
                parent[nextY][nextX][1] = curr.get(1);
                
                visited[nextY][nextX] = true;
                queue.offer(List.of(nextY,nextX));
            }
        }
        
        return -1;
    }
    
    private int getDistance(int[][][] parent, int n, int m){
        
        int y = n-1;
        int x = m-1;
        
        int cnt = 0;
        
        while(true){
            
            // System.out.println(y + " " + x);
            
            if (x == 0 && y == 0){
                break;
            }
            
            
            int prevY = parent[y][x][0];
            int prevX = parent[y][x][1];
            y = prevY;
            x = prevX;
            cnt++;
        }
        return (cnt+1);     
    }
}