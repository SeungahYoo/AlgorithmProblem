import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_2146_다리만들기 {
	static int N;
	static int[] dy = { -1, 1, 0, 0 };
	static int[] dx = { 0, 0, -1, 1 };
	static int[][] map;
	static int[][] boundary;
	private static boolean[][] visit;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		boundary = new int[N][N];
		visit = new boolean[N][N];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		} ////// input

		int chk = 1;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (visit[i][j] || map[i][j] == 0)
					continue;
				bfs(i, j, chk);
				chk++;
			}
		}
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (boundary[i][j] <1)
					continue;
				int b = bridge(i, j, boundary[i][j]);
				min = min > b? b:min;
			}
		}

		System.out.println(min);
	}// end of main

	static void bfs(int y, int x, int chk) {
		Queue<pair> que = new LinkedList<>();
		que.add(new pair(y, x));
		visit[y][x] = true;
		boundary[y][x] = -1;
		while (!que.isEmpty()) {
			pair p = que.poll();
			int py = p.y;
			int px = p.x;

			for (int i = 0; i < 4; i++) {
				int ny = py + dy[i];
				int nx = px + dx[i];
				if (ny < 0 || ny > N - 1 || nx < 0 || nx > N - 1 || visit[ny][nx])
					continue;
				if (map[ny][nx] == 1) {
					que.add(new pair(ny, nx));
					visit[ny][nx] = true;
					boundary[ny][nx] = -1;
				}
				if (map[ny][nx] == 0) {
					boundary[py][px] = chk;
				}
			}
		}
	}

	static int bridge(int y, int x, int me) {
		int[][] visit2 = new int[N][N];
		Queue<pair> que = new LinkedList<>();
		que.add(new pair(y, x));
		visit2[y][x] = 1;
		int len = 0;
		while (!que.isEmpty()) {

			len++;
			int qSize = que.size();
			for (int q = 0; q < qSize; q++) {
				pair p = que.poll();
				int py = p.y;
				int px = p.x;

				for (int i = 0; i < 4; i++) {
					int ny = py + dy[i];
					int nx = px + dx[i];
					if (ny < 0 || ny > N - 1 || nx < 0 || nx > N - 1 || visit2[ny][nx] != 0 || boundary[ny][nx] == -1 || boundary[ny][nx]==me)
						continue;
					if (boundary[ny][nx] != 0 && boundary[ny][nx] != -1 && boundary[ny][nx] != me) {
						//System.out.println("("+ny+","+nx+")");
						return len-1;
					}

					if (boundary[ny][nx] ==0) {
						que.add(new pair(ny, nx));
						visit2[ny][nx] = len;
					}
				}
			}
		}
		return len;
	}

	static class pair {
		int y;
		int x;

		public pair(int y, int x) {
			super();
			this.y = y;
			this.x = x;
		}
	}
}
