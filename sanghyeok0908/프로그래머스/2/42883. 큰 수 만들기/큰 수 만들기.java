import java.util.*;

class Solution {

    public String solution(String number, int k) {
        int cnt = 0;
        Deque<Integer> queue = new ArrayDeque<>();
        char[] arr = number.toCharArray();
        queue.add(arr[0] - '0');
        
        for (int i = 1; i < arr.length; i++) {
            while (!queue.isEmpty() && cnt < k && queue.peekLast() < arr[i] - '0') {
                queue.pollLast();
                cnt++;
            }
            queue.addLast(arr[i] - '0');
        }
        
        while(cnt < k) {
            queue.pollLast();
            cnt++;
        }
        
        String answer = "";
        while(!queue.isEmpty()) {
            Integer poll = queue.pollFirst();
            answer += poll;
        }
        return answer;
    }
}