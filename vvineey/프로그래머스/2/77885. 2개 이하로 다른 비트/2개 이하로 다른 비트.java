import java.util.*;

class Solution {
    public long[] solution(long[] numbers) {
    
        int n = numbers.length;
        long[] answer = new long[n];
        
        for (int i = 0; i < n; i++){
            
            // System.out.println(numbers[i]);
            
            if (numbers[i] % 2 == 0){
                answer[i] = numbers[i]+ 1L;
            }
            
            else{
                String binary = "0" + Long.toBinaryString(numbers[i]);
                char[] bits = binary.toCharArray();
                
                binary = String.valueOf(dfs(bits, bits.length-1));
                answer[i] = Long.parseLong(binary, 2);
            }
            
        }
        
        return answer;
    }
    
    private char[] dfs(char[] bits, int idx) {
        
        if (idx == 0){
            bits[idx] = '1';
            bits[idx+1] = '0';
            return bits;
        }
        
        if (bits[idx] == '0'){
            bits[idx] = '1';
            bits[idx+1] = '0';
            return bits;
        }
        return dfs(bits, idx - 1);
    }
}