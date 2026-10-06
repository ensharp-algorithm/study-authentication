import java.util.*;

class Solution {

    static PriorityQueue<String> queue;
    static HashMap<String, Integer> map;

    public String[] solution(String[] orders, int[] course) {

        queue = new PriorityQueue<>();
        map = new HashMap<>();

        for (String order : orders) {

            char[] chars = order.toCharArray();
            Arrays.sort(chars);

            String sortedOrder = new String(chars);

            for (int len : course) {

                if (sortedOrder.length() < len) {
                    continue;
                }

                combi(sortedOrder, len, "", 0);
            }
        }
        
        
        for (int len : course) {
            
            int max = 0;
            
            for (String menu : map.keySet()) {
                
                if (menu.length() != len) {
                    continue;
                }
                max = Math.max(max, map.get(menu));
            }

            if (max < 2) {
                continue;
            }
            
            for (String menu : map.keySet()) {
                if (menu.length() == len && map.get(menu) == max) {
                    queue.offer(menu);
                }
            }
        }


        String[] answer = new String[queue.size()];
        int idx = 0;

        while (!queue.isEmpty()) {
            answer[idx++] = queue.poll();
        }

        return answer;
    }


    private void combi(String order, int len, String menu, int start) {

        if (menu.length() == len) {
            map.put(menu,map.getOrDefault(menu, 0) + 1);
            // System.out.println(menu + " " + map.get(menu));
            return;
        }

        for (int i = start; i < order.length(); i++) {
            combi(order,len,menu + order.charAt(i),i + 1);
        }
    }
}