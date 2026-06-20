import java.util.*;
import java.io.*;

public class Main {

    static int n,k;
    static int [] visited;


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        visited = new int[100001];
        Arrays.fill(visited,-1);
        System.out.println(BFS());

    }

    public static int BFS(){

        if (n == k){
            return 0;
        }

        Queue<Integer> queue = new LinkedList<Integer>();
        queue.add(n);
        visited[n] = 0;

        while(!queue.isEmpty()){
            int x = queue.poll();
            
            int nextX = x-1;
            if (nextX >= 0 && visited[nextX] == -1){
                visited[nextX] = visited[x] + 1;
                if (nextX == k) return visited[nextX];
                queue.add(nextX);
            }

            nextX = x+1;
                if (nextX<= 100000 && visited[nextX] == -1){
                visited[nextX] = visited[x] + 1;
                if (nextX == k) return visited[nextX];
                queue.add(nextX);
            }

            
            nextX = x * 2;
                if (nextX<= 100000 &&visited[nextX] == -1){
                visited[nextX] = visited[x] + 1;
                if (nextX == k) return visited[nextX];
                queue.add(nextX);
            }
        }

        return visited[k];
    }
}
