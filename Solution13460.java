import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

//BOJ 13460 ����Ż��2
//2019-03-19

/*
 *  '.'�� �� ĭ�� �ǹ��ϰ�, 
 *  '#'�� ���� �̵��� �� ���� ��ֹ� �Ǵ� ���� �ǹ��ϸ�, 
 *  'O'�� ������ ��ġ�� �ǹ��Ѵ�. 
 *  'R'�� ���� ������ ��ġ, 'B'�� �Ķ� ������ ��ġ�̴�.
 */

public class Solution13460 {
	static int N, M, min;
	static char[][] map;
	static int[] dy = { -1, 1, 0, 0 };
	static int[] dx = { 0, 0, -1, 1 }; // �����¿�

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
		N = Integer.parseInt(st.nextToken()); // ����
		M = Integer.parseInt(st.nextToken()); // ����
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

	// ����̴� ���⿡ ���� dfs
	public static void dfs(int cnt, int dir, int ry, int rx, int by, int bx) {
		if (cnt > 10) {
			// -1 ���
			return;
		}

		if (map[by][bx] == 'O') {
			// ����
			return;
		}

		if (map[ry][rx] == 'O') {
			// ����
			min = min > cnt ? cnt : min;
			return;
		}

		int whichball = whichBall(ry, rx, by, bx, dir);
		// 0�̸� �ƹ��ų� / 1�̸� ���� ���� / 2�̸� �Ķ� ����
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
			// ��(0) - ��(1) // ��(2) - ��(3)
			if ((dir == 0 && i == 1) || (dir == 1 && i == 0) || (dir == 2 && i == 3) || (dir == 3 && i == 2))
				continue; // ������ ���⿡ ���ؼ� continue;

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
		while (true) { // �� ������
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
		// 0�̸� �ƹ��ų�
		// 1�̸� ���� ����
		// 2�̸� �Ķ� ����

		if (ry == by && (Math.abs(rx - bx) == 1)) {
			if (dir == 2) { // ����
				// x���� ���� ������ ������.
				if (rx < bx) {
					return 1;
				} else {
					return 2;
				}

			} else if (dir == 3) { // ������

				if (rx > bx) {
					return 1;
				} else {
					return 2;
				}
			}
		} else if (rx == bx && ((Math.abs(ry - by) == 1))) {
			if (dir == 0) { // ��
				// y���� ���� ������ ������.
				if (ry < by) {
					return 1;
				} else {
					return 2;
				}

			} else if (dir == 1) { // �Ʒ�

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
