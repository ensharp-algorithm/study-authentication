import java.util.*;

class Solution {
    int N;
    int maxLcm = 1;
    int[] gyr;
    
    public int solution(int[][] signals) {
        N = signals.length;
        gyr = new int[N];
        
        for (int i = 0; i < N ; i++) {
            gyr[i] = signals[i][0] + signals[i][1] + signals[i][2];
            maxLcm = lcm(maxLcm, gyr[i]);
        }
        
        for (int t = 1; t <= maxLcm; t++) {
            boolean alright = true;
            
            for (int i = 0; i < N; i++) {
                int g = signals[i][0];
                int y = signals[i][1];

                int time = (t - 1) % gyr[i];

                if (g > time || time >= g + y) {
                    alright = false;
                    break;
                }                
            }

            if (alright) {
                return t;
            }
        }
        return -1;
    }
    
    int lcm(int a, int b) {
        return (a * b) / gcd(a, b);
    }
    
    int gcd(int a, int b) {
        while(b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}