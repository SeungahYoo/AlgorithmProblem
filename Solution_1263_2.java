import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_1263_2 {
	static int n=0;
	static int[][] map;
	static int[] rst;
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int INF = Integer.MAX_VALUE;
		int T = Integer.parseInt(bf.readLine());

		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(bf.readLine(), " ");
			n = Integer.parseInt(st.nextToken());

			map = new int[n+1][n+1];
			rst = new int[n+1];
			//int[][] dist = new int[n][n];

			for (int i = 1; i <= n; i++) {
				//Arrays.fill(dist[i], INF);
				for (int j = 1; j <= n; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					if (map[i][j] == 1) {
						//dist[i][j] = 1;
					}
				}
			} // 입력 받기.

			int min = Integer.MAX_VALUE;
			int ans = 0;
			for (int i = 1; i <= n; i++) {

				rst[i] = bfs(i);

				if (rst[i] < min) {
					min = rst[i];
				}
			}
			System.out.println("#"+tc+" "+min);
		} // end of tc
	} // end of main

	static int bfs(int start) {
		boolean[] visited = new boolean[n + 1];
		Queue<pair> q = new LinkedList<pair>();
		visited[start] = true;
		q.add(new pair(start, 0));
		int score = 0;

		while (!q.isEmpty()) {
			int now = q.peek().now;
			int weight = q.peek().weight;
			score += weight;
			q.poll();

			for (int i = 1; i <= n; i++) {
				if (map[now][i]==1 && !visited[i]) {
					visited[i] = true;
					q.add(new pair(i, weight + 1));
				}
			}
		}

		return score;
	}

	public static class pair {
		int now;
		int weight;

		public pair(int now, int weight) {
			super();
			this.now = now;
			this.weight = weight;
		}
	}

}
