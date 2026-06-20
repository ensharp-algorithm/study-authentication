import java.util.*;
import java.io.*;

class Solution {
    boolean solution(String s) {
        boolean answer = true;

        Stack <Character> st = new Stack<>();
        
     
        for (char c : s.toCharArray()){
            if (c == '('){
                st.push(c);
            }
            else{
                if (!st.isEmpty()){
                    st.pop();
                }
                else{
                    return false;
                }
            }
        
        }
        
        if (!st.isEmpty()){
            answer = false;
        }
      

        return answer;
    }
}