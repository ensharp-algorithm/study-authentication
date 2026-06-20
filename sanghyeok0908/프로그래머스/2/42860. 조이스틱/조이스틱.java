class Solution {
    
    char[] original, target;
    int n;
    int answer;
    
    public int solution(String name) {
        answer = 0;
        n = name.length();
        
        original = createOriginal(n);
        target = name.toCharArray();
        
        int move = n - 1;
        for (int i = 0; i < n; i++) {
            int temp = target[i] - original[i];
            answer += temp > 13 ? 26 - temp : temp;
            
            int next = i + 1;
            while(next < n && target[next] == 'A') {
                next++;
            }
            
            int left = i;
            int right = n - next;
            int minTurn = left + right + Math.min(left, right);
            move = Math.min(move, minTurn);
        }
        return answer + move;
    }
    
    char[] createOriginal(int length) {
        char[] result = new char[length];
        
        for (int i = 0; i < length; i++) {
            result[i] = 'A';
        }
        return result;
    }
}