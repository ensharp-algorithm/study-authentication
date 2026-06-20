import java.util.*;

class Solution {
    
    int[] parent, rank;
    
    public int solution(int n, int[][] costs) {
        parent = new int[n];
        rank = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
        
        Arrays.sort(costs, (o1, o2) -> Integer.compare(o1[2], o2[2]));
        
        int edgeCnt = 0;
        int answer = 0;
        for (int i = 0; i < costs.length; i++) {
            // System.out.println(Arrays.toString(costs[i]));
            int a = costs[i][0];
            int b = costs[i][1];
            int cost = costs[i][2];
            
            if (find(a) == find(b)) {
                continue;
            }
            
            union(a, b);
            edgeCnt++;
            answer += cost;
            
            if (edgeCnt == n - 1) {
                return answer;
            }
        }
        
        return -1;
    }
    
    void union(int a, int b) {
        int rootA = find(a);
        int rootB = find(b);
        
        if (rootA == rootB) {
            return;
        }
        
        if (rank[rootA] < rank[rootB]) {
            parent[rootA] = rootB;
        } else if (rank[rootA] > rank[rootB]) {
            parent[rootB] = rootA;
        } else {
            parent[rootB] = rootA;
            rank[rootA]++;
        }
    }
    
    int find(int a) {
        if (parent[a] == a) {
            return a;
        }
        
        return parent[a] = find(parent[a]);
    }
}