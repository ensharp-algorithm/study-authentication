import java.util.*;

class Solution {
    static Deque<String> route;
    static HashMap<String, PriorityQueue<String>> ticketmap;

    public String[] solution(String[][] tickets) {
  
        int n = tickets.length;
        ticketmap = new HashMap<>();
    
        for (String[]arr : tickets){
            
            if (!ticketmap.containsKey(arr[0])) {
                PriorityQueue<String> queue = new PriorityQueue<>();
                queue.offer(arr[1]);
                ticketmap.put(arr[0],queue);
            }
            
            else{
                PriorityQueue<String> queue = ticketmap.get(arr[0]);
                queue.offer(arr[1]);
            }
        }
        
        ticketmap.forEach((key,value) ->{
            System.out.println(key + " " +value);
        });
        
        System.out.println();

        
        route = new ArrayDeque<>();
        dfs("ICN");

        return route.toArray(new String[0]);
    }
    

    private void dfs(String from) {

        PriorityQueue<String> queue = ticketmap.get(from);

        while (queue != null && !queue.isEmpty()) {
            dfs(queue.poll());
        }

        route.addFirst(from);
    }
}