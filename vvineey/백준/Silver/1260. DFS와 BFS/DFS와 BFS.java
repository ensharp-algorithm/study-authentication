import java.util.*;
import java.io.*;

public class Main {

    static int n,m,v;
    static int [][] arr;
    static boolean[] visited;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        v = Integer.parseInt(st.nextToken());

        arr = new int[n+1][n+1];
        visited = new boolean[n+1];

        for (int i = 0;i<m;i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            arr[x][y] = arr[y][x] = 1;        
        }
        
        DFS(v);

        System.out.println();
        visited = new boolean[n+1];

        BFS(v);
    
    }

    public static void DFS(int start){
        visited[start] = true;
        System.out.print(start + " ");
        
        if (start == n+1){
            return;
        }

        for (int i = 1; i<=n;i++){
            if (arr[start][i] == 1 && visited[i] == false){
                DFS(i);
            }
        }
    }

   public static void BFS(int start){
    Queue<Integer> queue = new LinkedList<>();
    queue.add(start);
    visited[start] = true;

    System.out.print(start + " ");

    while(!queue.isEmpty()){
        int now = queue.poll();
        for (int i = 0;i<=n;i++){
            if (arr[now][i] == 1 && visited[i] == false){
                queue.add(i);
                visited[i] = true;
                    System.out.print(i + " ");
            }
        }
    }

   }
}
