import java.util.*;

class Solution
{
    public int solution(int n, int a, int b)
    {
        int answer = 0;
        
        while(a != b) {
            int nextA = calculate(a);
            int nextB = calculate(b);
            a = nextA;
            b = nextB;
            answer++;
        }
        
        return answer;
    }
    
    public int calculate(int x) {
        if (x % 2 == 0) {
            return x / 2;
        }
        if (x > 2) {
            return x / 2 + 1;
        }
        return x;
    }
}