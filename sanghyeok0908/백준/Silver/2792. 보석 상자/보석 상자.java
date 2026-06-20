import java.io.*;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


    public static void main(String[] args) throws IOException {
        String[] s = br.readLine().split(" ");
        int N = Integer.parseInt(s[0]);
        int M = Integer.parseInt(s[1]);
        int[] arr = new int[M];
        int answer = 0;

        for (int i = 0; i < M; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        int left = 1;
        int right = 1000000000;

        while(left <= right){
            int mid = (left + right) / 2;

            int groupCount = 0;

            for (int i = 0; i < M; i++){
                groupCount += arr[i] / mid;

                if (arr[i] % mid != 0){
                    groupCount++;
                }
            }
            if (groupCount <= N){ //  나눠줄 수 있음
                right = mid - 1;
                answer = mid;
            }
            else{
                left = mid + 1;
            }
        }

        bw.write(answer+"\n");


        br.close();
        bw.close();
    }
}