class Solution {
    
    int range;

    public int solution(int n, int[] stations, int w) {
        int answer = 0, prev = 1;
        range = w + w + 1;
        
        for (int st : stations) {
            int end = st - w - 1;
            
            if (end >= prev) {
                answer += calculate(end - prev + 1);
            }
            
            prev = st + w + 1;
        }
        
        if (stations[stations.length - 1] + w + 1 <= n) {
            answer += calculate(n - (stations[stations.length - 1] + w + 1) + 1);
        }
        return answer;
    }
    
    int calculate(int size) {
        if (size % range > 0) {
            return size / range + 1;
        }
        return size / range;
    }
}