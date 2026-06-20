import java.util.*;
import java.io.*;


class Solution {
    public String solution(int[] numbers) {
     
        String [] arr = new String[numbers.length];
        String answer = "000";
        
        int cnt = 0;
        for (int n : numbers){
            arr[cnt++] = String.valueOf(n);
        } 
        
        Arrays.sort(arr,(o1,o2)->
                   (o2+o1).compareTo(o1+o2));
        
        if (arr[0].equals("0")){
            return "0";
        }
        
        
        StringBuilder sb = new StringBuilder();
        
        for (String s : arr){
            sb.append(s);
        }
        
        
        
        return sb.toString();
        
    }
}