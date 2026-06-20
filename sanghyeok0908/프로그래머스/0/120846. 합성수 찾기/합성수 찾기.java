class Solution {
    public int solution(int n) {
        int answer = 0;
        
        for (int i = 4; i <= n; i++) {
            if (isAnswer(i)) {
                answer++;
                System.out.println(i);
            }
        }
        return answer;
    }
    
    boolean isAnswer(int x) {  
        for (int i = 2; i < x; i++) {   
            if (x % i == 0)
                return true;
        }
        return false;
    }
}