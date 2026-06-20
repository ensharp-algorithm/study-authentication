import java.util.*;

class Solution {
    
    public int[] solution(String[] wallpaper) {
        int[] start = new int[] {50, 50};
        int[] end = new int[2];
        
        for (int i = 0; i < wallpaper.length; i++) {
            for (int j = 0; j < wallpaper[0].length(); j++) {
                if (wallpaper[i].charAt(j) == '.') {
                    continue;
                }
                
                if (j < start[1]) {
                    start[1] = j;   
                }
                
                if (j > end[1]) {
                    end[1] = j;
                }
            }
        }
        
        for (int i = 0; i < wallpaper[0].length(); i++) {
            for (int j = 0; j < wallpaper.length; j++) {
                if (wallpaper[j].charAt(i) == '.') {
                    continue;
                }
                
                if (j < start[0]) {
                    start[0] = j;   
                }
                
                if (j > end[0]) {
                    end[0] = j;
                }
            }
        }
        
        return new int[] {start[0], start[1], end[0] + 1, end[1] + 1};
    }
}