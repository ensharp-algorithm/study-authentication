class Solution {

    boolean[][] arr;
    int m;
    int[] codes;
    boolean[] visited;
    int answer = 0;
    
    public int solution(int n, int[][] q, int[] ans) {
        m = q.length;
        arr = new boolean[m][n + 1];
        codes = new int[5];
        visited = new boolean[n + 1];
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < 5; j++) {
                arr[i][q[i][j]] = true;
            }
        }
        
        combination(0, 1, n, ans);
        return answer;
    }
    
    void combination(int depth, int start, int n, int[] ans) {
        if (depth == 5) {
            // for (int i = 0; i < 5; i++) {
            //     System.out.print(codes[i] + " ");
            // }
            // System.out.println();
            
            for (int i = 0; i < m; i++) {
                int cnt = 0;
                for (int j = 0; j < 5; j++) {
                    if (arr[i][codes[j]]) {
                        cnt++;
                    }
                }
                
                if (cnt != ans[i]) {
                    return;
                }
            }
            
            answer++;
            return;
        }
        
        for (int i = start; i <= n; i++) {
            if (visited[i]) {
                continue;
            }
            
            visited[i] = true;
            codes[depth] = i;
            
            combination(depth + 1, i + 1, n, ans);
            visited[i] = false;
        }
    }
}