import java.util.*;

class Solution {
    
    Set<String> words = new HashSet<>(), spoilerWords = new HashSet<>();
    int len, rangeLen;
    
    public int solution(String message, int[][] spoiler_ranges) {
        len = message.length();
        rangeLen = spoiler_ranges.length;
        char[] arr = message.toCharArray();
        
        int i = 0, rangeIdx = 0;
        while(i < len) {
            if (message.charAt(i) == ' ') {
                i++;
                continue;
            }
            
            int start = i;
            while(i < len && message.charAt(i) != ' ') {
                i++;
            }
            int end = i - 1;
            
            String word = message.substring(start, end + 1);
            // System.out.println(word);
            
            while(rangeIdx < rangeLen && 
                  spoiler_ranges[rangeIdx][1] < start) {
                rangeIdx++;
            }
            
            if (rangeIdx < rangeLen && spoiler_ranges[rangeIdx][0] <= end) {
                // System.out.println("this is spoiler");
                if (!words.contains(word)) {
                    spoilerWords.add(word);
                }
            } else {
                // System.out.println("this is word");
                words.add(word);
                
                if (spoilerWords.contains(word)) {
                    spoilerWords.remove(word);
                }
            }
        }
        
        return spoilerWords.size();
    }
}