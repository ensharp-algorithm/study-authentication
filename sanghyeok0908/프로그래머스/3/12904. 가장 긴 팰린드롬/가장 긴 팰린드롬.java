import java.util.*;

class Solution {
    
    int n;
    char[] arr;
    
    public int solution(String s) {
        int maxLen = 1;
        n = s.length();
        arr = s.toCharArray();
        
        for (int i = 0; i < n - 1; i++) {
            
            for (int j = i + 1; j < n; j++) {
                int len = j - i + 1;
                
                if (len > maxLen && isPalinfrome(i, j)) {
                    maxLen = len;
                }
            }
        }
        return maxLen;
    }
    
    boolean isPalinfrome(int left, int right) {
        while(left < right) {
            if (arr[left] != arr[right]) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}