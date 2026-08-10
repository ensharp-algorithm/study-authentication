import java.util.*;

class Solution {
    
    static Time video;
    static Time current;
    static Time openinigStart;
    static Time openinigEnd;
    
    class Time{
        int m;
        int s;
        
        Time(String str, boolean check){
            
            String[] strArr = str.split(":");
            
            this.m = Integer.parseInt(strArr[0]);
            this.s = Integer.parseInt(strArr[1]);
            
            if (check){
                checkOpeinig();
            }
        }
        
        public void next(){
            this.s += 10;
            
            if (s > 59){
                this.m++;
                this.s -= 60;
            }
            
            validate();
            checkOpeinig();
        }
        public void prev(){
            this.s -= 10;
            
            if (s < 0){
                this.m--;
                this.s += 60;
            }
            
            validate();
            checkOpeinig();
        }
        
        private void checkOpeinig(){
            int now = this.m * 60 + this.s;
            
            if ((now >=( openinigStart.m * 60 + openinigStart.s)) && (now <= (openinigEnd.m * 60 + openinigEnd.s))){
                this.m = openinigEnd.m;
                this.s = openinigEnd.s;
            }
        }
        
        private void validate(){
            
            if (this.m < 0) {
                this.m = 0;
                this.s = 0;
            }
            
            if (this.m > video.m || (this.m == video.m && this.s > video.s)) {
 
                this.m = video.m;
                this.s = video.s; 
            }
            
        }
    }
    
    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
        
        this.video = new Time(video_len, false);
        this.openinigStart = new Time(op_start,false);
        this.openinigEnd = new Time(op_end,false);
        this.current = new Time(pos, true);
        
        
//         System.out.println("비디오 길이 " + video.m + " "+ video.s);
//         System.out.println("오프닝 시작 위치 " + openinigStart.m + " "+ openinigStart.s);
//         System.out.println("오프닝 끝 위치 " + openinigEnd.m + " "+ openinigEnd.s);
//         System.out.println("현재 위치 " + current.m + " "+ current.s);
        
        for (String command : commands){
            
    
            if (command.equals("next")){
                current.next();
            }
            
            if (command.equals("prev")){
                current.prev();
            }
            
            // System.out.println("현재 위치 " + current.m + " "+ current.s);
        }
        
        
        return String.format("%02d:%02d", current.m, current.s);
    }
}