
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_1824_혁진이의프로그램검증_유승아 {
	static int R, C;
	static char[][] arr;
	static String[][] visit;
	static int[] dy = { -1, 1, 0, 0 };
	static int[] dx = { 0, 0, -1, 1 }; // 상하좌우

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			R = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());
			arr = new char[R][C];
			visit = new String[R][C];

			for (int i = 0; i < R; i++) {
				String str = br.readLine();
				for (int j = 0; j < C; j++) {
					arr[i][j] = str.charAt(j);
					visit[i][j] = "";
				}
			} // input

			// 0 상 / 1 하 / 2 좌 / 3 우
			boolean isSuccess = solve();
			System.out.println("#" + tc + " " + (isSuccess ? "YES" : "NO"));

		} // end of tc

	}// end of main

	// 이게 되겟니?

	static public boolean solve() {
		// 0 상 / 1 하 / 2 좌 / 3 우
		Queue<pair> q = new LinkedList<>();
//		visit[y][x] += "*"+M+dir+"*";
		q.add(new pair(0, 0, 3, 0));

		while (!q.isEmpty()) {
			pair p = q.poll();
			int dir = p.dir;
			int tmpmem = p.mem;
			char now = arr[p.y][p.x];
			if (now != '?') {
				switch (now) {
				case '<':
					dir = 2;
					break;
				case '>':
					dir = 3;
					break;
				case '^':
					dir = 0;
					break;
				case 'v':
					dir = 1;
					break;
				case '_':
					if (tmpmem == 0)
						dir = 3;
					else
						dir = 2;
					break;
				case '|':
					if (tmpmem == 0)
						dir = 1;
					else
						dir = 0;
					break;
				case '@': // 프로그램 끝!!
					return true;

				case '+':
					if (tmpmem == 15)
						tmpmem = 0;

					else
						tmpmem++;
					break;
				case '-':
					if (tmpmem == 0)
						tmpmem = 15;

					else
						tmpmem--;
					break;

				default:
					if ('0' <= now && now <= '9') {
						tmpmem = now - '0';
						break;
					}
				}
				String log = "*" + tmpmem + dir + "*";
				if (visit[p.y][p.x].contains(log)) {

				} else {
					visit[p.y][p.x] += log;

					int ny = p.y + dy[dir];
					int nx = p.x + dx[dir];
					if (ny > R - 1)
						ny = 0;
					else if (ny < 0)
						ny = R - 1;
					if (nx > C - 1)
						nx = 0;
					else if (nx < 0)
						nx = C - 1;

					q.add(new pair(ny, nx, dir, tmpmem));
				}

			} else { // '?'인 경우

				for (int d = 0; d < 4; d++) {

					String log = "*" + tmpmem + d + "*";
					if (visit[p.y][p.x].contains(log)) {

					} else {
						visit[p.y][p.x] += log;

						int ny = p.y + dy[d];
						int nx = p.x + dx[d];
						if (ny > R - 1)
							ny = 0;
						else if (ny < 0)
							ny = R - 1;
						if (nx > C - 1)
							nx = 0;
						else if (nx < 0)
							nx = C - 1;

						q.add(new pair(ny, nx, d, tmpmem));
					}

				}
			}

		} // end of while
		return false;
	} // end of solve

	public static class pair {
		int y;
		int x;
		int dir;
		int mem;

		public pair(int y, int x, int dir, int mem) {
			super();
			this.y = y;
			this.x = x;
			this.dir = dir;
			this.mem = mem;
		}
	}
}
