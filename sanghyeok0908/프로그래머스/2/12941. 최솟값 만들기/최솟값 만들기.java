import java.util.*;

class Solution
{
    public int solution(int []A, int []B)
    {
        int N = A.length;
        int answer = 0;
        Arrays.sort(A);
        Arrays.sort(B);
        
        for (int i = 0; i < N; i++) {
            answer += A[i] * B[N - 1 - i];
        }

        return answer;
    }
}