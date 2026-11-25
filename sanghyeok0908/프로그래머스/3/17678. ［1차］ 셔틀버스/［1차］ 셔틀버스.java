import java.util.*;

class Solution {

    public String solution(int n, int t, int m, String[] timetable) {
        Queue<int[]> crews = new PriorityQueue<>((o1, o2) -> {
            if (o1[0] != o2[0]) 
                return Integer.compare(o1[0], o2[0]);
            return Integer.compare(o1[1], o2[1]);
        });
        int max = 0;
        int left = 0, right = 9 * 23 * 60 + 59;
        
        for (int i = 0; i < timetable.length; i++) {
            String[] split = timetable[i].split(":");
            int hour = Integer.parseInt(split[0]);
            int minute = Integer.parseInt(split[1]);
            
            crews.add(new int[] { hour * 60 + minute, 0 });
        }
        
        while(left <= right) {
            int mid = (left + right) / 2;
            PriorityQueue<int[]> copy = new PriorityQueue<>(crews);
            
            // System.out.printf("left=%d, mid=%d, right=%d\n", left, mid, right);
            
            copy.add(new int[] { mid, 1 });
            
            if (calculate(n, t, m, copy)) {
                max = Math.max(max, mid);
                left = mid + 1;
                // System.out.println("success");
            } else {
                right = mid - 1;
                // System.out.println("fail");
            }
        }
        
        String hour = max / 60 <= 9 ? "0" + (max / 60) : (max / 60) + "";
        String minute = max % 60 <= 9 ? "0" + (max % 60) : (max % 60) + "";
        return hour + ":" + minute;
    }
    
    boolean calculate(int n, int t, int m, Queue<int[]> crews) {
        for (int i = 0, bus = 9 * 60; i < n; i++, bus += t) {
            int cnt = 0;
            
            // System.out.printf("%d번째 버스\n", i + 1);
            while(cnt < m && !crews.isEmpty() && crews.peek()[0] <= bus) {
                int[] poll = crews.poll();
                // System.out.printf("%d %d\n", poll[0], poll[1]);
                cnt++;
                
                if (poll[1] == 1) {
                    return true;
                }
            }
        }
        return false;
    }
}