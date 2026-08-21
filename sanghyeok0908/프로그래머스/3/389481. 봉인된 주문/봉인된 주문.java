import java.util.*;

class Solution {
    
    public String solution(long n, String[] bans) {
        long[] arr = new long[bans.length];
        for (int i = 0; i < bans.length; i++) {
            arr[i] = encode(bans[i]);
        }
        
        Arrays.sort(arr);
        
        int k = 0;
        for (long val : arr) {
            if (n + k >= val) {
                k++;
            } else {
                break;
            }
        }
        
        return decode(n + k);
    }
    
    long encode(String str) {
        long result = 0;
        char[] arr = str.toCharArray();
        
        for (int i = 0; i < arr.length; i++) {
            result += Math.pow(26, arr.length - 1 - i) * (arr[i] - 'a' + 1);
        }
        return result;
    }
    
    String decode(long num) {
        StringBuilder sb = new StringBuilder();
        
        while(num > 0) {
            long r = num % 26;
            if (r == 0) {
                r = 26;
            }
            
            sb.append((char)('a' + r - 1));
            num = (num - r) / 26;
        }
        return sb.reverse().toString();
    }
}