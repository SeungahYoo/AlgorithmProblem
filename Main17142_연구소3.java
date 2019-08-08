import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

//2019-08-08
public class Main17142_연구소3 {
	private static int N, M, ans;
	private static int empty;
	private static int[][] map;
	private static List<pair> space;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken()); // 활성화할 바이러스
		space = new ArrayList<>();
		map = new int[N][N];
		empty = 0;
		// 0은 빈칸, 1은 벽, 2는 바이러스위치
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 2) {
					space.add(new pair(i, j));
				} else if (map[i][j] == 0) {
					empty++;
				}
			}
		}

		if (empty == 0) {
			System.out.println("0");
			return;
		}
		set = new pair[M];
		ans = Integer.MAX_VALUE;
		chooseSpace(0, 0);
		if (ans == Integer.MAX_VALUE)
			ans = -1;
		System.out.println(ans);
	}// end of main

	private static pair[] set;

	public static void chooseSpace(int len, int k) {
		// list에서 m개를 골라라 .
		if (len == M) {
			int ret = activateVirus();
			if (ret > 0) {
				ans = ans > ret ? ret : ans;
			}
			return;
		}
		for (int i = k; i < space.size(); i++) {
			set[len] = space.get(i);
			chooseSpace(len + 1, i + 1);
		}
	}

	static int[] dy = { -1, 1, 0, 0 };
	static int[] dx = { 0, 0, -1, 1 };

	public static int activateVirus() {
		int remain = empty;
		Queue<pair> que = new LinkedList<>();
		boolean[][] visit = new boolean[N][N];
		for (pair p : set) {
			que.add(p);
			visit[p.y][p.x] = true;
		}

		int time = 0;
		while (!que.isEmpty()) {
			time++;
			int qSize = que.size();
			for (int q = 0; q < qSize; q++) {
				pair poll = que.poll();
				for (int d = 0; d < 4; d++) {
					int ny = poll.y + dy[d];
					int nx = poll.x + dx[d];

					if (ny < 0 || ny > N - 1 || nx < 0 || nx > N - 1 || visit[ny][nx] || map[ny][nx] == 1) {
						continue;
					}
					if (map[ny][nx] == 0) {// 빈칸인 경우
						remain--;
						if (remain == 0) {
							return time;
						}
					}
					que.add(new pair(ny, nx));
					visit[ny][nx] = true;
				}
			}
		}

		return 0;
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
