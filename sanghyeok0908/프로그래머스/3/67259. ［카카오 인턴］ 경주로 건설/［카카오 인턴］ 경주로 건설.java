import java.util.*;

class Solution {
    
    int[] dy = new int[] { -1, 1, 0, 0 };
    int[] dx = new int[] { 0, 0, -1, 1 };

    public int solution(int[][] board) {
        int n = board.length;
        Queue<int[]> queue = new ArrayDeque<>();
        int[][][] costs = new int[n][n][4];
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                Arrays.fill(costs[i][j], Integer.MAX_VALUE);   
            }
        }
        
        Arrays.fill(costs[0][0], 0);
        queue.add(new int[] { 0, 0, -1, 0 }); // y, x, dir, cost
        
        while(!queue.isEmpty()) {
            int[] poll = queue.poll();
            
            for (int i = 0; i < 4; i++) {
                int y = poll[0] + dy[i];
                int x = poll[1] + dx[i];
                
                if (y < 0 || y >= n || x < 0 || x >= n || 
                    board[y][x] == 1) {
                    continue;
                }
                
                int cost = poll[3] + 100;
                
                if (poll[2] != -1 && poll[2] != i) {
                    cost += 500;
                }
                
                if (costs[y][x][i] <= cost) {
                    continue;
                }
                
                // System.out.printf("cur=(%d,%d), prev=(%d,%d), morePrev=(%d,%d), cost=%d\n", y, x, poll[0], poll[1], poll[2], poll[3], cost);
                
                costs[y][x][i] = cost;
                queue.add(new int[] { y, x, i, cost });
            }
        }
        
        int answer = Integer.MAX_VALUE;
        for (int i = 0; i < 4; i++) {
            answer = Math.min(answer, costs[n - 1][n - 1][i]);
        }
        return answer;
    }
}