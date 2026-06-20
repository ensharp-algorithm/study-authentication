import java.util.*;

class Solution {
    
    class Node {
        String str;
        int depth;
        
        Node(String str, int depth) {
            this.str = str;
            this.depth = depth;
        }
    }
    
    int wordLen;
    
    public int solution(String begin, String target, String[] words) {
        int n = words.length;
        Queue<Node> queue = new ArrayDeque<>();
        boolean[] visited = new boolean[n];
        wordLen = begin.length();
        
        queue.add(new Node(begin, 0));
        
        while(!queue.isEmpty()) {
            Node poll = queue.poll();
            
            if (poll.str.equals(target)) {
                return poll.depth;
            }
            
            for (int i = 0; i < n; i++) {
                if (!visited[i] && possible(poll.str, words[i])) {
                    visited[i] = true;
                    queue.add(new Node(words[i], poll.depth + 1));
                }
            }
        }
        return 0;
    }
    
    boolean possible(String str1, String str2) {
        char[] arr1 = str1.toCharArray();
        char[] arr2 = str2.toCharArray();
        int cnt = 0;
        
        for (int i = 0; i < wordLen; i++) {
            if (arr1[i] == arr2[i]) {
                cnt++;
            }    
        }
        return cnt == wordLen - 1;
    }
}