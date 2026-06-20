import java.util.*;

class Solution {
    
    int[][] tree;
    int maxShape = 0;
    
    public int solution(int[] info, int[][] edges) {
        tree = new int[info.length][3]; // {info, left, right}
        
        for (int i = 0; i < info.length; i++) {
            tree[i][0] = info[i];
        }
        
        for (int i = 0; i < edges.length; i++) {
            if (tree[edges[i][0]][1] == 0) {
                tree[edges[i][0]][1] = edges[i][1];
            } else {
                tree[edges[i][0]][2] = edges[i][1];
            }
        }
        
        TreeSet<Integer> queue = new TreeSet<>();
        queue.add(0);
        
        recursion(0, 0, 0, queue);
        
        return maxShape;
    }
    
    void recursion(int cur, int shape, int wolf, TreeSet<Integer> set) {
        if (tree[cur][0] == 0) {
            shape++;
        } else {
            wolf++;
        }
        
        // System.out.printf("cur = %d, shape = %d, wolf = %d\n", cur, shape, wolf);
        
        if (shape <= wolf) {
            return;
        }
        
        maxShape = Math.max(maxShape, shape);
        
        TreeSet<Integer> newSet = new TreeSet<>(set);
        newSet.remove(cur);
        
        if (tree[cur][1] != 0) {
            newSet.add(tree[cur][1]);
        }
        if (tree[cur][2] != 0) {
            newSet.add(tree[cur][2]);
        }
        
        for (Integer i : newSet) {
            recursion(i, shape, wolf, newSet);
        }
    }
}