import java.util.*;

class Solution {
    
    Map<String, Queue<String>> map = new HashMap<>();
    List<String> result = new ArrayList<>();
    
    public String[] solution(String[][] tickets) {
        for (String[] ticket : tickets) {
            Queue<String> q = map.getOrDefault(ticket[0], new PriorityQueue<>());
            q.add(ticket[1]);
            
            map.put(ticket[0], q);
        }
        
        dfs("ICN");
        
        String[] answer = new String[result.size()];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = result.get(answer.length - 1 - i);
        }
        return answer;
    }
    
    void dfs(String airport) { 
        Queue<String> q = map.get(airport);
        
        while(q != null && !q.isEmpty()) {
            dfs(q.poll());
        }
        
        result.add(airport);
    }
}