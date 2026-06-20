import java.util.*;

class Solution {

    public int solution(int[] people, int limit) {
        int answer = 0;
        int n = people.length;
        int left = 0, right = n - 1;
        
        Arrays.sort(people);
        while(left <= right) {
            if (left <= right && people[left] + people[right] <= limit) {
                left++;
            }
            
            right--;
            answer++;
        }
        
        return answer;
    }
}