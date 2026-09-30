class Solution {
    
    int answer = 0;
    boolean[] col, dia1, dia2;
    
    public int solution(int n) {
        col = new boolean[n];
        dia1 = new boolean[n * 2];
        dia2 = new boolean[n * 2];
        dfs(n, 0);
        return answer;
    }
    
    void dfs(int n, int depth) {
        if (depth == n) {
            answer++;
            return;
        }
        
        for (int i = 0; i < n; i++) {
            int d1 = depth + i;
            int d2 = depth - i + n - 1;
            
            if (col[i] || dia1[d1] || dia2[d2]) {
                continue;
            }
            
            col[i] = true;
            dia1[d1] = true;
            dia2[d2] = true;
            dfs(n, depth + 1);
            
            col[i] = false;
            dia1[d1] = false;
            dia2[d2] = false;
        }
    }
}