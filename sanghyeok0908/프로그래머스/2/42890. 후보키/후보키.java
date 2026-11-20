import java.util.*;

class Solution {
    
    int colCnt, rowCnt;
    List<Set<Integer>> answer = new ArrayList<>();
    
    public int solution(String[][] relation) {
        rowCnt = relation.length;
        colCnt = relation[0].length;
        
        for (int i = 1; i <= colCnt; i++) {
            bruthForce(relation, new int[i], 0, 0);
        }
        return answer.size();
    }
    
    void bruthForce(String[][] relation, int[] arr, int depth, int start) {
        if (arr.length == depth) {
            if (!isUnique(relation, arr)) {
                return;
            }
            
            Set<Integer> cur = new HashSet<>();
            
            for (int i : arr) {
                cur.add(i);
            }
            
            for (Set<Integer> set : answer) {
                if (cur.containsAll(set)) {
                    return;
                }
            }
            
            answer.add(cur);
            return;
        }
        
        for (int i = start; i < colCnt; i++) {
            arr[depth] = i;
            bruthForce(relation, arr, depth + 1, i + 1);
        }
    }
    
    boolean isUnique(String[][] relation, int[] arr) {
        Set<String> set = new HashSet<>();
        
        for (String[] r : relation) {
            StringBuilder sb = new StringBuilder();
            
            for (int i : arr) {
                sb.append(r[i])
                    .append(",");
            }   
            set.add(sb.toString());
        }
        return set.size() == rowCnt;
    }
}