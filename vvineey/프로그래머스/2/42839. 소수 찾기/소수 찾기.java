import java.util.*;

class Solution {
    
    int n;
    boolean [] visited;
    String str;
    HashSet<Integer> hs;
 
    private boolean isPrimeNum(String num){
        
        if (Integer.parseInt(num) < 2){
            return false;
        }
    
        for (int i = 2; i * i <= Integer.parseInt(num) ; i++){
            if (Integer.parseInt(num) % i == 0){
                return false;
            }
        }
        
        System.out.println("true !! " + Integer.parseInt(num));
        return true;
    }
    
       
    private void dfs(String num){
        
    
        if (!num.isEmpty()){
            if (isPrimeNum(num)){
                hs.add(Integer.parseInt(num));
            }
        }
        
    
        for (int i = 0; i < n; i++){
            
             if (visited[i]) {
                continue;
            }

            visited[i] = true;
            
            dfs(num + str.charAt(i));
            
            visited[i] = false;
        }
    }
    
    
    
    public int solution(String numbers) {
        
        n = numbers.length();
        str = numbers;
        visited = new boolean[n+1];
        hs = new HashSet<>();
        
        String num = "";
        
        dfs(num);
        
        //1 2 3
        // 1
        // 1 2
        // 1 2 3
        // 1 3 
        // 1 3 2
        
        // 2 
        // 2 1
        // 2 1 3
        // ..
   
        return hs.size();
    }
}