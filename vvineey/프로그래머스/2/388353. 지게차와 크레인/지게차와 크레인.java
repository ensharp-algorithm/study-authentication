import java.util.*;

class Solution {
    
    static final int [] dx = {0,0,-1,1};
    static final int [] dy = {1,-1,0,0};
    
    static String[] storage;
    static int m,n;
    static HashSet<List<Integer>> removed;
    
    public int solution(String[] storage, String[] requests) {
        
        m = storage.length;
        n = storage[0].length();
        Solution.storage = storage;
        removed = new HashSet<>();
        
        int answer = n * m;
        
        for (String request : requests) {
            if (request.length() == 2) {
                answer -= remove2(request.charAt(0));
            }
            else{
                answer -= remove(request.charAt(0));
            }
        }
        
        return answer;
    }
    
    
    //지게차 
    private int remove(char target) {
        
        int cnt = 0;
        List<List<Integer>> list = new ArrayList<>();

        for (int i = 0; i < m; i++){
            for (int j = 0; j < n; j++){
                
                if (!canRemove(List.of(i,j))) {
                    continue;
                }
                
                if (storage[i].charAt(j) == target && !removed.contains(List.of(i, j))) {
                    cnt++;
                    list.add(List.of(i,j));
                }
            }
        }
        
        for (List<Integer> x : list){
            removed.add(x);
        }
        
        return cnt;
    }
    
    //크레인
    private int remove2(char target) {
        
        int cnt = 0;
        List<List<Integer>> list = new ArrayList<>();
        
        for (int i = 0; i < m; i++){
            for (int j = 0; j < n; j++){
                
                if (storage[i].charAt(j)  == target  && !removed.contains(List.of(i, j)) ) {
                    
                    cnt++;
                    list.add(List.of(i,j));
                }
                
            }
        }

        for (List<Integer> x : list){
            removed.add(x);
        }
        
        return cnt;
    }
    
    private boolean canRemove(List<Integer> target){

        boolean[][] visited = new boolean[m][n];
        Queue<List<Integer>> queue = new ArrayDeque<>();

        int y = target.get(0);
        int x = target.get(1);

        if (y == 0 || y == m-1 || x == 0 || x == n-1) {
            return true;
        }

        visited[y][x] = true;
        queue.offer(target);

        while(!queue.isEmpty()){
            List<Integer> current = queue.poll();

            y = current.get(0);
            x = current.get(1);

            for (int i = 0; i < 4; i++){
                int nextY = y + dy[i];
                int nextX = x + dx[i];

                if (nextY < 0 || nextY >= m ||nextX < 0 || nextX >= n) {
                    continue;
                }

                if (visited[nextY][nextX]) {
                    continue;
                }

                if (removed.contains(List.of(nextY, nextX))) {

                    if (nextY == 0 || nextY == m-1 ||nextX == 0 || nextX == n-1) {
                        return true;
                    }

                    visited[nextY][nextX] = true;
                    queue.offer(List.of(nextY, nextX));
                }
            }
        }

        return false;
    }
}