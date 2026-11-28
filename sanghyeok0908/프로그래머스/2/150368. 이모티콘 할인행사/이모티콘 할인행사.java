class Solution {
    
    int[] answer = new int[2];
    int n, m;
    
    public int[] solution(int[][] users, int[] emoticons) {
        n = users.length;
        m = emoticons.length;
        
        dfs(users, emoticons, new int[m], 0);
        return answer;
    }
    
    void dfs(int[][] users, int[] emoticons, int[] divide, int depth) {
        if (depth == m) {
            int cnt = 0, total = 0;
            
            for (int[] user : users) {
                int sum = 0;
                
                for (int i = 0; i < m; i++) {
                    if (user[0] <= divide[i]) {
                        sum += emoticons[i] - (emoticons[i] * divide[i] / 100);
                    }
                }
                
                if (user[1] <= sum) {
                    cnt++;
                } else {
                    total += sum;
                }
            }
            
            if (answer[0] < cnt) {
                answer[0] = cnt;
                answer[1] = total;
            } else if (answer[0] == cnt) {
                answer[1] = Math.max(answer[1], total);
            }
            return;
        }
        
        for (int i = 10; i <= 40; i += 10) {
            divide[depth] = i;
            dfs(users, emoticons, divide, depth + 1);
        }
    }
}