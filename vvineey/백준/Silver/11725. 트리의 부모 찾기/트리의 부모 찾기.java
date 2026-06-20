import java.util.*;
import java.io.*;

public class Main {
    
    static ArrayList<ArrayList<Integer>> arr = new ArrayList<>();
    static int parent[];
    static int n,a,b;
    static boolean visited[];



    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());

        visited = new boolean[n+1];
        parent = new int[n+1];

        for(int i = 0;i<=n; i++){
            arr.add(new ArrayList<>());
        }    

        for (int i = 0;i<n-1;i++){
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken()); 

            arr.get(a).add(b);
            arr.get(b).add(a);
        }
        
        DFS(1);

        for (int i = 2;i<parent.length;i++){
            System.out.println(parent[i]);
        }
        
    }


    public static void DFS(int x){
        visited[x] = true;

        for(int i : arr.get(x)){
            
            if(!visited[i]){
                DFS(i);
                parent[i] = x;
            }
        }

    }
}
