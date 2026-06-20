class Solution {
    
    public int[] solution(int n) {
        int size = n * (n + 1) / 2;
        int[] answer = new int[size];
        int[][] arr = new int[n][2]; // {left, right}
        
        for (int i = 0; i < n; i++) {
            int h = i + 1;
            arr[i][0] = h * (h - 1) / 2;
            arr[i][1] = h * (h + 1) / 2 - 1;
        }
        
        // for (int i = 0; i < n; i++) {
        //     System.out.println(arr[i][0] + " " + arr[i][1]);
        // }
        
        int value = 1;
        int top = 0;
        int bottom = n - 1;
        while(value <= size) {
            // top - down
            for (int i = top; i < bottom; i++) {
                answer[arr[i][0]++] = value++;
            }
            
            // bottom
            while(arr[bottom][0] <= arr[bottom][1]) {
                answer[arr[bottom][0]++] = value++;
            }
            
            // bttom - up
            for (int i = bottom - 1; i > top; i--) {
                answer[arr[i][1]--] = value++;   
            }
            
            top += 2;
            bottom--;
        }
        
        return answer;
    }
}