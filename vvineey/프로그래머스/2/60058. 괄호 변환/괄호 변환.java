import java.util.*;

class Solution {
    public String solution(String p) {
        
        if (p.length() == 0){
            return "";
        }
        
        StringBuilder sb = new StringBuilder();
        StringBuilder u = new StringBuilder();
        Deque<String> stack = new ArrayDeque<>();
        
        int cnt = 0;
        
        for (char c: p.toCharArray()) {
            
            // System.out.println("c " + c);
            u.append(c);
            
            if (c == '('){
                cnt++;
            }
            else{
                cnt--;
            }
            
            if (cnt == 0){
                
                //올바른 괄호임
                if (u.charAt(0) == '('){
                    sb.append(u);
                }
                
                
                else{
                    sb.append('(');
                    
                    StringBuilder tmp = new StringBuilder();
                    
                    tmp.append(')');
                    
                    //양쪽 끝 제외
                    for (int j = 1; j < u.length() -1 ; j++){
                        char c2 = u.charAt(j);
                        
                        
                        if (c2 =='('){
                            tmp.append(')');
                        }
                        
                        else{
                            tmp.append('(');
                        }
                    }
                    
                    stack.push(tmp.toString());
                        
                    // System.out.println(stack);
                }
                u = new StringBuilder();
            }
        }
        
        
        while(!stack.isEmpty()){
            sb.append(stack.pop());  
        }
        
        return sb.toString();
    }
    
    
}