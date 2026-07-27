import java.util.*;


class Solution {
    
    static int n;
    static int [][] costs;
    static int [] root;
    static int total;

    
    public int solution(int n, int[][] costs) {
        this.n = n;
        this.costs = costs;
        
        init();
        kruskal();
       
        return total;
    }
    
        
    private void init() {
        
        Arrays.sort(costs, (o1,o2) -> {
           if (o1[2] != o2[2]){
               return Integer.compare(o1[2], o2[2]);
            }
            if (o1[0] != o2[0]) {
                return Integer.compare(o1[0], o2[0]);
            }
            return Integer.compare(o1[1], o2[1]);
            
        });

        root = new int[n];
        
        //초기화
        for (int i = 0; i < n; i++){
            root[i] = i; 
        }
        
        this.total = 0;
    }
    
    private int find(int x){
        
        //최상위 루트
        if (root[x] == x){
            return x;
        }
        
        return root[x] = find(root[x]);
    }
    
    private boolean union(int x, int y) {
        
        int rootX = find(x);
        int rootY = find(y);
        
         if (rootX == rootY){
            return false;
        }
        
        root[rootY] = rootX;
        return true;
    }
    
    private void kruskal(){
        
        int cnt = 0;
        
        for (int[] edge : costs){
                        
            //선택할 수 있는 최종 간선의 수 = n-1
            if (cnt == n-1){
                break;
            }
            
            int v1 = edge[0];
            int v2 = edge[1];
            int cost = edge[2];

            //다른 집합이면 선택
            if (union(v1,v2)) {
                total += cost;
                cnt++;
            }
            // System.out.println(cnt + " 개 선택 : " + total);
            }
        }
}
