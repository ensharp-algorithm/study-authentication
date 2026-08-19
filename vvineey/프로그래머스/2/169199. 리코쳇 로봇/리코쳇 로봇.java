import java.util.*;

class Solution {

    public int solution(String[] board) {

        List<Integer> start = null;
        List<Integer> goal = null;
        
        for (int i = 0; i < board.length; i++){
            
            if (start != null && goal != null) break;
            
            for (int j = 0; j < board[0].length(); j++){
                if (board[i].charAt(j) == 'R'){
                    start = List.of(i,j,0);
                }
                if (board[i].charAt(j) == 'G'){
                    goal = List.of(i,j);
                }
            }
        }
        
        return bfs(board,start, goal);
    }
    
    private int bfs(String[] board, List<Integer> start, List<Integer> goal){
  
        //상하좌우 
        final int [] dx = {0,0,-1,1};
        final int [] dy = {1,-1,0,0};
        
        boolean [][] visited = new boolean[board.length][board[0].length()];
        Queue<List<Integer>> queue = new ArrayDeque<>();
        
        visited[start.get(0)][start.get(1)] = true;
        queue.offer(start);
        List<Integer> current =  start;
        int moving = 1;
        
        while(!arrival(current, goal) && !queue.isEmpty()) {
            
            current = queue.poll();
            int x = current.get(1);
            int y = current.get(0);
            moving = current.get(2);
            
            // System.out.println("> "+ y + " " + x + " : " + moving);
            
            for (int i = 0; i < 4; i++){
                int nx = x + dx[i];
                int ny = y + dy[i];
                
                if (nx < 0 || nx >= board[0].length()|| ny < 0 || ny >= board.length|| board[ny].charAt(nx) == 'D' ){
                    continue;
                }

                
                while(true) {
                    int slideX = nx + dx[i];
                    int slideY = ny + dy[i];
                    
                    if (slideX < 0 || slideX >= board[0].length()|| slideY < 0 || slideY >= board.length|| board[slideY].charAt(slideX) == 'D' ){
                        break;
                    }
                    
                    nx = slideX;
                    ny = slideY;
                }
                
                if (!visited[ny][nx]){
                    visited[ny][nx] = true;
                    queue.offer(List.of(ny,nx,moving+1));
                }
            }
        }
        
        return arrival(current, goal) ? moving : -1 ;
    }
    
    private boolean arrival(List<Integer> node1, List<Integer> node2){
        return (node1.get(1) == node2.get(1) && node1.get(0) == node2.get(0));
    }
}