import java.util.*;

class Solution {
    
    class Node {
        char ch;
        boolean isCrash;

        Node(char ch) {
            this.ch = ch;
            this.isCrash = false;
        }
    }
    
    int[] dy = new int[] { -1, 1, 0, 0 };
    int[] dx = new int[] { 0, 0, -1, 1 };
    int n, m;
    
    public int solution(String[] storage, String[] requests) {
        n = storage.length;
        m = storage[0].length();
        Node[][] matrix = new Node[n + 2][m + 2];
        
        for (int i = 0; i < m + 2; i++) {
            matrix[0][i] = new Node('.');
            matrix[0][i].isCrash = true;
            matrix[n + 2 - 1][i] = new Node('.');
            matrix[n + 2 - 1][i].isCrash = true;
        }
        
        for (int i = 0; i < n; i++) {
            char[] arr = storage[i].toCharArray();
            for (int j = 0; j < m; j++) {
                matrix[i + 1][j + 1] = new Node(arr[j]);
            }
            
            matrix[i + 1][0] = new Node('.');
            matrix[i + 1][0].isCrash = true;
            matrix[i + 1][m + 2 - 1] = new Node('.');
            matrix[i + 1][m + 2 - 1].isCrash = true;
        }
        
        for (String req : requests) {
            char command = req.charAt(0);
            
            // 크레인
            if (req.length() == 2) {
                for (int i = 1; i < n + 1; i++) {
                    for (int j = 1; j < m + 1; j++) {
                        if (matrix[i][j].ch == command) {
                            matrix[i][j].isCrash = true;
                        }
                    }
                }
                continue;
            }
            
            // 지게차
            crash(matrix, command);
        }
        
        // for (int i = 1; i < n + 1; i++) {
        //     for (int j = 1; j < m + 1; j++) {
        //         System.out.print((matrix[i][j].isCrash ? "T" : "F") + " ");
        //     }
        //     System.out.println();
        // }
        
        int noCrashCnt = 0;
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < m + 1; j++) {
                if (!matrix[i][j].isCrash) {
                    noCrashCnt++;
                }
            }
        }
        
        return noCrashCnt;
    }
    
    void crash(Node[][] matrix, char command) {
        boolean[][] visited = new boolean[n + 2][m + 2];
        Queue<int[]> queue = new ArrayDeque<>();
        queue.add(new int[] { 0, 0 });
        visited[0][0] = true;
        
        while(!queue.isEmpty()) {
            int[] poll = queue.poll();
            
            for (int i = 0; i < 4; i++) {
                int curY = poll[0] + dy[i];
                int curX = poll[1] + dx[i];

                if (!isIn(curY, curX) || visited[curY][curX]) {
                    continue;
                }
            
                visited[curY][curX] = true;
                
                if (matrix[curY][curX].isCrash) {
                    queue.add(new int[] { curY, curX });
                } else if (command == matrix[curY][curX].ch) {
                    matrix[curY][curX].isCrash = true;
                }
            }
        }

    }
    
    boolean isIn(int y, int x) {
        return y >= 0 && y < n + 2 && x >= 0 && x < m + 2;
    }
}