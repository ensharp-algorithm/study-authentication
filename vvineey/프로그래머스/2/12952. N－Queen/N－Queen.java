import java.util.*;

class Solution {
    static int[][] board;
    static int answer;
    
    public int solution(int n) {
        board = new int[n][n];
        answer = 0;
        play(0);
        return answer;
    }
    
    private void play(int y){
        
        if (y == board.length){
            answer++;
            return;
        }
        
        for (int x = 0; x < board.length; x++){

            if (canPut(List.of(y,x))){
                board[y][x] = 1;
                play(y + 1);
                board[y][x] = 0;
            }
        }
    }
    
    private boolean canPut(List<Integer> location) {
        int[] dx = {-1, 0, 1};

        for (int i = 0; i < 3; i++) {
            int nextY = location.get(0) - 1;
            int nextX = location.get(1) + dx[i];
            
            while (nextY >= 0 &&
                   nextX >= 0 &&
                   nextX < board.length) {
                
                if (board[nextY][nextX] == 1) {
                    return false;
                }

                nextY--;
                nextX += dx[i];
            }
        }
        return true;
    }
}