import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution14502_연구소 {
	private static int N, M, safe, max;
	static int[][] origin_map;
	static int[][] map;
	static Queue<pair> virus;
	static ArrayList<pair> walls;
	static pair[] selectedWall;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		origin_map = new int[N][M];
		walls = new ArrayList<pair>();
		max = -1;
		virus = new LinkedList<pair>();
		// 0은 빈칸, 1은 벽, 2는 바이러스
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < M; j++) {
				origin_map[i][j] = Integer.parseInt(st.nextToken());
				if (origin_map[i][j] == 2)
					virus.add(new pair(i, j));
				if (origin_map[i][j] == 0)
					walls.add(new pair(i, j));

			}
		}

		selectedWall = new pair[3];
		setWall(0, 0);
		System.out.println(max);
	} // end of main

	// 벽 선택하기 (3개)
	public static void setWall(int len, int k) {
		if (len == 3) {

			mapcopy();

			for (int i = 0; i < 3; i++) {

				pair p = selectedWall[i];
				map[p.y][p.x] = 1; // 벽 세우기
				safe--;
			}

			spreadVirus();

			return;
		}

		for (int i = k; i < walls.size(); i++) {
			selectedWall[len] = walls.get(i);
			setWall(len + 1, i + 1);
		}
	}

	public static void spreadVirus() { // 바이러스 퍼트리기
		int[] dy = { -1, 1, 0, 0 };
		int[] dx = { 0, 0, -1, 1 };

		while (!virus.isEmpty()) {
			pair p = virus.poll();

			for (int i = 0; i < 4; i++) {

				int ny = p.y + dy[i];
				int nx = p.x + dx[i];
				if (ny < 0 || ny > N - 1 || nx < 0 || nx > M - 1 || map[ny][nx] != 0)
					continue;
				map[ny][nx] = 2;
				safe--;
				virus.add(new pair(ny, nx));

			}
		}

		if (max < safe)
			max = safe;

	}

	public static void mapcopy() {
		virus.clear();
		safe = 0;
		map = new int[N][M];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				map[i][j] = origin_map[i][j];
				if (origin_map[i][j] == 2)
					virus.add(new pair(i, j));
				if (origin_map[i][j] == 0)
					safe++;
			}
		}
	}

	public static class pair {
		public pair(int y, int x) {
			super();
			this.y = y;
			this.x = x;
		}

		int y;
		int x;

	}
}
