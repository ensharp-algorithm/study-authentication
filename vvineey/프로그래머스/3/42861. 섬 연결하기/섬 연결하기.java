import java.util.*;

class Solution {
    
    static int[] root;

    public int solution(int n, int[][] costs) {
        
        Arrays.sort(costs, (o1,o2)->{
            return Integer.compare(o1[2],o2[2]);
        });
       
        root = new int[n];
        
        for (int i = 0; i < n; i++){
            root[i] = i;
        }
    
        return kruskal(n, costs);
    }
    
    private int find(int x){
        
        if (root[x] == x){
            return x;
        }
        
        return root[x] = find(root[x]);
    }
    
    private boolean union(int a, int b){
        
        int rootA = find(a);
        int rootB = find(b);
        
        if (rootA == rootB){
            return false;
        }
        
        root[rootB] = rootA;
        return true;
    }
    
    private int kruskal(int n, int[][] costs){
        
        int total = 0;
        int cnt = 0;
        
        for (int[] edge : costs){
            
            if (cnt == n-1){
                return total;
            }
            
            int a = edge[0];
            int b = edge[1];
            int cost = edge[2];
            
            if (union(a,b)){
                total += cost;
                // System.out.println(edge[0] + " " + edge[1]);
                cnt++;
            }
        }
        
        return total;
    }
}