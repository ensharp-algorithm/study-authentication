class Solution {
    
    int n;
    int answer = 0;
    int target;
    int[] numbers;
    
    public int solution(int[] numbers, int target) {
        n = numbers.length;
        this.target = target;
        this.numbers = numbers;
        
        dfs(0, 0);
        return answer;
    }
    
    void dfs(int depth, int num) {
        if (depth == n) {
            answer = num == target ? answer + 1 : answer;
            return;
        }
        
        dfs(depth + 1, num + numbers[depth]);
        dfs(depth + 1, num - numbers[depth]);
    }
}