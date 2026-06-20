import java.util.*;

class Solution {
    
    int answer = 0;
    int n;
    int[] original;
    boolean[] visited;
    int[] arr;
    Set<Integer> set = new HashSet<>();
   
    public int solution(String numbers) {
        n = numbers.length();
        original = new int[n];
        
        for (int i = 1; i <= n; i++) {
            original[i - 1] = Integer.parseInt(numbers.substring(i - 1, i));
        }
                
        for (int i = 0; i < n; i++) {
            if (!set.contains(original[i]) && isShosu(original[i])) {
                answer++;
                set.add(original[i]);
            }
        }
        
        for (int size = 2; size <= n; size++) {
            arr = new int[size];
            visited = new boolean[n];
            dfs(0, size);
        }
        
        return answer;
    }
    
    void dfs(int depth, int size) {
        if (depth == size) {
            int num = 0;
            
            for (int i = 0; i < size; i++) {
                // System.out.print(arr[i] + " ");
                num = num * 10 + arr[i];
            }
            
            // System.out.println(num);
            
            if (!set.contains(num) && isShosu(num)) {
                answer++;
                set.add(num);
            }
            return;
        }
        
        for (int i = 0; i < n; i++) {
            if (visited[i]) {
                continue;
            }
            
            visited[i] = true;
            arr[depth] = original[i];
            
            dfs(depth + 1, size);
            visited[i] = false;
        }
    }
    
    boolean isShosu(int num) {
        if (num <= 1) 
            return false;
        
        for (int i = 2; i < num; i++) {
            if (num % i == 0) 
                return false;
        }
        return true;
    }
}