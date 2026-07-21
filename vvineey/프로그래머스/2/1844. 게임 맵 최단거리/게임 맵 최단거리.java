import java.util.*;

class Solution {
    
    private class Node{
        int row;
        int col;
        int total;
        
        Node(int row, int col, int total){
            this.row = row;
            this.col = col;
            this.total = total;
        }
    }
    
        
    //상 하 좌 우 기준 
    int[] dy = {1,-1,0,0};
    int[] dx = {0,0,-1,1};
    
    int [][] maps ;
    int n, m;
    boolean [][] visited;
    Queue<Node> queue;

    
    
    public int solution(int[][] maps) {
     
    
        this.maps = maps;
        n = maps.length;
        m = maps[0].length;
        
        visited = new boolean[n][m];
        
        queue = new ArrayDeque<>();
        
        //시작 지점 처리
        queue.offer(new Node(0,0,1));
        visited[0][0] = true;
        
        return bfs();
    }
    
    private int bfs(){
        
        while (!queue.isEmpty()){
            
            Node current = queue.poll();
//             System.out.println("Now " + current.row + " " +current.col + " " + current.total);
            
            if (current.row == n-1 && current.col == m-1){
                return current.total;
            }
            
            //상하좌우 탐색 
            for (int i = 0; i < 4;  i++){
                
                Node nextNode = new Node((current.row + dx[i]) , (current.col + dy[i]), (current.total+1));
                
                if (nextNode.row < 0 || nextNode.row >= n){
                    continue;
                }
                
                if (nextNode.col < 0 || nextNode.col >= m){
                    continue;
                }
                
                if (visited[nextNode.row][nextNode.col]){
                    continue;
                }
                
                
                if (maps[nextNode.row][nextNode.col] == 0){
                    continue;
                }
                
             
                visited[nextNode.row][nextNode.col] = true;
                queue.offer(nextNode);
            }
       }
        
        return -1;
        
    }
}