import java.util.*;

class Solution {
    
    int[] dy = new int[] { -1, 1, 0, 0 };
    int[] dx = new int[] { 0, 0, -1, 1 };
    int n, m;
    int answer = Integer.MAX_VALUE;
    int[] rEnd = new int[2], bEnd = new int[2];
    boolean[][] rVisited, bVisited;
    
    public int solution(int[][] maze) {
        n = maze.length;
        m = maze[0].length;
        
        int[] rStart = new int[2], bStart = new int[2];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (maze[i][j] == 1) {
                    rStart[0] = i;
                    rStart[1] = j;
                } else if (maze[i][j] == 2) {
                    bStart[0] = i;
                    bStart[1] = j;
                } else if (maze[i][j] == 3) {
                    rEnd[0] = i;
                    rEnd[1] = j;
                } else if (maze[i][j] == 4) {
                    bEnd[0] = i;
                    bEnd[1] = j;
                }
            }
        }
        
        rVisited = new boolean[n][m];
        bVisited = new boolean[n][m];
        rVisited[rStart[0]][rStart[1]] = true;
        bVisited[bStart[0]][bStart[1]] = true;
        dfs(maze, rStart, bStart, 0);
        return answer == Integer.MAX_VALUE ? 0 : answer;
    }
    
    void dfs(int[][] maze, int[] rCur, int[] bCur, int cnt) {
        boolean isRedGoal = rCur[0] == rEnd[0] && rCur[1] == rEnd[1];
        boolean isBlueGoal = bCur[0] == bEnd[0] && bCur[1] == bEnd[1];
        
        if (isRedGoal && isBlueGoal) {
            answer = Math.min(answer, cnt);
            return;
        }
        
        // 1, 2 요구사항 충족
        List<int[]> rNextPoints = getNextPoints(maze, rEnd, rCur, rVisited);
        List<int[]> bNextPoints = getNextPoints(maze, bEnd, bCur, bVisited);
        
        for (int[] rp : rNextPoints) {
            for (int[] bp : bNextPoints) {
                // 4. 동시에 두 수레가 같은 칸일 경우
                if (rp[0] == bp[0] && rp[1] == bp[1]) {
                    continue;
                }
                // 5. 수레끼리 자리가 바뀔 경우
                if (rp[0] == bCur[0] && rp[1] == bCur[1] &&
                   bp[0] == rCur[0] && bp[1] == rCur[1]) {
                    continue;
                }
                
                // System.out.printf("red = (%d, %d), blue = (%d, %d)\n", rp[0], rp[1], bp[0], bp[1]);
                
                rVisited[rp[0]][rp[1]] = true;
                bVisited[bp[0]][bp[1]] = true;
                
                dfs(maze, rp, bp, cnt + 1);
                
                // 3. 도착하지 않았으면 백트래킹
                if (!isRedGoal) {
                    rVisited[rp[0]][rp[1]] = false;
                }
                if (!isBlueGoal) {
                    bVisited[bp[0]][bp[1]] = false;
                }
            }
        }
    }
    
    List<int[]> getNextPoints(int[][] maze, int[] end, int[] cur, boolean[][] visited) {
        List<int[]> result = new ArrayList<>();
        
        if (cur[0] == end[0] && cur[1] == end[1]) {
            result.add(cur);
            return result;
        }
        
        for (int i = 0; i < 4; i++) {
            int y = cur[0] + dy[i];
            int x = cur[1] + dx[i];
            
            if (y < 0 || y >= n || x < 0 || x >= m || 
                visited[y][x] || maze[y][x] == 5) {
                continue;
            }
            result.add(new int[] { y, x });
        }
        return result;
    }
    
}