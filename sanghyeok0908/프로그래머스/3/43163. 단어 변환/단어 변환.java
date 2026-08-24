import java.util.*;

class Solution {
    
    int n;
    int answer = Integer.MAX_VALUE;
    boolean[] visited;
    
    public int solution(String begin, String target, String[] words) {
        n = words.length;
        visited = new boolean[n];
        dfs(begin, target, words, 0);
        return answer == Integer.MAX_VALUE ? 0 : answer;
    }
    
    void dfs(String begin, String target, String[] words, int depth) {
        if (depth == n) {
            return;
        }
        if (begin.equals(target)) {
            answer = Math.min(answer, depth);
        }
        
        for (int i = 0; i < n; i++) {
            if (visited[i] || !isPossible(begin, words[i])) {
                continue;
            }
            
            visited[i] = true;
            dfs(words[i], target, words, depth + 1);
            visited[i] = false;
        }
    }
    
    boolean isPossible(String begin, String target) {
        int cnt = 0;
        for (int i = 0; i < begin.length(); i++) {
            if (begin.charAt(i) != target.charAt(i)) {
                cnt++;
            }
        }
        return cnt == 1;
    }
}