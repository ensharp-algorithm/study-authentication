import java.util.*;

class Solution {
    
    static int minLength;
    
    public int solution(String s) {
        
        int n = s.length();
        minLength = n; 
        
        //자를 수 있는 단위 후보 1 ~ n/2
        for (int k = 1; k <= n/2; k++){
            minLength = Math.min(minLength, cutString(s, k));
        }
        
        return minLength;
    }
    
    private int cutString(String s, int k){
        
        int cnt = 0 ;
        StringBuilder sb = new StringBuilder();
        String prev = "";
        
        // System.out.println("-------------");
        
        for (int i = 0; i < s.length(); i += k) {
            
            if (sb.toString().length() >= minLength){
                return Integer.MAX_VALUE;
            }
            
            int end = Math.min(i + k, s.length());
            String part = s.substring(i,end);
            // System.out.println(part);
            
            if (prev.length() == 0){
                prev = part;
                continue;
            }
            
            cnt++;
            
             if (!part.equals(prev)){
                if (cnt != 0 && cnt != 1 ){
                    sb.append(String.valueOf(cnt));
                }
                sb.append(prev);
                
                prev = part;
                cnt = 0;
            }
        }
        
        cnt++;
        if (cnt != 0 && cnt != 1 ){
            sb.append(String.valueOf(cnt));
        }
        sb.append(prev);
        
        // System.out.println("최종 >> " +  sb.toString());
        return  sb.toString().length();
    }
}