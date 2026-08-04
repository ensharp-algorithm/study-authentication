import java.util.*;

class Solution {
    int[] dr = new int[] { -1, 0, 1, 0 };
    int[] dc = new int[] { 0, 1, 0, -1 };
    
    public int[] solution(String[] grid) {
        int R = grid.length;
        int C = grid[0].length();
        boolean[][][] visited = new boolean[R][C][4];
        List<Integer> result = new ArrayList<>();
        
        for (int r = 0; r < R; r++) {
            for (int c = 0; c < C; c++) {
                for (int i = 0; i < 4; i++) {
                    if (visited[r][c][i]) {
                        continue;
                    }
                    
                    int len = 0;
                    int nr = r;
                    int nc = c;
                    int nd = i;
                    
                    // System.out.printf("%d %d %d\n", nr, nc, nd);
                    
                    while(!visited[nr][nc][nd]) {
                        visited[nr][nc][nd] = true;
                        len++;
                        
                        char ch = grid[nr].charAt(nc);
                        if (ch == 'L') {
                            nd += 3;
                        } else if (ch == 'R') {
                            nd++;
                        }
                        
                        nd %= 4;
                        nr = (nr + dr[nd] + R) % R;
                        nc = (nc + dc[nd] + C) % C;
                    }
                    result.add(len);
                }
            }
        }
        
        Collections.sort(result);
        int[] answer = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            answer[i] = result.get(i);
        }
        return answer;
    }
}