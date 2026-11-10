
import java.util.*;
import java.io.*;

public class Main {

    public static int[][] building;

    public static int[] dy = {-1, 1, 0, 0};
    public static int[] dx = {0, 0, -1, 1};

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int q = Integer.parseInt(st.nextToken());

        building = new int[n][m];
        int[][] queries = new int[q][4];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                building[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < q; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 4; j++) {
                queries[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < q; i++) {
            rotate(queries[i]);
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                sb.append(building[i][j]).append(" ");
            }
            sb.append("\n");
        }

        System.out.print(sb);
    }


    private static void rotate(int[] query) {

        int r1 = query[0] - 1;
        int c1 = query[1] - 1;
        int r2 = query[2] - 1;
        int c2 = query[3] - 1;

        int r1c2 = building[r1][c2];
        int r2c2 = building[r2][c2];
        int r2c1 = building[r2][c1];
        int r1c1 = building[r1][c1];

      
        for (int i = c2; i > c1 + 1; i--) {
            building[r1][i] = building[r1][i - 1];
        }
        building[r1][c1 + 1] = r1c1;

    
        for (int i = r2; i > r1 + 1; i--) {
            building[i][c2] = building[i - 1][c2];
        }
        building[r1 + 1][c2] = r1c2;

        
        

        for (int i = c1; i < c2 - 1; i++) {
            building[r2][i] = building[r2][i + 1];
        }
        building[r2][c2 - 1] = r2c2;

  
  
        for (int i = r1; i < r2 - 1; i++) {
            building[i][c1] = building[i + 1][c1];
        }
        building[r2 - 1][c1] = r2c1;

        // 평균 
        getAvg(r1, c1, r2, c2);
    }


    private static void getAvg(int r1, int c1, int r2, int c2) {

        int n = building.length;
        int m = building[0].length;

        int[][] copy = new int[n][m];

        for (int i = 0; i < n; i++) {
            copy[i] = building[i].clone();
        }

        for (int y = r1; y <= r2; y++) {
            for (int x = c1; x <= c2; x++) {

                int sum = copy[y][x];
                int count = 1;

                for (int d = 0; d < 4; d++) {

                    int ny = y + dy[d];
                    int nx = x + dx[d];

                    if (ny < 0 || ny >= n || nx < 0 || nx >= m) {
                        continue;
                    }

                    sum += copy[ny][nx];
                    count++;
                }

                building[y][x] = sum / count;
            }
        }
    }
}
