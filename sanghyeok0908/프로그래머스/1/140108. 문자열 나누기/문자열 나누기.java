class Solution {
    public int solution(String s) {
        char[] arr = s.toCharArray();
        char prev = '\0';
        int prevCnt = 0, curCnt = 0, answer = 0;
        
        for (int i = 0; i < arr.length; i++) {
            if (prev == '\0') {
                prev = arr[i];
                prevCnt = 1;
                continue;
            }
            
            if (prev == arr[i]) {
                prevCnt++;
            } else {
                curCnt++;
            }
            
            if (prevCnt == curCnt) {
                // System.out.println("prev = " + prev + " cur = " + arr[i]);
                prevCnt = 0;
                curCnt = 0;
                prev = '\0';
                answer++;
            }
        }
        
        if (prev != '\0')
            return answer + 1;
        return answer;
    }
}