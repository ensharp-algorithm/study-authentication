import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
    
        HashMap<String,Integer> hm = new HashMap<>();
        
        
        for (String[] s : clothes){
            hm.put(s[1], hm.getOrDefault(s[1],0)+1);
        }
        
        hm.forEach((key,value)->{
            System.out.println(key + " " +value);
        });
        
        
        int answer = 1;
        
        for (Integer v : hm.values()){
            System.out.println(v);
            answer *= (v+1);
        }
        
        
        return answer-1;
    }
}