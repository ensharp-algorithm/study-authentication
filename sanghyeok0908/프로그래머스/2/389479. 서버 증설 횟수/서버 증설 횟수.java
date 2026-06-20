import java.util.*;

class Solution {

    public int solution(int[] players, int m, int k) {
        Queue<Integer> servers = new ArrayDeque<>();
        int answer = 0;
        
        for (int time = 0; time < players.length; time++) {
            int playerCnt = players[time];
            
            while (!servers.isEmpty() && servers.peek() + k <= time) {
                servers.poll();
            }
            
            while(servers.size() < playerCnt / m) {
                servers.add(time);
                answer++;
            }
            
            // System.out.printf("playerCnt = %d, server = %d, ans = %d\n", playerCnt, servers.size(), answer);
        }
        return answer;
    }
}