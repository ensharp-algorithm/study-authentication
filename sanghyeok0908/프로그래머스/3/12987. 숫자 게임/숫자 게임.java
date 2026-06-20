import java.util.*;

class Solution {

    public int solution(int[] A, int[] B) {
        int n = A.length;
        TreeMap<Integer, Integer> map = new TreeMap<>();
        
        
        Arrays.sort(A);
        for (int b : B) {
            if (map.containsKey(b)) {
                map.put(b, map.get(b) + 1);
            } else {
                map.put(b, 1);
            }
        }
                
        int answer = 0;
        for (int i = n - 1; i >= 0; i--) {
            int lastKey = map.lastKey();
            
            if (A[i] >= lastKey) {
                int firstKey = map.firstKey();
                int cnt = map.get(firstKey);
                
                if (cnt <= 1) {
                    map.remove(firstKey);
                } else {
                    map.put(firstKey, cnt - 1);
                }
            } else {
                int cnt = map.get(lastKey);
                answer++;
                
                if (cnt <= 1) {
                    map.remove(lastKey);
                } else {
                    map.put(lastKey, cnt - 1);
                }
            }
        }
        return answer;
    }
}