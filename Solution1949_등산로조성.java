import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

//SWEA :: 1949 등산로조성
//2019-04-01
public class Solution1949_등산로조성 {
	private static int[][] map;
	private static boolean[][] visit;
	private static int N;
	private static int K;
	private static ArrayList<pair> top;
	private static int bottom;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken()); // 최대 K만큼 한 번 지형을 깎는다

			map = new int[N][N];
			top = new ArrayList<>();
			int max = -1;
			bottom = 21;
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					if (max < map[i][j]) {
						max = map[i][j];
						top.clear();
						top.add(new pair(i, j));
					} else if (max == map[i][j]) {
						top.add(new pair(i, j));
					}
					bottom = bottom > map[i][j] ? map[i][j] : bottom;
				}
			} ////// input

			ans = -1;
			for (pair p : top) {
				visit = new boolean[N][N];
				dfs(p.y, p.x, 1, false);

			}

			System.out.println("#" + tc + " " + ans);
		} // end of tc
	}// end of main

	static int[] dy = { -1, 1, 0, 0 };
	static int[] dx = { 0, 0, -1, 1 };
	static int ans;

	private static void dfs(int y, int x, int len, boolean cut) {
		// cut이 true 면 공사를 했다.

		visit[y][x] = true;

		ans = ans < len ? len : ans;

		for (int i = 0; i < 4; i++) {
			int ny = y + dy[i];
			int nx = x + dx[i];
			if (ny < 0 || ny > N - 1 || nx < 0 || nx > N - 1 || visit[ny][nx])
				continue;
			if (map[ny][nx] < map[y][x]) {
				dfs(ny, nx, len + 1, cut);
			} else { // 같거나 높으면
				if (!cut) { // cut이 false면 아직 공사를 안한 상태
					for (int k = 1; k <= K; k++) {
						int tmp = map[ny][nx];
						map[ny][nx] -= k;
						if (map[ny][nx] < map[y][x])
							dfs(ny, nx, len + 1, true);
						map[ny][nx] = tmp;
					}
				}
			}
			visit[ny][nx] = false;
		}

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
