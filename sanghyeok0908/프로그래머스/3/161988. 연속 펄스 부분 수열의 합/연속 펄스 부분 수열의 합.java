class Solution {
    
    int n;
    
    public long solution(int[] sequence) {
        n = sequence.length;
        
        long max = 0, min = 0;
        int pulse = 1;
        long cur = 0;
        for (int i = 0; i < n; i++) {
            cur += sequence[i] * pulse;
            
            max = Math.max(max, cur);
            min = Math.min(min, cur);
            
            // System.out.printf("i = %d, cur = %d, max = %d, min = %d\n", i, cur, max, min);
            pulse *= -1;
        }
        
        return max - min;
    }
}