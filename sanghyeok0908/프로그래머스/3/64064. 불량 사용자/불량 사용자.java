import java.util.*;

class Solution {
    
    boolean[] visited;
    Set<Integer> set = new HashSet<>();
    
    public int solution(String[] user_id, String[] banned_id) {
        visited = new boolean[user_id.length];
        
        dfs(0, user_id, banned_id);
        return set.size();
    }
    
    void dfs(int banIdx, String[] user_id, String[] banned_id) {
        if (banIdx == banned_id.length) {
            StringBuilder sb = new StringBuilder();
            
            for (int i = 0; i < user_id.length; i++) {
                if (visited[i]) {
                    sb.append(i);
                }
            }
            set.add(Integer.parseInt(sb.toString()));
            return;
        }
        
        String banned = banned_id[banIdx];
        for (int i = 0; i < user_id.length; i++) {
            if (visited[i] || !isSame(user_id[i], banned)) {
                continue;
            }
            
            visited[i] = true;
            dfs(banIdx + 1, user_id, banned_id);
            
            visited[i] = false;
        }
    }
    
    boolean isSame(String str1, String str2) {
        if (str1.length() != str2.length()) {
            return false;
        }
        
        char[] arr1 = str1.toCharArray();
        char[] arr2 = str2.toCharArray();
        
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] == '*' || arr2[i] == '*') {
                continue;
            }
            if (arr1[i] != arr2[i]) {
                return false;
            }
        }
        return true;
    }
}