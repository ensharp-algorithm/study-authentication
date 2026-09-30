class Solution {
    
    int answer = 0;
    int[][] visited;
    
    public int solution(int n) {
        visited = new int[n][n];
        dfs(n, 0, 0);
        return answer;
    }
    
    void dfs(int n, int depth, int cnt) {
        if (depth == n) {
            if (cnt == n) {
                answer++;
            }
            return;
        }
        
        // System.out.println("depth = " + depth + ", cnt = " + cnt);
        // for (int i = 0; i < n; i++) {
        //     for (int j = 0; j < n; j++) {
        //         System.out.print(visited[i][j] + " ");
        //     }
        //     System.out.println();
        // }
        
        for (int i = 0; i < n; i++) {
            if (visited[depth][i] == 0) {
                check(n, depth, i, 1);
                dfs(n, depth + 1, cnt + 1);
                check(n, depth, i, -1);
            }
        }
    }
    
    void check(int n, int initY, int initX, int flag) {
        int y = initY, x = initX;
        
        visited[y][x] += flag;
        
        while(y + 1 < n) {
            visited[++y][x] += flag;
        }
        
        y = initY;
        while(y + 1 < n && x - 1 >= 0) {
            visited[++y][--x] += flag;
        }
        
        y = initY;
        x = initX;
        while(y + 1 < n && x + 1 < n) {
            visited[++y][++x] += flag;
        }
    }
}