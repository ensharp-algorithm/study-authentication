import java.util.*;

class Solution {
    public int solution(int[] players, int m, int k) {
        
        int total = 0;

        //시간대, 서버의 수 
        HashMap <Integer, Integer> hm = new HashMap<>();
        
        for (int time = 0; time < 24; time++){
             hm.put(time, 0);
        }
        
        for (int time = 0; time < 24; time++){
            
            int serverCnt = players[time] / m;
            // System.out.println("시각 " + time);
            // System.out.println("게임 이용자 수 " + players[time] + " 필요한 서버의 수 :  " + serverCnt);
            
            if (serverCnt == 0){
                continue;
            }
        
            int now = hm.get(time);
            // System.out.println("현재 가지고 있는 서버 "+ now);
            
            int diff = serverCnt - now;
            
            if (diff <= 0){
                continue;
            }
            
            for (int i = time; i < time+ k; i++){
                if (i >= 24){
                    break;
                }
                // System.out.println(" > " + i + " 시각에 " + diff + "만큼 증설");
                hm.replace(i, (hm.get(i) + diff));
            }
            
            total += diff;
            
            System.out.println();
        }
        
        return total;
    }
}