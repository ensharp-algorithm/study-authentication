import java.util.*;

class Solution {

    boolean[] visited;
    int[][] dungeons;
    int maxCnt;

    public int solution(int k, int[][] dungeons) {

        this.visited = new boolean[dungeons.length];
        this.dungeons = dungeons;
        this.maxCnt = 0;

        dfs(k, 0);

        return maxCnt;
    }

    private void dfs(int life, int cnt) {
        
        // System.out.println("cnt " + cnt + " life " + life);
        // System.out.println();

        maxCnt = Math.max(maxCnt, cnt);

        for (int i = 0; i < dungeons.length; i++) {

            if (visited[i]) {
                continue;
            }

            if (life < dungeons[i][0]) {
                continue;
            }

            visited[i] = true;

            dfs(life - dungeons[i][1],cnt + 1);

            visited[i] = false;
        }
    }
}