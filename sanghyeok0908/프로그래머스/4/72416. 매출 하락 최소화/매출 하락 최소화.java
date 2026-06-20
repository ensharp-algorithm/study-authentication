import java.util.*;

class Solution {
    
    int n;
    List<Integer>[] tree;
    int[] saleArr;
    int[][] dp;
    
    public int solution(int[] sales, int[][] links) {
        n = sales.length;
        tree = new ArrayList[n + 1];
        dp = new int[n + 1][2]; // [i][0]: i(팀장) 참석 X, [i][1]: i(팀장) 참석 O
        saleArr = new int[n + 1];
        
        for (int i = 1; i <= n; i++) {
            tree[i] = new ArrayList<>();
            saleArr[i] = sales[i - 1];
        }
        
        for (int[] l : links) {
            tree[l[0]].add(l[1]);
        }
        
        // print();
        dfs(1);
        return Math.min(dp[1][0], dp[1][1]);
    }
    
    void dfs(int cur) {
        dp[cur][1] = saleArr[cur];
        
        if (tree[cur].isEmpty()) {
            return;
        }
        
        int sum = 0;
        boolean isParticipated = false;
        int diffMin = Integer.MAX_VALUE;
        
        for (int child : tree[cur]) {
            dfs(child);
            
            if (dp[child][0] >= dp[child][1]) {
                sum += dp[child][1];
                isParticipated = true;
            } else {
                sum += dp[child][0];
                diffMin = Math.min(diffMin, dp[child][1] - dp[child][0]);
            }
        }
        
        dp[cur][1] += sum;
        
        if (isParticipated) {
            dp[cur][0] = sum;
        } else {
            dp[cur][0] = sum + diffMin;
        }
        
    }
    
    void print() {
        for (int i = 1; i <= n; i++) {
            System.out.println("parent = " + i);
            
            for (int node : tree[i]) {
                System.out.print(node + " ");
            }
            System.out.println();
        }
    }
}