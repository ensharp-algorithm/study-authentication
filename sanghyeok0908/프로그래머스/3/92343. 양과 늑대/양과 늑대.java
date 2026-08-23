import java.util.*;

class Solution {
    
    List<Integer>[] tree;
    int maxSheep = 0;
    
    public int solution(int[] info, int[][] edges) {
        tree = new ArrayList[info.length];
        
        for (int i = 0; i < info.length; i++) {
            tree[i] = new ArrayList<>();
        }
        
        for (int i = 0; i < edges.length; i++) {
            tree[edges[i][0]].add(edges[i][1]);
        }
        
        List<Integer> next = new ArrayList<>();
        next.add(0);
        recursion(info, 0, 0, 0, next);
        return maxSheep;
    }
    
    void recursion(int[] info, int cur, int sheep, int wolf, List<Integer> next) {
        if (info[cur] == 0) {
            sheep++;
        } else {
            wolf++;
        }
        
        if (wolf >= sheep) {
            return;
        }
        
        maxSheep = Math.max(maxSheep, sheep);
        
        List<Integer> newNext = new ArrayList<>(next);
        newNext.remove(Integer.valueOf(cur));
        
        if (tree[cur] != null) {
            newNext.addAll(tree[cur]);
        }
        
        // System.out.printf("cur = %d, sheep = %d, wolf = %d\n", cur, sheep, wolf);
        // System.out.println("child node = ");
        // for (Integer i : newNext) {
        //     System.out.print(i + " ");
        // }
        // System.out.println();
        
        for (Integer child : newNext) {
            recursion(info, child, sheep, wolf, newNext);
        }
    }
}