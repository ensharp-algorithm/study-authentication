import java.util.*;

class Solution {
    
    static String[][] map;
    
    public int solution(String[] maps) {
        
        map = new String[maps.length][maps[0].length()];
        boolean[][] visited = new boolean[maps.length][maps[0].length()];
        
        List<Integer> start = null;
        List<Integer> lever = null;
        
        for (int i = 0; i < maps.length; i++){
            map[i] = maps[i].split("");
        }
        
        for (int i = 0; i < map.length; i++){
            for (int j = 0; j < map[0].length; j++){
                if (map[i][j].equals("S")){
                    start = List.of(i,j);
                }
                if (map[i][j].equals("L")){
                    lever = List.of(i,j);
                }
            }   
        }
    
        
        
        //1
        int step1 = bfs(start,"L");
        if (step1 == -1){
            return -1;
        }
        
        System.out.println("step1 " + step1);
        
        //2
        int step2 = bfs(lever,"E");
        if (step2 == -1){
            return -1;
        }
        
        System.out.println("step2 " + step2);
        
        return step1 + step2;
    }

    
    private int bfs(List<Integer> start, String goal){
        
        int[] dx = {0,0,-1,1};
        int[] dy = {1,-1,0,0};
        int[][][] parent = new int[map.length][map[0].length][2];
        
        Queue<List<Integer>> queue = new ArrayDeque<>();
        boolean[][] visited = new boolean[map.length][map[0].length];
        
        queue.offer(start);
        visited[start.get(0)][start.get(1)] = true;

        while(!queue.isEmpty()){
            List<Integer> current = queue.poll();
            
            if (map[current.get(0)][current.get(1)].equals(goal)) {
                return getPath(start, current, parent) -1;
            }
            
            for (int i = 0; i < 4; i++){
                int nextY = current.get(0) + dy[i];
                int nextX = current.get(1) + dx[i];
                
                if (nextX < 0 || nextY < 0 
                    ||nextY >= map.length   || nextX >= map[0].length 
                    ||visited[nextY][nextX] || map[nextY][nextX].equals("X")){
                    continue;
                }
                
                visited[nextY][nextX] = true;
                queue.offer(List.of(nextY, nextX));
                parent[nextY][nextX][0] = current.get(0);
                parent[nextY][nextX][1] = current.get(1);
            }
        }

        return  -1;
    }
    
    private int getPath(List<Integer> start,List<Integer> end,int[][][] parent) {
    
        List<List<Integer>> path = new ArrayList<>();

        int y = end.get(0);
        int x = end.get(1);

        while (true) {
            path.add(List.of(y, x));

            // 시작점까지 왔으면 종료
            if (y == start.get(0) && x == start.get(1)) {
                break;
            }

            int prevY = parent[y][x][0];
            int prevX = parent[y][x][1];

            y = prevY;
            x = prevX;
        }

        return path.size();
    }
}