import java.util.*;

class Solution {
    
    int[] dy = new int[] {-1, 1, 0, 0, -1, -1, 1, 1};
    int[] dx = new int[] {0, 0, -1, 1, -1, 1, -1, 1};
    int N, M;
    boolean[][] dangerArea;
    
    public int solution(int[][] board) {
        int answer = 0;
        
        N = board.length;
        M = board[0].length;
        dangerArea = new boolean[N][M];
        
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (board[i][j] == 1) {
                    bfs(i, j);
                }
            }
        }
        
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (!dangerArea[i][j])
                    answer++;
            }
        }
        return answer;
    }
    
    void bfs(int y, int x) {
        dangerArea[y][x] = true;
        
        for (int i = 0; i < 8; i++) {
            int curY = y + dy[i];
            int curX = x + dx[i];

            if (curY < 0 || curY >= N || curX < 0 || curX >= M || dangerArea[curY][curX]) {
                continue;
            }

            dangerArea[curY][curX] = true;
        }
    }
}