class Solution {

    public int[] solution(long begin, long end) {
        int[] answer = new int[(int)(end - begin) + 1];
        
        for (long num = begin; num <= end; num++) {
            if (num == 1) {
                continue;
            }
            
            answer[(int)(num - begin)] = 1;
            
            for (int i = 2; i * i <= num; i++) {
                if (num % i != 0) {
                    continue;
                }
                
                long temp = num / i;
                
                if (temp <= 10000000) {
                    answer[(int)(num - begin)] = (int)temp;
                    break;
                }
                
                answer[(int)(num - begin)] = i;
            }
        }
        return answer;
    }
}