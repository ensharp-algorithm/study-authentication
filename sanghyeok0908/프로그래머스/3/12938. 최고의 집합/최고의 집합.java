import java.util.*;

class Solution {
    
    int max = -1;
    int[] answer = null;
        
    public int[] solution(int n, int s) {
        if (n == 1) {
            return new int[] { s };
        }
        if (s / n == 0) {
            return new int[] { -1 };
        }
        
        int[] arr = new int[n];
        arr[0] = s / n;
        dfs(n, s, arr, 1, s / n);
        return answer;
    }
    
    void dfs(int n, int s, int[] arr, int curCnt, int curSum) {
        if (n == curCnt) {
        //     System.out.println("=====");
        //     for (int i = 0; i < arr.length; i++) {
        //         System.out.print(arr[i] + " ");
        //     }
        //     System.out.println();
            
            int result = 1;
            for (int i : arr) {
                result *= i;
            }
            
            if (max < result) {
                answer = arr;
                max = result;
                System.out.println(max);
            }
            return;
        }
        
        arr[curCnt] = (s - curSum) / (n - curCnt);
        dfs(n, s, arr, curCnt + 1, curSum + arr[curCnt]);
    }
}