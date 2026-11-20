class Solution {
    
    public long solution(int r1, int r2) {
        if (r1 > r2) {
            int temp = r1;
            r1 = r2;
            r2 = temp;
        }
        
        long answer = 0;
        long R1 = (long) r1 * r1;
        long R2 = (long) r2 * r2;

        for (long x = 1; x <= r2; x++) {
            long maxY = (long) Math.floor(Math.sqrt(R2 - x * x));
            long minY = (x < r1) ? (long) Math.ceil(Math.sqrt(R1 - x * x)) : 0;
            answer += maxY - minY + 1;
        }
        return answer * 4;
    }
}