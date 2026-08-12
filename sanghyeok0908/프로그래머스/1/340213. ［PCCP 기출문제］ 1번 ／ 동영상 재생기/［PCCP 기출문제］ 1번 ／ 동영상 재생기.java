class Solution {
    
    int[] openingStart, openingEnd, videoEnd;
    
    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
        int[] time = new int[] { Integer.parseInt(pos.substring(0, 2)), Integer.parseInt(pos.substring(3, 5)) };
        openingEnd = new int[] { Integer.parseInt(op_end.substring(0, 2)), Integer.parseInt(op_end.substring(3, 5)) };
        videoEnd = new int[] { Integer.parseInt(video_len.substring(0, 2)), Integer.parseInt(video_len.substring(3, 5)) };
        
        String timeStr = changeStr(time);
        
        if (op_start.compareTo(timeStr) <= 0 && timeStr.compareTo(op_end) <= 0) {
            time[0] = openingEnd[0];
            time[1] = openingEnd[1];
        }
        
        for (String command : commands) {
            if (command.equals("prev")) {
                time[1] -= 10;
                
                if (time[1] < 0) {
                    time[0]--;
                    time[1] = 60 + time[1];
                }
                
                if (time[0] < 0 || (time[0] == 0 && time[1] < 0)) {
                    time[0] = 0;
                    time[1] = 0;
                }
            } else {
                time[1] += 10;
                
                if (time[1] >= 60) {
                    time[0]++;
                    time[1] = time[1] - 60;
                }
                
                if (time[0] > videoEnd[0] || (time[0] == videoEnd[0] && time[1] > videoEnd[1])) {
                    time[0] = videoEnd[0];
                    time[1] = videoEnd[1];
                }
            }
            
            timeStr = changeStr(time);
            if (op_start.compareTo(timeStr) <= 0 && timeStr.compareTo(op_end) <= 0) {
                time[0] = openingEnd[0];
                time[1] = openingEnd[1];
            }
            // System.out.println(timeStr);
        }
        
        return changeStr(time);
    }
    
    String changeStr(int[] time) {
        String m = time[0] + "";
        String s = time[1] + "";
        
        if (time[0] <= 9) {
            m = "0" + time[0];    
        }
        if (time[1] <= 9) {
            s = "0" + time[1];    
        }
        return m + ":" + s;
    }
}