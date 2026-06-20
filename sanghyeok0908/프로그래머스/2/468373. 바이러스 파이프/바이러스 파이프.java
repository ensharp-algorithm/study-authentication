import java.util.*;

class Solution {
    
    int n, k;
    int[] arr;
    boolean[] visited;
    ArrayList<int[]>[] edges;
    List<Integer> infections;
    int initInfection;
    int answer = 0;
    
    public int solution(int n, int infection, int[][] e, int k) {
        this.n = n;
        this.k = k;
        arr = new int[k];
        edges = new ArrayList[n + 1];
        initInfection = infection;
        
        for (int i = 1; i <= n; i++) {
            edges[i] = new ArrayList<>();
        }
        
        for (int i = 0; i < n - 1; i++) {
            int from = e[i][0];
            int to = e[i][1];
            int type = e[i][2];
            
            edges[from].add(new int[] { to, type });
            edges[to].add(new int[] { from, type });
        }
        
        recursion(0);
        
        return answer;
    }
    
    void recursion(int depth) {
        if (depth == k) {
            infections = new ArrayList<>();
            infections.add(initInfection);
            visited = new boolean[n + 1];
            visited[initInfection] = true;
            
            // System.out.println("==============");
            for (int i = 0; i < k; i++) {
                // System.out.println("type = " + arr[i]);

                func(arr[i]);
            }
            
            answer = Math.max(answer, infections.size());
            return;
        }
        
        for (int i = 1; i <= 3; i++) {
            arr[depth] = i;
            recursion(depth + 1);
        }
    }
    
    void func(int type) {
        // System.out.println("infections size = " + infections.size());
        
        for (int i = 0; i < infections.size(); i++) {
            int infection = infections.get(i);
            
            for (int[] e : edges[infection]) {
                if (e[1] == type && !visited[e[0]]) {
                    visited[e[0]] = true;
                    // System.out.printf("from = %d, to = %d\n", infection, e[0]);
                    infections.add(e[0]);
                }
            }
        }
    }
}