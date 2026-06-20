import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

	static class Edge {

		public int from, to, weight;

		public Edge(int from, int to, int weight) {
			this.from = from;
			this.to = to;
			this.weight = weight;
		}
	}

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int[] dy = new int[] { -1, 1, 0, 0 };
	static int[] dx = new int[] { 0, 0, -1, 1 };
	static int N, M;
	static int[][] matrix;
	static List<Edge> edges = new ArrayList<>();
	static int[] parent, rank;

	public static void main(String[] args) throws Exception {
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		matrix = new int[N][M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				matrix[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int islandCnt = setNode();
		setEdge();
		edges.sort((o1, o2) -> Integer.compare(o1.weight, o2.weight));

//		print();
//		System.out.println("edge cnt = " + edges.size());
//		for (Edge edge : edges) {
//			System.out.printf("%d %d %d\n", edge.from, edge.to, edge.weight);
//		}

		parent = new int[islandCnt + 2];
		rank = new int[islandCnt + 2];
		for (int i = 2; i < islandCnt + 2; i++) {
			parent[i] = i;
			rank[i] = 1;
		}
		
		int cnt = 1, sum = 0;
		for (Edge edge : edges) {
			if (find(edge.from) == find(edge.to)) {
				continue;
			}

			union(edge.from, edge.to);
			cnt++;
			sum += edge.weight;

			if (islandCnt == cnt + 1)
				break;
		}

//		System.out.println("island cnt = " + islandCnt);
//		System.out.println("edge cnt = " + cnt);

		if (islandCnt == cnt + 1) {
			System.out.println(sum);
		} else {
			System.out.println(-1);
		}
	}

	static int setNode() {
		int number = 2;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (matrix[i][j] == 1) {
					bfs(i, j, number++);
				}
			}
		}
		return number - 1;
	}

	static void bfs(int y, int x, int number) {
		Queue<int[]> queue = new ArrayDeque<>();
		queue.add(new int[] { y, x });
		matrix[y][x] = number;

		while (!queue.isEmpty()) {
			int[] poll = queue.poll();
			for (int i = 0; i < 4; i++) {
				int curY = poll[0] + dy[i];
				int curX = poll[1] + dx[i];

				if (!isIn(curY, curX) || matrix[curY][curX] != 1)
					continue;

				matrix[curY][curX] = number;
				queue.add(new int[] { curY, curX });
			}
		}
	}

	static boolean isIn(int y, int x) {
		return y >= 0 && y < N && x >= 0 && x < M;
	}

	static void setEdge() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (matrix[i][j] != 0) {
					for (int k = 0; k < 4; k++) {
						Edge edge = createEdge(i + dy[k], j + dx[k], matrix[i][j], k, 0);

						if (edge != null) {
							edges.add(edge);
						}
					}
				}
			}
		}
	}

	static Edge createEdge(int y, int x, int fromNum, int idx, int sum) {
		if (!isIn(y, x) || matrix[y][x] == fromNum) {
			return null;
		}

		if (matrix[y][x] == 0) {
			return createEdge(y + dy[idx], x + dx[idx], fromNum, idx, sum + 1);
		}

		return sum < 2 ? null : new Edge(fromNum, matrix[y][x], sum);
	}

	static int find(int a) {
		if (parent[a] == a)
			return a;
		return parent[a] = find(parent[a]);
	}

	static void union(int a, int b) {
		int rootA = find(a);
		int rootB = find(b);

		if (rootA == rootB)
			return;

		if (rank[rootA] < rank[rootB]) {
			parent[rootA] = rootB;
		} else if (rank[rootA] > rank[rootB]) {
			parent[rootB] = rootA;
		} else {
			parent[rootB] = rootA;
			rank[rootA]++;
		}
	}

	static void print() {
		System.out.println("============");
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
		}
	}
}
