import java.io.*;
import java.util.*;

public class Solution
{
	static PriorityQueue <double[]> costs;
	static int[] root;
	static double total;
	
	public static void main(String args[]) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= T; tc++) {
			
			int n = Integer.parseInt(br.readLine());
			
			int[][] arr = new int[n][2];
			root = new int[n];
			total = 0.0;
			
			for (int i = 0; i < n; i++) {
				root[i] = i;
			}

			StringTokenizer st = new StringTokenizer(br.readLine());
			StringTokenizer st2 = new StringTokenizer(br.readLine());
			
			for (int i = 0; i <n; i++) {
				arr[i][0] = Integer.parseInt(st.nextToken());
				arr[i][1] = Integer.parseInt(st2.nextToken());
			}
			
			double e = Double.parseDouble(br.readLine());
			
			//비용 우선순위 큐 만들기 O(n*n)
			costs = new PriorityQueue<>((o1,o2)-> {
				if (o1[2] != o2[2]) {
					return Double.compare(o1[2], o2[2]);
				}
				return Double.compare(o1[0], o2[0]);
			});
			
			for (int i = 0; i < n; i++) {
				for (int j = i+1; j < n; j++) {
					double x1 = arr[(int)i][0];
					double y1 = arr[(int)i][1];
					double x2 = arr[(int)j][0];
					double y2 = arr[(int)j][1];
					
					double L =Math.abs(x2-x1) * Math.abs(x2-x1) + Math.abs(y2-y1)* Math.abs(y2-y1);
					costs.offer(new double[]{i,j,e* L});
				}
			}
			
//			while(!costs.isEmpty()) {
//				double[] x = costs.poll();
//				System.out.println(x[0] + " " + x[1] + " " + x[2]);
//			}
			
			 kruskal(n);
			 System.out.printf("#%d %.0f\n",tc,total);
		}

	}
	
	
	private static void kruskal(int n) {
		
		int cnt = 0;
		
		while(!costs.isEmpty()) {

			if (cnt == n-1) {
				break;
			}
			
			double[] edge = costs.poll();
			
			if (union((int)edge[0],(int)edge[1])) {
				total += edge[2];
				cnt++;
			}
		}
	}
	
	private static int find(int x){
		if (root[x] == x) {
			return x;
		}
		return root[x] = find(root[x]);
	}
	
	private static boolean union(int x, int y) {
		
		int rootX = find(x);
		int rootY = find(y);
		
		if (rootX == rootY) {
			return false;
		}
		
		root[rootY] = rootX;
		return true;
	}
}