import java.util.*;

class Solution {

    class Matrix {
        int[][] matrix;

        Matrix(int[][] matrix) {
            this.matrix = matrix;
        }
    }

    static final int[] dx = {1, -1, 0, 0};
    static final int[] dy = {0, 0, -1, 1};

    static int[][] game_board;
    static int[][] table;
    static int n;
    static boolean[][] visited;

    static HashMap<Integer, List<Matrix>> hm;
    static HashMap<Integer, List<Matrix>> hm2;

    public int solution(int[][] game_board, int[][] table) {
        this.game_board = game_board;
        this.table = table;
        
        n = game_board.length;
        visited = new boolean[n][n];
        
        hm = new HashMap<>();
        hm2 = new HashMap<>();
        
        // System.out.println("회전 테스트 ㅠㅠ");
        // n = 3;
        // rotate( new Matrix(new int[][]{{0, 0, 0},{1, 1, 0},{1, 1, 1}}));
        

        
        //게임 보드 해시맵ㄷ
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                
                if (game_board[i][j] == 0 && !visited[i][j]) {
                    
                    bfs(i, j,0,hm);
                }
                
            }
        }
        
        //테이블 해시맵
        visited = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                
                if (table[i][j] == 1 && !visited[i][j]) {
                    bfs(i, j, 1, hm2);
                }
                
            }
        }
        
//         ///////////
//         printHm(hm);
//         System.out.println("====================");
//         printHm(hm2);
        
        int answer = 0;

        for (int key : hm.keySet()) {
            if (!hm2.containsKey(key)) {
                continue;
            }

            List<Matrix> boardList = hm.get(key);
            List<Matrix> puzzleList = hm2.get(key);

             for (int i = 0; i < boardList.size(); i++) {
                for (int j= 0; j < puzzleList.size(); j++) {
                    
                    
                
                    if (isMatch(boardList.get(i), puzzleList.get(j))) {
                    
                        // 맞으면 해시맵 리스트에서 제거
                        // System.out.println("똑같아가지고 하나 뺌 " +  key);
                        
                        puzzleList.remove(j); 
                        answer += key;
                        break; 
                    }
                }
            }
        }

        return answer;
    }
    
    
    private boolean isMatch(Matrix boardMatrix, Matrix puzzleMatrix) {
        Matrix currentPuzzle = puzzleMatrix;

        for (int i = 0; i < 4; i++) {
            
            if (isSame(boardMatrix.matrix, currentPuzzle.matrix)) {
                
                // System.out.println("똑같다!! " + (i*90) + "도 회전함");
                return true; 
            }
            
            currentPuzzle = rotate(currentPuzzle); 
        }

        return false;
    }
    
    
    private void bfs(int startX, int startY, int target, HashMap<Integer, List<Matrix>> map) {
        
        
        Queue<int[]> queue = new ArrayDeque<>();
        List<int[]> list = new ArrayList<>();
        int[][] board = (target == 0 ? game_board : table);

        visited[startX][startY] = true;
        queue.offer(new int[]{startX, startY});

        int minX = startX;
        int maxX = startX;
        int minY = startY;
        int maxY = startY;

        while (!queue.isEmpty()) {
            
            int[] current = queue.poll();
            list.add(current);

            int x = current[0];
            int y = current[1];

            minX = Math.min(minX, x);
            maxX = Math.max(maxX, x);
            minY = Math.min(minY, y);
            maxY = Math.max(maxY, y);

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx < 0 || nx >= n || ny < 0 || ny >= n) {
                    continue;
                }
                if (visited[nx][ny] ){
                     continue;
                }
                if (board[nx][ny] != target) {
                    continue;
                }

                visited[nx][ny] = true;
                queue.offer(new int[]{nx, ny});
            }
        }

//         System.out.println("크기 " + (maxX - minX + 1) + " " + (maxY - minY + 1));
        
        int[][] matrix = new int[maxX - minX + 1][maxY - minY + 1];

        for (int[] arr : list) {
            matrix[arr[0] - minX][arr[1] - minY] = 1;
        }

        if (!map.containsKey(list.size())) {
            map.put(list.size(), new ArrayList<>());
        }
        map.get(list.size()).add(new Matrix(matrix));
    }
    
    private Matrix rotate(Matrix target) {
        
        int rowLength = target.matrix.length;       
        int colLength = target.matrix[0].length;    

        
        //가로 세로 바꾸기
        int[][] rotated = new int[colLength][rowLength];

        for (int i = 0; i < rowLength; i++) {
            for (int j = 0; j < colLength; j++) {
                
                if (target.matrix[i][j] == 1) {
                    
                    rotated[j][rowLength - i - 1] = 1;
                }
            }
        }

        return new Matrix(rotated);
    }

    private boolean isSame(int[][] arr1, int[][] arr2) {
    
        
        //가로 세로 길이가 다르면 안 됨
        //0 0 1
        //0 1 1
        
        //0 0
        //1 0 
        //1 1
        
        
        if (arr1.length != arr2.length || arr1[0].length != arr2[0].length){
            return false;
        }
        

        for (int i = 0; i < arr1.length; i++) {
            for (int j = 0; j < arr1[0].length; j++) {
                
                if (arr1[i][j] != arr2[i][j]) {
                    return false;
                    
                }
            }
        }
        return true;
    }
    
    private void printHm(HashMap<Integer, List<Matrix>> hm){
        
        hm.forEach((key,value)->{
            System.out.println();
            System.out.println("key " + key);

            for (Matrix arr : value){
                for (int i = 0; i < arr.matrix.length; i++){
                    for (int j = 0; j < arr.matrix[0].length; j++){
                        System.out.print(arr.matrix[i][j] + " ");
                    }
                    System.out.println();
                    }
                System.out.println();
                }
            
            });
    }
    
    
}
