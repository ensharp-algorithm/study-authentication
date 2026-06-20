import java.util.*;
import java.io.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
    
        HashMap<String, Integer> hm = new HashMap<>();
        
        for (String name : participant) {
            hm.put(name,hm.getOrDefault(name,0)+1);
        }
        
        for (String name : completion){
            hm.put(name, hm.get(name)-1);
        }
        
        for (String name : hm.keySet()){
            if (hm.get(name) != 0 ){
                return name;
            }
        }
        
        return "";
    }
    
}