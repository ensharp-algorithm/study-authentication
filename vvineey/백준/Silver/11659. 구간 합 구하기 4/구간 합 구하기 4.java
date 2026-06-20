import java.util.*;
import java.io.*;

public class Main {
    static int[] arr;
    static int n,m;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int [n+1];
        arr[0] = 0;
        st = new StringTokenizer(br.readLine()); 

        for (int i = 0; i < n; i++){
            arr[i + 1] = arr[i] + Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            
            System.out.println(arr[end]- arr[start -1]);
        }
    }
}
