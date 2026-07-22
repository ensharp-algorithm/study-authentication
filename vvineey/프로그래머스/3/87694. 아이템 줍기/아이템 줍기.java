import java.util.*;

class Solution {

    class Node {
        int x;
        int y;
        int distance;

        Node(int x, int y) {
            this.x = x;
            this.y = y;
            this.distance = 0;
        }

        Node(int x, int y, int distance) {
            this.x = x;
            this.y = y;
            this.distance = distance;
        }
    }

    // 상하좌우
    final int[] dx = {0, 0, -1, 1};
    final int[] dy = {1, -1, 0, 0};

    boolean[][] line;
    boolean[][] visited;

    int total;

    Node start;
    Node goal;

    Queue<Node> queue;

    private void bfs() {

        while (!queue.isEmpty()) {

            Node current = queue.poll();
            // System.out.println("current node\n"+ current.x / 2 + " "+ current.y / 2 + " "+ current.distance / 2 + "\n");

            if (current.x == goal.x && current.y == goal.y) {
                total = current.distance;

                // System.out.println("\nGoal!!!!!\n"+ total / 2 + " = "+ current.x / 2 + " "+ current.y / 2);
                return;
            }

            for (int i = 0; i < 4; i++) {

                int nX = current.x + dx[i];
                int nY = current.y + dy[i];

                if (nX < 0 || nX >= line.length|| nY < 0 || nY >= line[0].length) {
                    continue;
                }

                if (visited[nX][nY]) {
                    continue;
                }

                if (!line[nX][nY]) {
                    continue;
                }

                Node nextNode = new Node(nX,nY,current.distance + 1);

                visited[nX][nY] = true;
                // System.out.println("offer\n"+ nX / 2 + " "+nY / 2 + " "+ (current.distance + 1) / 2);

                queue.offer(nextNode);
            }
            // System.out.println();
        }
    }

    public int solution(int[][] rectangle,int characterX,int characterY,int itemX,int itemY) {
        
        start = new Node(characterX * 2, characterY * 2);
        goal = new Node(itemX * 2, itemY * 2);

        total = 0;

        line = new boolean[101][101];
        visited = new boolean[101][101];

 
        for (int[] r : rectangle) {

            // 직사각형 좌표 자체를 2배 확대
            int x1 = r[0] * 2;
            int y1 = r[1] * 2;
            int x2 = r[2] * 2;
            int y2 = r[3] * 2;

            for (int x = x1; x <= x2; x++) {
                line[x][y1] = true;
                line[x][y2] = true;
            }

            for (int y = y1; y <= y2; y++) {
                line[x1][y] = true;
                line[x2][y] = true;
            }
        }

     
        for (int[] r : rectangle) {

            int x1 = r[0] * 2;
            int y1 = r[1] * 2;
            int x2 = r[2] * 2;
            int y2 = r[3] * 2;

            for (int x = x1 + 1; x < x2; x++) {
                for (int y = y1 + 1; y < y2; y++) {
                    line[x][y] = false;
                }
            }
        }
        
        
        //
        queue = new ArrayDeque<>();

        queue.offer(start);
        visited[start.x][start.y] = true;

        bfs();

        return total / 2;
    }
}