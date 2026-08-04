class Solution {
    public int solution(String t, String p) {
        int cnt = 0;
        
        for (int i = 0; i <= t.length() - p.length(); i++) {
            String tt = t.substring(i, i + p.length());
            if (tt.compareTo(p) <= 0) {
                // System.out.println(tt + " " + p);
                cnt++;
            }
        }
        return cnt;
    }
}