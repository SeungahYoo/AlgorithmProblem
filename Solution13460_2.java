import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//BOJ :: 13460 구슬탈출(2)
//2019-03-22

public class Solution13460_2 {

	static int N, M, min;
	static char[][] map;
	static int[] dy = { -1, 1, 0, 0 };
	static int[] dx = { 0, 0, -1, 1 }; // 상하좌우
	
	static class pairs {
		int ry,rx,by,bx;

		public pairs(int ry, int rx, int by, int bx) {
			super();
			this.ry = ry;
			this.rx = rx;
			this.by = by;
			this.bx = bx;
		}
		
	}
	
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
	}
	
	public static void bfs() {
		
	}
}
