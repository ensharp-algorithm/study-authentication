class Solution {
    public int solution(int[][] sizes) {
        for (int i = 0; i < sizes.length; i++) {
            if (sizes[i][0] < sizes[i][1]) {
                int temp = sizes[i][0];
                sizes[i][0] = sizes[i][1];
                sizes[i][1] = temp;
            }
        }
        
        int maxRow = 0, maxCol = 0;
        for (int i = 0; i < sizes.length; i++) {
            if (maxRow < sizes[i][0]) {
                maxRow = sizes[i][0];
            }
            
            if (maxCol < sizes[i][1]) {
                maxCol = sizes[i][1];
            }
        }
        return maxRow * maxCol;
    }
}