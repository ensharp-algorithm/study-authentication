import java.util.*;

class Solution {
    
    class Node {
        int y, x, dy, dx, dir, cost;
        Node(int y, int x, int dir, int cost) {
            this.y = y;
            this.x = x;
            this.dir = dir;
            this.cost = cost;
        }
    }
    
    int[] dy = new int[] { -1, 1, 0, 0 };
    int[] dx = new int[] { 0, 0, -1, 1 };
    int[][] board;
    int n;
    
    public int solution(int[][] board) {
        this.board = board;
        n = board.length;
        
        int answer = Integer.MAX_VALUE;
        Queue<Node> queue = new ArrayDeque<>();
        int[][][] costMatrix = new int[n][n][4];
        
        queue.add(new Node(0, 0, -1, 0));
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                Arrays.fill(costMatrix[i][j], Integer.MAX_VALUE);
            }
        }
        
        while(!queue.isEmpty()) {
            Node node = queue.poll();
            
            if (node.y == n - 1 && node.x == n - 1) {
                answer = Math.min(answer, node.cost);
            }
            
            for (int i = 0; i < 4; i++) {
                int curY = node.y + dy[i];
                int curX = node.x + dx[i];
                boolean isCurve = false;
                
                if (!isIn(curY, curX) || 
                    board[curY][curX] == 1) {
                    continue;
                }
                
                if (node.dir != -1 && node.dir != i) {
                    isCurve = true;
                }
                
                int curCost = node.cost + 100;
                if (isCurve) {
                    curCost += 500;
                }
                
                if (costMatrix[curY][curX][i] < curCost) {
                    continue;
                }
                
                Node curNode = new Node(curY, curX, i, curCost);
                queue.add(curNode);
                costMatrix[curY][curX][i] = curCost;
                // System.out.printf("y = %d, x = %d, dir = %d, cost = %d\n", curY, curX, i, curCost);   
            }
        }
        
        return answer;
    }
    
    boolean isIn(int y, int x) {
        return y >= 0 && y < n && x >= 0 && x < n;
    }
}