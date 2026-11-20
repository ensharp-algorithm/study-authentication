class Solution {
    
    public long solution(int[] sequence) {
        int n = sequence.length;
        int[] arr1 = new int[n], arr2 = new int[n];
        
        for (int i = 0; i < n; i++) {
            arr1[i] = sequence[i];
            arr2[i] = sequence[i];
            
            if (i % 2 != 0) {
                arr1[i] *= -1;
            } else {
                arr2[i] *= -1;
            }
        }

        long cur1 = arr1[0], cur2 = arr2[0];
        long answer = Math.max(cur1, cur2);
        
        for (int i = 1; i < n; i++) {
            cur1 = Math.max(arr1[i], cur1 + arr1[i]);
            cur2 = Math.max(arr2[i], cur2 + arr2[i]);
            
            answer = Math.max(answer, cur1);
            answer = Math.max(answer, cur2);
        }
        return answer;
    }
}