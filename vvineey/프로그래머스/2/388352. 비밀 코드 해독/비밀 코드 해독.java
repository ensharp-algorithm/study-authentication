import java.util.*;

class Solution {
    
    ArrayList<HashSet<Integer>> candidates;
    
    public int solution(int n, int[][] q, int[] ans) {

        candidates = new ArrayList<>();
        dfs(new HashSet<>(), 1, 0, n);
        
        int answer = 0;
        
        for (HashSet<Integer> candidate : candidates){

            int pass = 0;
            
            for (int i = 0; i < q.length; i++){
                int cnt = 0;
                for (int j = 0; j < 5; j++){
                    if (candidate.contains(q[i][j])){
                        cnt++;
                    }
                }
                
                if (cnt != ans[i]){
                    break;
                }
                
                pass++;
            }
            if (pass == q.length){
                answer++;
            }
        }
        
        
        
        return answer;
    }
    
    //후보 하나를 선택
    private void dfs(HashSet<Integer> hs, int idx, int depth, int n){
    
        
        if (depth == 5){
            candidates.add(new HashSet<>(hs));
            return;
        }
        
        if (idx > n){
            return;
        }
        
        //선택
        hs.add(idx);
        dfs(hs, idx+1, depth+1, n);
            
        //비선택
        hs.remove(idx);
        dfs(hs, idx + 1,depth, n);
    }
}