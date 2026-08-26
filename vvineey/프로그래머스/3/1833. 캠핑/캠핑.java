import java.util.*;

class Solution {
    
    public int solution(int n, int[][] data) {

        int [] arrX = new int[n];
        int [] arrY = new int[n];
        
        for (int i = 0; i < n; i++) {
            arrX[i] = data[i][1];
            arrY[i] = data[i][0];
        } 
        
        arrX = Arrays.stream(arrX)
            .distinct()
            .sorted()
            .toArray();
        
        arrY = Arrays.stream(arrY)
            .distinct()
            .sorted()
            .toArray();
        
        //원본 좌표. 압축한 좌표 
        HashMap < Integer, Integer > xMap = new HashMap<>();
        HashMap < Integer, Integer > yMap = new HashMap<>();
        
        for (int i = 0; i < arrX.length; i++){
            xMap.put(arrX[i],i);
        }
        
        for (int i = 0; i < arrY.length; i++){
            yMap.put(arrY[i], i);
        }
        
        
        // 압축본 배열 만들기 
        int[][] prefix = new int[arrY.length+1][arrX.length+1];

        for (int i = 0; i < n; i++) {

            int y = yMap.get(data[i][0]);
            int x = xMap.get(data[i][1]);

            // 누적합용
            prefix[y+1][x+1] = 1;
        }

        //2차원 누적합 계산 
        for (int y = 1; y < arrY.length+1; y++){
            for (int x = 1; x < arrX.length+1; x++){
                prefix[y][x] += prefix[y-1][x] + prefix[y][x-1] - prefix[y-1][x-1];
            }
        }

        // 경계를 포함하여 쐐기가 2개인 넓이 계산 
        int cnt = 0;
        
        for (int i = 0; i < n; i++){
            for (int j = i+1; j< n; j++){
                int x1 = xMap.get(data[i][1]) + 1;
                int y1 = yMap.get(data[i][0]) + 1;
                int x2 = xMap.get(data[j][1]) + 1;
                int y2 = yMap.get(data[j][0]) + 1;
                
                if (x1 == x2 || y1 == y2) {
                    continue;
                }
                
                int minX = Math.min(x1,x2);
                int maxX = Math.max(x1,x2);
                int minY = Math.min(y1,y2);
                int maxY = Math.max(y1,y2);
                
                if (minX + 1 > maxX -1 || minY + 1 > maxY -1){
                    cnt++;
                    continue;
                }
                
                if (getSum(prefix, minX + 1 ,minY +1 ,maxX -1 ,maxY -1) == 0){
                    cnt++;
                }
            }
        }
        
        return cnt;
    }
    
    private int getSum(int [][] prefix, int x1, int y1, int x2, int y2){
        // System.out.println("1) " + y1 + " " + x1 + " \n2) " + y2 + " "+ x2);
        
        int sum = prefix[y2][x2] - prefix[y1-1][x2] - prefix[y2][x1-1] + prefix[y1-1][x1-1];
        
        // System.out.println(sum);
        return sum;
    }
}