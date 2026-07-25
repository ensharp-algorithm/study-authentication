import java.util.*;

class Solution {

    int n;
    int[] dy = new int[] { -1, 1, 0, 0 };
    int[] dx = new int[] { 0, 0, -1, 1 };
    Set<List<int[]>> boards = new HashSet<>();
    List<List<int[]>>[] puzzles;
    boolean[] isUsed;
    
    public int solution(int[][] game_board, int[][] table) {
        int idx = 2;
        n = game_board.length;
        puzzles = new ArrayList[3000];
        isUsed = new boolean[3000];
        
        for (int i = 0; i < 3000; i++) {
            puzzles[i] = new ArrayList<>();
        }
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (game_board[i][j] == 0) {
                    boolean[][] visited = new boolean[n][n];
                    List<int[]> board = createSpace(visited, game_board, 1, i, j);
                    boards.add(board);
                }
                
                if (table[i][j] == 1) {
                    boolean[][] visited = new boolean[n][n];
                    List<int[]> puzzle = createSpace(visited, table, idx, i, j);
                    puzzles[idx++].add(puzzle);
                }
            }
        }
    
        for (int rotate = 0; rotate < 3; rotate++) {
            boolean[][] visited = new boolean[n][n];
            table = rotateTable(table);
            
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (table[i][j] != 0 && !visited[i][j]) {
                        List<int[]> p = createSpace(visited, table, table[i][j], i, j);
                        puzzles[table[i][j]].add(p);
                    }
                }
            }
        }
        
        int answer = 0;
        
        for (int i = 2; i < idx; i++) {            
            if (isUsed[i]) {
                continue;
            }
            
            List<int[]> removed = null;
            
            for (List<int[]> puzzle : puzzles[i]) {
                for (List<int[]> board : boards) {
                    if (isSame(board, puzzle)) {
                        answer += board.size();
                        isUsed[i] = true;
                        removed = board;
                        break;
                    }
                }
                
                if (removed != null) {
                    boards.remove(removed);
                    break;
                }
            }
        }
        return answer;
    }
    
    boolean isSame(List<int[]> board, List<int[]> puzzle) {
        if (board.size() != puzzle.size()) {
            return false;
        }
        
        for (int i = 0; i < board.size(); i++) {
            int[] b = board.get(i);
            int[] p = puzzle.get(i);
            
            if (b[0] != p[0] || b[1] != p[1]) {
                return false;
            }
        }
        return true;
    }
    
    List<int[]> createSpace(boolean[][] visited, int[][] board, int idx, int startY, int startX) {
        List<int[]> result = new ArrayList<>();
        Queue<int[]> queue = new ArrayDeque<>();
        queue.add(new int[] { startY, startX });
        visited[startY][startX] = true;
        
        while(!queue.isEmpty()) {
            int[] poll = queue.poll();
            
            board[poll[0]][poll[1]] = idx;
            result.add(new int[] { poll[0] - startY, poll[1] - startX });
            
            for (int i = 0; i < 4; i++) {
                int y = poll[0] + dy[i];
                int x = poll[1] + dx[i];
                
                if (isIn(y, x) && !visited[y][x]) {
                    if ((idx == 1 && board[y][x] == 0) || (idx != 1 && board[y][x] != 0)) {
                        visited[y][x] = true;
                        queue.add(new int[] { y, x });
                    }
                }
            }
        }
        return result;
    }
    
    int[][] rotateTable(int[][] table) {
        int[][] copy = new int[n][n];
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                copy[j][n - 1 - i] = table[i][j];
            }
        }
        return copy;
    }
    
    void printSpace(List<int[]> space) {
        System.out.println("===========");
        for (int[] b : space) {
            System.out.println(b[0] + " " + b[1]);
        }
    }
    
    void printPuzzles(int[][] table) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(table[i][j] + " ");
            }
            System.out.println();
        }
    }
    
    boolean isIn(int y, int x) {
        return y >= 0 && y < n && x >= 0 && x < n;
    }
}