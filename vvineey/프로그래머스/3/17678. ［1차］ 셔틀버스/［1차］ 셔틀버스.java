import java.util.*;

class Solution {
    public String solution(int n, int t, int m, String[] timetable) {
        
        int[] times = new int[timetable.length];
        for(int i = 0; i < timetable.length; i++){
            times[i] = getTime(timetable[i]);
        }
        Arrays.sort(times);
        // System.out.println(Arrays.toString(times));
        
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int time : times){
            pq.offer(time);
        }
        
        int current = getTime("09:00") - t;
        int answer = current;
        
        for (int nc = 0; nc < n; nc++){
            int cnt = m; 
            current += t;
            // System.out.println("> " + toTime(current));
            answer = current;
            
            if (!pq.isEmpty() && pq.peek() > current){
                continue;
            }
            
            while(cnt > 0 && !pq.isEmpty() && pq.peek() <=current){
                int last = pq.poll();
                cnt--;
                
                if (nc == n-1 && cnt == 0){
                    // System.out.println("> 여기서 진짜 타야됨 마지막 탑승 "+ toTime(last));
                    answer = last-1;
                }
            }
        }        
        
        return toTime(answer);
    }
    
    private int getTime(String s){
        String[] arr = s.split(":");
        return Integer.parseInt(arr[0]) * 60 + Integer.parseInt(arr[1]);
    }
    
    private String toTime(int n){
        int h = n/60;
        int m = n%60;
        
        return String.format("%02d:%02d", h,m);
    }
}