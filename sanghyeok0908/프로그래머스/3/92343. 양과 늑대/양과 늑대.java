import java.util.*;

class Solution {
    
    int n;
    List<Integer>[] list;
    int answer = 0;
    
    public int solution(int[] info, int[][] edges) {
        n = info.length;
        list = new ArrayList[n];
        
        for (int i = 0; i < n; i++) {
            list[i] = new ArrayList<>();
        }
        
        for (int[] edge : edges) {
            list[edge[0]].add(edge[1]);
        }
        
        List<Integer> l = new LinkedList<>();
        l.add(0);
        
        dfs(info, l, 0, 0, 0);
        return answer;
    }
    
    void dfs(int[] info, List<Integer> nexts, int cur, int sheep, int wolf) {
        if (info[cur] == 0) {
            sheep++;
        } else {
            wolf++;
        }
        
        if (sheep <= wolf) {
            return;
        }
        
        answer = Math.max(answer, sheep);
        
        List<Integer> copy = new ArrayList<>(nexts);
        
        copy.remove(Integer.valueOf(cur));
        copy.addAll(list[cur]);
        
        for (int next : copy) {
            dfs(info, copy, next, sheep, wolf);
        }
    }
}