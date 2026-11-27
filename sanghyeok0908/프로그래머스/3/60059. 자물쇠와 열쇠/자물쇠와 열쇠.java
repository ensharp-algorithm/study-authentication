import java.util.*;

class Solution {
    
    int[][] matrix;
    int[] dy = new int[] { -1, 1, 0, 0 };
    int[] dx = new int[] { 0, 0, -1, 1 };
    int M, N;
    int size;
    
    public boolean solution(int[][] key, int[][] lock) {
        M = key.length;
        N = lock.length;
        size = M * 2 + N;
        
        for (int rotateCnt = 0; rotateCnt < 5; rotateCnt++) {
            matrix = new int[size][size];

            for (int i = 0; i < M; i++) {
                for (int j = 0; j < M; j++) {
                    matrix[i][j] = key[i][j];
                }
            }
            
            key = rotate(key);
            
            for (int i = 0; i <= M + N; i++) {
                // shiftDown을 위한 초기 값을 temp에 저장
                int[][] temp = new int[size][size];

                for (int j = 0; j < size; j++) {
                    temp[j] = matrix[j].clone();
                }

                // shiftRight 하면서 validation
                for (int j = 0; j <= M + N; j++) {
                    if (validation(lock)) {
                        return true;
                    }
                    shiftRight();
                }

                // 초기 값으로 다시 저장하고 shiftDown
                for (int j = 0; j < size; j++) {
                    matrix[j] = temp[j].clone();
                }

                shiftDown();
            }
        }
        return false;
    }
    
    boolean validation(int[][] lock) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                int key = matrix[M + i][M + j];
                
                if (key == 1 && lock[i][j] == 1) {
                    return false;
                }
                
                if (key == 0 && lock[i][j] == 0) {
                    return false;
                }
            }
        }
        return true;
    }
    
    int[][] rotate(int[][] key) {
        int[][] result = new int[M][M];
        
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < M; j++) {
                result[j][M - 1 - i] = key[i][j];
            }
        }
        return result;
    }
    
    void shiftRight() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size - 1; j++) {
                matrix[i][size - 1 - j] = matrix[i][size - 2 - j];
            }
            
            matrix[i][0] = 0;
        }
    }
    
    void shiftDown() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size - 1; j++) {
                matrix[size - 1 - j][i] = matrix[size - 2 - j][i];
            }
            
            matrix[0][i] = 0;
        }
    }
    
    void print() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("==========");
    }
}