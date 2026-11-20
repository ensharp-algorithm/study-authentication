
class Solution {
    
    public int solution(String s) {
        int n = s.length();
        int answer = n;
        
        for (int len = 1; len <= n / 2; len++) {
            StringBuilder sb = new StringBuilder();
            String prev = s.substring(0, len);
            int cnt = 1;
            
            // System.out.println("prev=" + prev);
            
            for (int i = len; i < n; i += len) {
                int end = Math.min(i + len, n);
                String cur = s.substring(i, end);
                
                if (prev.equals(cur)) {
                    cnt++;
                    continue;
                }
                
                if (cnt > 1) {
                    sb.append(cnt);
                }
                sb.append(prev);
                prev = cur;
                cnt = 1;
            }
            
            if (cnt > 1) {
                sb.append(cnt);
            }
            sb.append(prev);
            
            answer = Math.min(answer, sb.toString().length());
            // System.out.println(sb);
        }
        return answer;
    }
}