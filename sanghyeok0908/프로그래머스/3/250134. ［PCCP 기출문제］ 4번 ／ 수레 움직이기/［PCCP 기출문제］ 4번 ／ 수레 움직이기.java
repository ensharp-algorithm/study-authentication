import java.util.*;

class Solution {
    
    int[] dy = new int[] { -1, 0, 1, 0 };
    int[] dx = new int[] { 0, 1, 0, -1 };
    int[] sRed = new int[2], sBlue = new int[2];
    int[] eRed = new int[2], eBlue = new int[2];
    int n, m;
    boolean[][] visitRed, visitBlue;
    int answer = Integer.MAX_VALUE;
    
    public int solution(int[][] maze) {
        n = maze.length;
        m = maze[0].length;
        visitRed = new boolean[n][m];
        visitBlue = new boolean[n][m];
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (maze[i][j] == 1) {
                    sRed[0] = i;
                    sRed[1] = j;
                } else if (maze[i][j] == 2) {
                    sBlue[0] = i;
                    sBlue[1] = j;
                } else if (maze[i][j] == 3) {
                    eRed[0] = i;
                    eRed[1] = j;
                } else if (maze[i][j] == 4) {
                    eBlue[0] = i;
                    eBlue[1] = j;
                }
            }
        }
        
        visitRed[sRed[0]][sRed[1]] = true;
        visitBlue[sBlue[0]][sBlue[1]] = true;
        dfs(sRed[0], sRed[1], sBlue[0], sBlue[1], 0, maze);
        return answer == Integer.MAX_VALUE ? 0 : answer;
    }
    
    void dfs(int ry, int rx, int by, int bx, int cnt, int[][] maze) {
        // System.out.printf("cuRed = (%d,%d), curBlue = (%d,%d), cnt = %d\n", ry, rx, by, bx, cnt, cnt);
        
        if (eRed[0] == ry && eRed[1] == rx && 
           eBlue[0] == by && eBlue[1] == bx) {
            answer = Math.min(answer, cnt);
            return;
        }
        
        boolean redArrived = ry == eRed[0] && rx == eRed[1];
        boolean blueArrived = by == eBlue[0] && bx == eBlue[1];
        List<int[]> redPoints = getPoints(ry, rx, eRed, maze, visitRed);
        List<int[]> bluePoints = getPoints(by, bx, eBlue, maze, visitBlue);
        
        for (int[] red : redPoints) {
            for (int[] blue : bluePoints) {
                // 동시에 같은 칸 검사
                if (red[0] == blue[0] && red[1] == blue[1]) {
                    continue;
                }
                // 수레끼리 자리 바꾸는지 검사
                if (red[0] == by && red[1] == bx &&
                   blue[0] == ry && blue[1] == rx) {
                    continue;
                }
                
                visitRed[red[0]][red[1]] = true; 
                visitBlue[blue[0]][blue[1]] = true;
                
                dfs(red[0], red[1], blue[0], blue[1], cnt + 1, maze);
                
                if (!redArrived) {
                    visitRed[red[0]][red[1]] = false;
                }
                if (!blueArrived) {
                    visitBlue[blue[0]][blue[1]] = false;
                }
            }
        }
    }
    
    List<int[]> getPoints(int y, int x, int[] end, int[][] maze, boolean[][] visited) {
        List<int[]> result = new ArrayList<>();
        
        if (y == end[0] && x == end[1]) {
            result.add(new int[] { y, x });
            return result;
        }
        
        for (int i = 0; i < 4; i++) {            
            int curY = y + dy[i];
            int curX = x + dx[i];
            
            if (isIn(curY, curX) && 
                maze[curY][curX] != 5 &&
               !visited[curY][curX]) {
                result.add(new int[] { curY, curX });
            }
        }
        return result;
    }
    
    boolean isIn(int y, int x) {
        return y >= 0 && y < n && x >= 0 && x < m;
    }
}