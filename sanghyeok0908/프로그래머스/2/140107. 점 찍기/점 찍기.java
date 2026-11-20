class Solution {
    public long solution(int k, int d) {
        long answer = 0;
        long d2 = (long) Math.pow(d, 2);
        
        for (int i = 0; k * i <= d; i++) {
            long x = k * i;
            long maxY = (long) Math.sqrt(d2 - Math.pow(x, 2));
            // System.out.printf("i=%d,x=%d,maxY=%d,cnt=%d\n", i, x, maxY, (maxY / k) + 1);
            answer += (maxY / k) + 1;
        }
        return answer;
    }
}