import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

//BOJ 13460 구슬탈출2
//2019-03-19

/*
 *  '.'은 빈 칸을 의미하고, 
 *  '#'은 공이 이동할 수 없는 장애물 또는 벽을 의미하며, 
 *  'O'는 구멍의 위치를 의미한다. 
 *  'R'은 빨간 구슬의 위치, 'B'는 파란 구슬의 위치이다.
 */

public class Solution13460 {
	static int N, M, min;
	static char[][] map;
	static int[] dy = { -1, 1, 0, 0 };
	static int[] dx = { 0, 0, -1, 1 }; // 상하좌우

	static class pair {
		int y;
		int x;

		public pair(int y, int x) {
			super();
			this.y = y;
			this.x = x;
		}

	}
	static Stack<pair> blue;
	static Stack<pair> red;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken()); // 세로
		M = Integer.parseInt(st.nextToken()); // 가로
		map = new char[N][M];
		int ry = -1, rx = -1, by = -1, bx = -1;
		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = str.charAt(j);
				if (map[i][j] == 'R') {
					ry = i;
					rx = j;
				}
				if (map[i][j] == 'B') {
					by = i;
					bx = j;
				}
			}
		}
		/// input
		blue = new Stack<>();
		red = new Stack<>();
		min = Integer.MAX_VALUE;

		for (int i = 0; i < 4; i++) {
			dfs(1, i, ry, rx, by, bx);
			map[ry][rx] = 'R';
			map[red.peek().y][red.peek().x] = '.';
			red.pop();
			map[by][bx] = 'B';
			map[blue.peek().y][blue.peek().x] = '.';
			blue.pop();
			
		}

		System.out.println(min);
	}// end of main

	// 기울이는 방향에 대한 dfs
	public static void dfs(int cnt, int dir, int ry, int rx, int by, int bx) {
		if (cnt > 10) {
			// -1 출력
			return;
		}

		if (map[by][bx] == 'O') {
			// 실패
			return;
		}

		if (map[ry][rx] == 'O') {
			// 성공
			min = min > cnt ? cnt : min;
			return;
		}

		int whichball = whichBall(ry, rx, by, bx, dir);
		// 0이면 아무거나 / 1이면 빨간 구슬 / 2이면 파란 구슬
		pair p;
		int nry,nrx,nby,nbx;
		if (whichball == 1) {
			map[ry][rx] = '.';
			p = rollBall(dir, ry, rx);
			nry = p.y;
			nrx = p.x;
			map[nry][nrx] = 'R';
			red.push(new pair(nry,nrx));
			
			map[by][bx] = '.';
			p = rollBall(dir, by, bx);
			nby = p.y;
			nbx = p.x;
			map[nby][nbx] = 'B';
			blue.push(new pair(nby,nbx));
		} else {
			map[by][bx] = '.';
			p = rollBall(dir, by, bx);
			nby = p.y;
			nbx = p.x;
			map[nby][nbx] = 'B';
			blue.push(new pair(nby,nbx));

			map[ry][rx] = '.';
			p = rollBall(dir, ry, rx);
			nry = p.y;
			nrx = p.x;
			map[nry][nrx] = 'R';
			red.push(new pair(nry,nrx));
		}

		for (int i = 0; i < 4; i++) {
			// 상(0) - 하(1) // 좌(2) - 우(3)
			if ((dir == 0 && i == 1) || (dir == 1 && i == 0) || (dir == 2 && i == 3) || (dir == 3 && i == 2))
				continue; // 지나온 방향에 대해선 continue;

			dfs(cnt + 1, i, nry, nrx, nby, nbx);
			map[red.peek().y][red.peek().x] = '.';
			red.pop();
			map[nry][nrx] = 'R';
			map[blue.peek().y][blue.peek().x] = '.';
			blue.pop();
			map[nby][nbx] = 'B';
			
			
		}
		
		return;
	} // end of dfs

	public static pair rollBall(int dir, int y, int x) {
		while (true) { // 공 굴리기
			int ny = y + dy[dir];
			int nx = x + dx[dir];

			if (ny > N - 1 || ny < 0 || nx > M - 1 || nx < 0)
				break;
			if (map[ny][nx] == 'O') {
				break;
			} else if (map[ny][nx] != '.')
				break;
			y = ny;
			x = nx;
		}
		return new pair(y, x);
	}

	public static int whichBall(int ry, int rx, int by, int bx, int dir) {
		// 0이면 아무거나
		// 1이면 빨간 구슬
		// 2이면 파란 구슬

		if (ry == by && (Math.abs(rx - bx) == 1)) {
			if (dir == 2) { // 왼쪽
				// x값이 작은 공부터 굴린다.
				if (rx < bx) {
					return 1;
				} else {
					return 2;
				}

			} else if (dir == 3) { // 오른쪽

				if (rx > bx) {
					return 1;
				} else {
					return 2;
				}
			}
		} else if (rx == bx && ((Math.abs(ry - by) == 1))) {
			if (dir == 0) { // 위
				// y값이 작은 공부터 굴린다.
				if (ry < by) {
					return 1;
				} else {
					return 2;
				}

			} else if (dir == 1) { // 아래

				if (ry > by) {
					return 1;
				} else {
					return 2;
				}

			}
		}

		return 0;

	}

}
