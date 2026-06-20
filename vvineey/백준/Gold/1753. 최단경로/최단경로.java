import java.util.*;
import java.io.*;

public class Main {
    
    static int v,e,k;
    static int [] result;
    static boolean[] visited;
    static ArrayList<ArrayList<Node>> graph = new ArrayList<>();

    static class Node{
        int v;
        int w;

        public Node(int v, int w){
            this.v = v;
            this.w = w;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
 
        v = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(br.readLine());

        result = new int[v+1];
        visited = new boolean[v+1];

        for (int i = 1; i<= v; i++){
            result[i] = Integer.MAX_VALUE;
        }

         for(int i=0;i<v+1;i++){
            graph.add(new ArrayList<>());
        }

        for (int i = 0;i<e;i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int z = Integer.parseInt(st.nextToken());

            graph.get(x).add(new Node(y,z));
        }

        dijkstra(k);


        for (int i = 1; i <= v; i++) {
            System.out.println(result[i] == Integer.MAX_VALUE ? "INF" : result[i]);
        }
    }


    static void dijkstra(int start){

    PriorityQueue<Node> q = new PriorityQueue<>((a, b) -> a.w - b.w);

        q.add(new Node(start,0));  
        result[start] = 0;   

        while(!q.isEmpty()){
    
            Node now = q.poll();

            if(visited[now.v]){   
                continue;
            }else{  
                visited[now.v] = true;
                for(Node next : graph.get(now.v)){
                    if(result[next.v] > result[now.v] + next.w){
                        result[next.v] = result[now.v] + next.w;
                        q.add(new Node(next.v,result[next.v]));
                    }
                }

            }
        }
    }

}
