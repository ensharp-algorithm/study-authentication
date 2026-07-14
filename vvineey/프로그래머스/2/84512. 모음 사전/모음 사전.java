import java.util.*;

class Solution {
    
    int n;
    String str;
    int idx;
    int answer;
    String target;
    
    private void dfs(String current){
        
        System.out.println("idx = " + idx + " " + current);
        
        if (current.equals(target)){ 
            
            System.out.println("Find!!!!!!!!");
            answer = idx;
            return;
        }
        
        if (current.length() == 5){
            return;
        }
    
     
        for (int i = 0; i < str.length(); i++){
            
            if (answer != 0){
                return;
            }
       
            idx++;
            
            dfs(current + str.charAt(i));
        }
    }
    
    public int solution(String word) {
        
        idx = 0;
        str = "AEIOU";
        target = word;
        answer = 0;
        
        
        dfs("");
        
        
        
        // A
        // AA        
        // AAA
        // AAAA
        // AAAAA
        
        // AAAAE
        
        
        return answer;
    }
}