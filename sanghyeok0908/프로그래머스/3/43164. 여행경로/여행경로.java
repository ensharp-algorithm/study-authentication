import java.util.*;

class Solution {
    
    List<String> answer = new ArrayList<>();
    boolean[] visited;
    int n;
    
    public String[] solution(String[][] tickets) {
        n = tickets.length;
        visited = new boolean[n];
        
        Arrays.sort(tickets, (o1, o2) -> o1[1].compareTo(o2[1]));
        
        String from = "ICN";
        answer.add(from);
        dfs(tickets, from, 0);
        
        return answer.toArray(new String[0]);
    }
    
    boolean dfs(String[][] tickets, String from, int cnt) {
        if (cnt == n) {
            return true;
        }
        
        for (int i = 0; i < n; i++) {
            if (visited[i] || !tickets[i][0].equals(from)) {
                continue;
            }
            
            visited[i] = true;
            answer.add(tickets[i][1]);
            if (dfs(tickets, tickets[i][1], cnt + 1)) {
                return true;
            }
            
            visited[i] = false;
            answer.remove(answer.size() - 1);
        }
        return false;
    }
}