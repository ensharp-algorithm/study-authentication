import java.util.*;
import java.io.*;


class Solution {
    public boolean solution(String[] phone_book) {
        
        HashSet<String> hs = new HashSet<>();
        
        for (String st : phone_book){
            
            for (int i = 0 ; i < st.length(); i++){
                hs.add(st.substring(0,i));
            }            
        }
        
        
        // for (String st : hs){
        //     System.out.println(st);
        // }
        
        
        for (String number : phone_book){
           if (hs.contains(number)){
               return false;
           }
        }
        
        
        
        return true;
    }
}