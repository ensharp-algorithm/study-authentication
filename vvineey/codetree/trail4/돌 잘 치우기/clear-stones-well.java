import java.util.*;

public class Main {

    static ArrayList<int[]> stones = new ArrayList<>();
    static int answer = 0;

    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();
        int m = sc.nextInt();

        // 배열 크기 +1
        int[][] grid = new int[n + 1][n + 1];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                grid[i][j] = sc.nextInt();
            }
        }

        int[][] startPoints = new int[k + 1][2];

        for (int i = 1; i <= k; i++) {
            startPoints[i][0] = sc.nextInt();
            startPoints[i][1] = sc.nextInt();
        }

        // 1. 돌 위치 저장
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (grid[i][j] == 1) {
                    stones.add(new int[]{i, j});
                }
            }
        }

        // 2. DFS로 돌 m개 선택
        dfs(0, 0, m, n, grid, startPoints, k);

        System.out.println(answer);
    }

    // DFS: 돌 m개 선택
    static void dfs(int idx, int cnt, int m, int n,
                    int[][] grid, int[][] startPoints, int k) {

        if (cnt == m) {
            answer = Math.max(answer, bfs(n, grid, startPoints, k));
            return;
        }

        if (idx == stones.size()) {
            return;
        }

        int[] stone = stones.get(idx);
        int r = stone[0];
        int c = stone[1];

        // 현재 돌 제거
        grid[r][c] = 0;
        dfs(idx + 1, cnt + 1, m, n, grid, startPoints, k);

        // 원상복구
        grid[r][c] = 1;

        // 현재 돌 제거하지 않기
        dfs(idx + 1, cnt, m, n, grid, startPoints, k);
    }

    // BFS: 방문 가능한 칸 개수
    static int bfs(int n, int[][] grid, int[][] startPoints, int k) {

        boolean[][] visited = new boolean[n + 1][n + 1];
        Queue<int[]> q = new ArrayDeque<>();

        int count = 0;

        // 모든 시작점 추가
        for (int i = 1; i <= k; i++) {
            int r = startPoints[i][0];
            int c = startPoints[i][1];

            if (visited[r][c]) continue;

            visited[r][c] = true;
            q.offer(new int[]{r, c});
            count++;
        }

        while (!q.isEmpty()) {

            int[] cur = q.poll();
            int r = cur[0];
            int c = cur[1];

            for (int d = 0; d < 4; d++) {
                int nr = r + dr[d];
                int nc = c + dc[d];

                // 범위 검사 (1부터 n까지)
                if (nr < 1 || nr > n || nc < 1 || nc > n) {
                    continue;
                }

                // 이미 방문했다면
                if (visited[nr][nc]) {
                    continue;
                }

                // 돌이 있다면
                if (grid[nr][nc] == 1) {
                    continue;
                }

                visited[nr][nc] = true;
                q.offer(new int[]{nr, nc});
                count++;
            }
        }

        return count;
    }
}