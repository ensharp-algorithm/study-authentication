import java.util.*;

class Solution {
    
    String target;
    String [] words;
    boolean [] visited;
    int n;
    int total;
    
    
    private void dfs(String current, int cnt) {
        
//         System.out.println();
//         System.out.println("now = " +  current + " cnt = " + cnt);
    
        
        if (current.equals(target)){
            total = Math.min(total, cnt);
            return;
        }
        
        if (cnt >= total) {
            return;
        }

        
         if (cnt >= n){
            return;
        }
        
        for (int i = 0 ; i < n ; i++){
      
            if (!visited[i] && canChange(current, words[i])) {
                // System.out.println("now = " +  current + " compare = " +  words[i]);
        
                visited[i] = true;
                dfs(words[i], cnt+1);
                visited[i] = false;
            }
        }
    }
    
    private boolean canChange(String s, String target){
        int cnt = 0;
        
        for (int i = 0; i < s.length(); i++){
            if (cnt > 1){
                return false;
            }
            if (s.charAt(i) != target.charAt(i)){
                cnt++;
            }
        }
    
        
        return cnt > 1 ? false : true;
    }
    
    
    public int solution(String begin, String target, String[] words) {
        this.target = target;
        this.words = words;
        this.n = words.length;
        this.total = Integer.MAX_VALUE;
        this.visited = new boolean[n];
        
        Set<String> wordSet = new HashSet<>();
        
        for (String s : words){
            wordSet.add(s);
        }
        
        if (!wordSet.contains(target)){
            return 0;
        }
        
        
        dfs(begin,0);
        
        return total;
        
    }
    

    //1. begin == hit
    //2. hit의 후보 - hot
    //3. hot의 후보 - dot / lot / 
    //
    
}