class Solution {
    
    public int solution(String[][] book_time) {
        int[] arr = new int[24 * 60 + 10];
        
        for (String[] t : book_time) {
            int start = convert(t[0]);
            int end = convert(t[1]);
            for (int i = start; i < end + 10; i++) {
                arr[i]++;
            }
        }
        
        int answer = 0;
        for (int i : arr) {
            answer = Math.max(answer, i);
        }
        return answer;
    }
    
    int convert(String time) {
        String[] split = time.split(":");
        return Integer.parseInt(split[0]) * 60 + Integer.parseInt(split[1]);
    }
}