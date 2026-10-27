import java.util.*;

public class Main {

    private static int answer;
    private static boolean[] visited;
    private static int[][] cost;
    private static int n;



    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        cost = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                cost[i][j] = sc.nextInt();
            }
        }

        answer = Integer.MAX_VALUE;
        visited = new boolean[n];
        visited[0] = true;

        dfs(0,1, 0);
        System.out.println(answer);
    }

    private static void dfs(int idx, int depth, int totalCost){
        
        if (depth >= n){

            if (cost[idx][0] == 0){
                return;
            }
            totalCost += cost[idx][0];
            
            // System.out.println("--------------");
            // System.out.println(totalCost);
            answer = Math.min(answer, totalCost);
            return;
        }

        for (int i = 0; i < n; i++){
            if (visited[i] || cost[idx][i] == 0){
                continue;
            }
            visited[i] = true;
            dfs(i,depth +1, totalCost+ cost[idx][i]);
            visited[i] = false;
        }

        return;
    }
}