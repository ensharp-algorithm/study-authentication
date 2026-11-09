import java.io.*;
import java.util.*;


public class Main {
    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[][] arr = new int[n][2];

        for (int i = 0; i <n; i++){
            String[] strs = br.readLine().split(" ");
            arr[i][0] = Integer.parseInt(strs[0]);
            arr[i][1] = Integer.parseInt(strs[1]);
        }

        Arrays.sort(arr, (o1,o2)->{
            return Integer.compare(o1[1],o2[1]);
        });
        int answer = Integer.MIN_VALUE;
        int left = 0;
        int right = n-1;

        while(left <= right){

            // System.out.println(answer + " vs " +(arr[left][1]+ arr[right][1]));
            
            answer = Math.max(answer, (arr[left][1]+ arr[right][1]));

            arr[left][0]--;
            arr[right][0]--;

            if (arr[left][0] == 0){
                left++;
            }
            if (arr[right][0] == 0){
                right--;
            }
        }

        System.out.println(answer);
    }
}