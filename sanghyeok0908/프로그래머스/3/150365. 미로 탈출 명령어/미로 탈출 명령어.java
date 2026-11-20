import java.util.*;

class Solution {
    
    int[] dy = { 1, 0, 0, -1 };
    int[] dx = { 0, -1, 1, 0 };
    char[] direct = { 'd', 'l', 'r', 'u' }; // 우선순위: 아래, 왼쪽, 오른쪽, 위쪽
    
    public String solution(int n, int m, int x, int y, int r, int c, int k) {
        int dist = Math.abs(x - r) + Math.abs(y - c);
        StringBuilder sb = new StringBuilder();
        
        if (dist > k || (k - dist) % 2 != 0) {
            return "impossible";
        }
        
        for (int curY = x, curX = y; k >= 0; k--) {            
            for (int idx = 0; idx < 4; idx++) {
                int tmpY = curY + dy[idx];
                int tmpX = curX + dx[idx];
                
                if (tmpY <= 0 || tmpY > n || 
                    tmpX <= 0 || tmpX > m) {
                    continue;
                }
                
                int remaining = Math.abs(tmpY - r) + Math.abs(tmpX - c);
                
                // System.out.printf("k=%d, remaining=%d, direct=%d\n", k, remaining, idx);
                
                if (remaining > k || (k - remaining) % 2 != 0) {
                    continue;
                }
                
                // System.out.printf("k=%d, remaining=%d, direct=%d, (%d,%d)\n", 
                //                   k, remaining, idx, tmpY, tmpX);
                
                curY = tmpY;
                curX = tmpX;
                sb.append(direct[idx]);
                break;
            }
        }
        return sb.toString();
    }
}