import java.util.*;

class Solution {
    
    public int solution(String s) {
        
        int n = s.length();
        int answer = n;
        StringBuilder sb = new StringBuilder();
        
        for(int range = 1; range <= n/2; range++){
            String standard = "";
            
            int cnt = 1;
            for (int i = 0; i < n; i += range){
                
                String now = s.substring(i, Math.min(n, i + range));
                
                if (standard.isEmpty()){
                    standard = now;
                    continue;
                }
            
                if (now.equals(standard)){
                    cnt++;
                }
                
                else{
                    
                    if (cnt > 1){
                        sb.append(cnt);
                    }
                    
                    sb.append(standard);
                    standard = now;
                    cnt = 1;
                }
                
            }
            
            if (cnt > 1){
                sb.append(cnt);
            }
            sb.append(standard);
            answer = Math.min(answer, sb.length());
            
            sb.setLength(0);
        }
        
        return answer;
    }
}