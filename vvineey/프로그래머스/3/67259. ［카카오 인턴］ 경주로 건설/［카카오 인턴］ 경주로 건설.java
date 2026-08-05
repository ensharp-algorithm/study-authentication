import java.util.*;

class Solution {

    static final int[] dx = {0, 0, -1, 1};
    static final int[] dy = {1, -1, 0, 0};

    static int[][] board;
    static int[][][] costs;
    static PriorityQueue<Node> queue;
    static int n;

    static class Node {
        int x;
        int y;
        int cost;
        int prev;

        Node(int x, int y, int cost, int prev) {
            this.x = x;
            this.y = y;
            this.cost = cost;
            this.prev = prev;
        }
    }

    public int solution(int[][] board) {
        this.board = board;
        n = board.length;

        if (n == 1) {
            return 0;
        }

        costs = new int[n][n][4];
        queue = new PriorityQueue<>((o1,o2)->{
            return Integer.compare(o1.cost, o2.cost);
        });

        for (int x = 0; x < n; x++) {
            for (int y = 0; y < n; y++) {
                Arrays.fill(costs[x][y], Integer.MAX_VALUE);
            }
        }

        queue.offer(new Node(0, 0, 0, -1));
        dijkstra();

        int answer = Integer.MAX_VALUE;

        for (int i = 0; i < 4; i++) {
            answer = Math.min(answer,costs[n - 1][n - 1][i]);
        }

        return answer;
    }

    private void dijkstra() {
        
        while (!queue.isEmpty()) {
            
            Node current = queue.poll();

            if (current.prev != -1 && costs[current.x][current.y][current.prev] < current.cost) {
                continue;
            }

            for (int i = 0; i < 4; i++) {
                
                int nx = current.x + dx[i];
                int ny = current.y + dy[i];

                if (nx < 0 || nx >= n || ny < 0 || ny >= n) {
                    continue;
                }

                if (board[nx][ny] == 1) {
                    continue;
                }

                int nextCost = current.cost + 100;

                if (current.prev != -1 && current.prev != i) {
                    nextCost += 500;
                }

                if (nextCost < costs[nx][ny][i]) {
                    
                    // System.out.println("갱신 : " + nx + " "+ ny + " 비용 : " + nextCost);
                    costs[nx][ny][i] = nextCost;

                    queue.offer(new Node(nx,ny,nextCost,i));
                }
            }
        }
    }
}