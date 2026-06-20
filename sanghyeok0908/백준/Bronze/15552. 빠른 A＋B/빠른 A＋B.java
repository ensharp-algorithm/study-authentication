import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**

link: https://www.acmicpc.net/problem/15552
perf:
category:
memo:
*/
public class Main {
    private static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    private static  StringBuilder output = new StringBuilder();
    private static StringTokenizer tokens;

    private static int N;
    public static void main(String[] args) throws NumberFormatException, IOException{

        //임시로 instr에서 받아오기!! 제출 시는 주석 필수!!!
        //input = new BufferedReader(new StringReader(instr));
        N=Integer.parseInt(input.readLine());
        for(int n=0; n<N; n++) {
            tokens = new StringTokenizer(input.readLine());
            int a= Integer.parseInt(tokens.nextToken());
            int b= Integer.parseInt(tokens.nextToken());
            output.append(a + b).append('\n');
        }
        System.out.println(output.toString());

    }
    
    private static String instr="5\r\n"
    		 + "1 1\r\n"
    	        + "12 34\r\n"
    	        + "5 500\r\n"
    	        + "40 60\r\n"
    	        + "1000 1000";
};