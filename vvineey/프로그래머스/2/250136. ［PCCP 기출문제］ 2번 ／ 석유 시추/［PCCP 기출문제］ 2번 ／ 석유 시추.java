import java.util.*;

class Solution {
    static int n, m;
    static int[][] land;
    static int[][] oil;
    static int [] dy = {1,-1,0,0};
    static int [] dx = {0,0,-1,1};
    
    public int solution(int[][] land) {
        
        Solution.land = land;
        n = land.length;
        m = land[0].length;
        oil = new int[n][m];

        
        
        //덩어리 인덱스, 석유양 
        HashMap<Integer,Integer> hm = new HashMap<>();
        int idx = 1;
        
        for (int i = 0; i < n; i++){
            for (int j = 0; j < m; j++){
                
                if (land[i][j] == 0 || oil[i][j] != 0){
                    continue;
                }
                int sum = bfs(idx, List.of(i,j));
                if (sum > 0 ){
                    hm.put(idx++, sum);
                    // System.out.println(hm);
                }
            }
        }
        
        int answer = 0;
        
        for (int j = 0; j < m; j++){
            HashSet<Integer> hs = new HashSet<>();
            for (int i = 0; i < n; i++){
                if (oil[i][j] != 0){
                    hs.add(oil[i][j]);
                }
            }
            
            int cnt = 0;
            for (int i : hs){
                cnt += hm.get(i);
            }
            
            answer = Math.max(answer, cnt);
        }
        
        return answer;
    }
    
    private int bfs(int idx, List<Integer> start) {

        Queue<List<Integer>> queue = new ArrayDeque<>();
        int sum = 1;

        queue.offer(start);
        oil[start.get(0)][start.get(1)] = idx;

        while (!queue.isEmpty()) {
            List<Integer> current = queue.poll();
            int y = current.get(0);
            int x = current.get(1);

            for (int i = 0; i < 4; i++) {
                int nextY = y + dy[i];
                int nextX = x + dx[i];

                if (nextY < 0 || nextX < 0 ||
                    nextY >= n || nextX >= m ||
                    land[nextY][nextX] != 1 ||
                    oil[nextY][nextX] != 0) {
                    continue;
                }

                oil[nextY][nextX] = idx;
                queue.offer(List.of(nextY, nextX));
                sum++;
            }
        }

        return sum;
    }   
}