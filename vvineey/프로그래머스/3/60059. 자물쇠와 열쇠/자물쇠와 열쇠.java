import java.util.*;

class Solution {
    
    int[] dx = {0,1};
    int[] dy = {1,0};
    int n,m;
    
    public boolean solution(int[][] key, int[][] lock) {
        
        n = lock.length;
        m = key.length;
        
        int cnt = 0;
        
        for(int i = 0; i < n; i++){
            for (int j = 0; j < n; j++){
                if (lock[i][j] == 0){
                    cnt++;
                }
            }
        }
        
        
        for (int i = 0; i < 4; i++){
            int[][] rotatedKey = key;
            for (int j = 0; j < i; j++){
                rotatedKey = rotate(rotatedKey,i);
            }
            if (isOpen(rotatedKey, lock, cnt)){
                return true;
            }
        }
        
        return false;
    }
    
    private boolean isOpen(int[][] originKey, int[][] lock, int cnt){
        
        int[][] matrix = new int[2*m+n][2*m+n];
        int[][] key = new int[2*m+n][2*m+n];
        
        for (int[] row : matrix){
            Arrays.fill(row,-1);
        }
        
        for (int i = 0; i < n; i++){
            for (int j= 0; j < n; j++){
                matrix[m+i][m+j] = lock[i][j];
            }
        }
        for (int i = 0; i < m; i++){
            for (int j= 0; j < m; j++){
                key[i][j] = originKey[i][j];
            }
        }
        
        int [][] shiftedKey = key;
        for (int i = 0; i < 2*m+n; i++){
            shiftedKey = shift(shiftedKey, 0);
            
            if (match(shiftedKey, matrix, cnt)){
                return true;
            }
            int [][] tmpKey = shiftedKey;
            for (int j = 0; j < 2*m +n; j++){
                
                tmpKey = shift(tmpKey, 1);
           
                if (match(tmpKey, matrix, cnt)){
                    return true;
                }
            }
            
        }
        
        return false;
    }
    
    private boolean match(int[][] key, int [][]lock, int cnt){
        
        int k = 0;
        
        for (int i = 0; i < 2*m+n; i++){
            for (int j = 0;j < 2*m+n; j++){
                
                if (key[i][j] == 1 &&  lock[i][j] == 1){
                    return false;
                }
                if (key[i][j] == 0 &&  lock[i][j] == 0 ){
                    return false;
                }
                if (key[i][j] == 1 &&  lock[i][j] == 0){
                    k++;
                }
            }
        }
        
        if (k == cnt){
            return true;
        }
        
        return false;
    }
        
        
    private int[][] rotate(int [][] key, int cnt){
        
        int [][] newKey = new int[m][m];
        
     
        for (int i = 0; i < m; i++){
            for (int j = 0; j < m; j++){
                newKey[j][m-1-i] = key[i][j];
            }
        }
        
        return newKey;
    }
    
    private int[][] shift (int [][] key, int d){
        int [][] newKey = new int[2*m+n][2*m+n];
        
        for (int i = 0; i < 2*m+n ; i++){
            for (int j= 0; j < 2*m+n; j++){
                int nextY = i + dy[d];
                int nextX = j + dx[d];
                
                if (nextY < 0 || nextX < 0 || nextY >= 2*m+n || nextX >=2*m+n){
                    continue;
                }
                
                newKey[nextY][nextX] = key[i][j];
            }
        }
        
        return newKey;
    }    
}