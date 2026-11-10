import java.util.*;

class Solution {
    
    int[] dy = {1,-1,0,0};
    int[] dx = {0,0,-1,1};
    int[][] visited;
    int n,m;
    
    public int solution(int[][] maps) {
        
        n = maps.length;
        m = maps[0].length;
        visited = new int[n][m];
        
        for (int [] row : visited){
            Arrays.fill(row,-1);    
        }
        
        bfs(maps, new int[]{0,0});
        
        return visited[n-1][m-1];
    }
    
    private void bfs(int[][] maps, int[] start){
        
        Queue<int[]> queue = new ArrayDeque<>();
        
        //
        visited[start[0]][start[1]] = 1;
        queue.offer(start);
        
        while(!queue.isEmpty()){
            int[] current = queue.poll();
            int y = current[0];
            int x = current[1];
            int cnt = visited[y][x];
            
            for (int i = 0; i < 4; i++){
                int nextY = y + dy[i];
                int nextX = x + dx[i];
                int nextCnt = cnt + 1;
                
                if (nextY < 0 || nextX < 0 || nextY >= n || nextX >= m){
                    continue;
                }
                
                if (maps[nextY][nextX] == 0 || visited[nextY][nextX] > -1){
                    continue;
                }
                
                visited[nextY][nextX] = nextCnt;
                queue.offer(new int[]{nextY, nextX});
            }
        }
        
    }
    
}