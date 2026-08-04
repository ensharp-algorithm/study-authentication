class Solution {
    public String solution(String s) {
        char[] arr = s.toCharArray();
        String answer = "";
        int idx = 0;
        
        for (char ch : arr) {
            if (ch == ' ') {
                answer += ch;
                idx = 0;
                continue;
            }
            
            if (idx % 2 == 0) {
                answer += Character.toUpperCase(ch);
            } else {
                answer += Character.toLowerCase(ch);
            }
            
            idx++;
        }
        return answer;
    }
}