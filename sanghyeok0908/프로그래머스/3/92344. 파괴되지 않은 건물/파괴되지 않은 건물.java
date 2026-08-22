class Solution {
    
    public int solution(int[][] board, int[][] skill) {
        int N = board.length;
        int M = board[0].length;
        int[][] prefixSum = new int[N + 1][M + 1];
        
        for (int[] s : skill) {
            if (s[0] == 1) {
                prefixSum[s[1]][s[2]] -= s[5];
                prefixSum[s[1]][s[4] + 1] += s[5];
                prefixSum[s[3] + 1][s[2]] += s[5];
                prefixSum[s[3] + 1][s[4] + 1] -= s[5];  
            } else {
                prefixSum[s[1]][s[2]] += s[5];
                prefixSum[s[1]][s[4] + 1] -= s[5];
                prefixSum[s[3] + 1][s[2]] -= s[5];
                prefixSum[s[3] + 1][s[4] + 1] += s[5];   
            }
        }
        
        // for (int i = 0; i < M; i++) {
        //     for (int j = 0; j < N; j++) {
        //         System.out.print(prefixSum[i][j] + " ");
        //     }
        //     System.out.println();
        // }
        
        for (int i = 0; i < N; i++) {
            for (int j = 1; j < M; j++) {
                prefixSum[i][j] += prefixSum[i][j - 1];
            }
        }
        
        for (int i = 0; i < M; i++) {
            for (int j = 1; j < N; j++) {
                prefixSum[j][i] += prefixSum[j - 1][i];
            }
        }
        
        int answer = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (board[i][j] + prefixSum[i][j] > 0)
                    answer++;
                // System.out.print(prefixSum[i][j] + " ");
            }
            // System.out.println();
        }
        return answer;
    }
}