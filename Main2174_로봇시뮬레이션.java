import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//BOJ ::
public class Main2174_로봇시뮬레이션 {

	private static int A;
	private static int B;
	private static int[][] map;
	private static pair[] robot;
	private static int[] dy = { -1, 0, 1, 0 }; //상좌하우
	private static int[] dx = { 0, -1, 0, 1 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		A = Integer.parseInt(st.nextToken());
		B = Integer.parseInt(st.nextToken());
		map = new int[B+1][A+1];

		st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		/* 
		 * S : 상 (0)
		 * W : 좌 (1)
		 * N : 하 (2)
		 * E : 우(3)
		 */
		robot = new pair[N + 1];
		// 로봇의 위치
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			char dir = st.nextToken().charAt(0);
			int d=-1;
			if(dir=='S') d = 0;
			if(dir=='W') d = 1;
			if(dir=='N') d = 2;
			if(dir=='E') d = 3;
			
			robot[i] = new pair(x, y, d);
			map[y][x] = i;
		}

		// 명령
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int bot = Integer.parseInt(st.nextToken());
			char o = st.nextToken().charAt(0);
			int r = Integer.parseInt(st.nextToken()); //반복
			pair p = robot[bot];
			int px = p.x;
			int py = p.y;
			int pd = p.dir;
		
			switch (o) {
			case 'R': // 왼쪽 90도 회전 // 
				for (int j = 0; j < r; j++) {
					if(pd==3) pd =0;
					else pd++;
				}
				p.setDir(pd);
				break;
			case 'L': // 오른쪽 90도 회전
				for (int j = 0; j < r; j++) {
					if(pd==0) pd =3;
					else pd--;
				}
				p.setDir(pd);
				break;
			case 'F': // 앞으로 한칸 이동
				for (int j = 0; j < r; j++) {
					int ny = py+dy[pd];
					int nx = px+dx[pd];
					if(ny<1 || ny>B || nx<1 || nx>A) {
						System.out.println("Robot "+bot+" crashes into the wall");
						return;
					}
					if(map[ny][nx]!= 0) {
						System.out.println("Robot "+bot+" crashes into robot "+map[ny][nx]);
						return;
					}
					map[py][px] = 0;
					map[ny][nx] = bot;
					py=ny;
					px=nx;
				}
				p.setY(py);
				p.setX(px);
				break;

			default:
				break;
			}

		}
		System.out.println("OK");

	}// end of main

	static class pair {
		int x;
		int y;
		int dir;
		public int getY() {
			return y;
		}
		public void setY(int y) {
			this.y = y;
		}
		public int getX() {
			return x;
		}
		public void setX(int x) {
			this.x = x;
		}
		public int getDir() {
			return dir;
		}
		public void setDir(int dir) {
			this.dir = dir;
		}
		public pair(int x, int y, int dir) {
			super();
			this.y = y;
			this.x = x;
			this.dir = dir;
		}
	}
}
