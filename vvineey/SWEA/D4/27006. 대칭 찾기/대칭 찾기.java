
import java.io.*;
import java.util.*;

public class Solution
{
	public static void main(String args[]) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= T ; tc++) {
			int n = Integer.parseInt(br.readLine());
			
			char [][] arr = new char[n][n];
			
			for (int i = 0; i < n; i++) {
				arr[i] = br.readLine().toCharArray();
			}
			
			//arr2[i][j] = arr[i+A%n][j+B%n]
			//arr2[i][j] = arr[i-A&n][i-B&n]
			
			int cnt = 0;
			
			//A,B 선택
			for (int B = 0; B < n; B++) {
					
				boolean breakPoint = false;
					
				if (breakPoint) {
					break;
				}
					
				for (int i = 0; i < n; i++) {
					for (int j = i+1; j < n; j++) {
							
						int row = i;
						int col = (j-B +n) %n;
							
						int row2 = j;
						int col2 = (i-B +n) %n;
							
//						System.out.println(row + " " + col + " " + row2 + " " + col2);
							
						if (arr[row][col] != arr[row2][col2]) {
							breakPoint = true;
							break;
						}
					}
				}
					if (!breakPoint) {
						cnt+=n;
					}
				
			}
			System.out.println(cnt);
		}
	}
}