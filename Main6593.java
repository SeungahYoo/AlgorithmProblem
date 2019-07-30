import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//boj :: 6593 상범빌딩
//2019-07-30
public class Main6593 {
	static char[][][] map;
	static boolean[][][] visit;
	static int L, R, C;
	static int[] dz = { 0, 0, 0, 0, 1, -1 };
	static int[] dy = { 0, 0, 1, -1, 0, 0 };
	static int[] dx = { 1, -1, 0, 0, 0, 0 }; // 동서남북 상 하 ?
	static pair start;
	static pair exit;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		while (true) {
			st = new StringTokenizer(br.readLine());
			L = Integer.parseInt(st.nextToken()); // 빌딩의 층 수
			R = Integer.parseInt(st.nextToken()); // 한 층의 행
			C = Integer.parseInt(st.nextToken()); // 한 층의 열

			if (L == 0 && R == 0 && C == 0) { // 입력의 끝
				return;
			}

			map = new char[L][R][C];
			visit = new boolean[L][R][C];

			for (int k = 0; k < L; k++) {
				for (int i = 0; i < R; i++) {
					String str = br.readLine();
					for (int j = 0; j < C; j++) {
						map[k][i][j] = str.charAt(j);
						if (map[k][i][j] == 'S') { // 시작점
							start = new pair(k, i, j);
						} else if (map[k][i][j] == 'E') { // 출구
							exit = new pair(k, i, j);
						}
					}
				}
				br.readLine();
			} //// input

			solve();
//			System.out.println();
		}
	}

	public static void solve() {
		Queue<pair> que = new LinkedList<>();
		boolean isExit = false;
		que.add(start);
		visit[start.z][start.y][start.x] = true;
		int time = 0;
		while (!que.isEmpty()) {
			int qSize = que.size();
			for (int t = 0; t < qSize; t++) {
				pair p = que.poll();
				if (map[p.z][p.y][p.x] == 'E') {
					isExit = true;
					break;
				}
				for (int i = 0; i < 6; i++) {
					int nz = p.z + dz[i];
					int ny = p.y + dy[i];
					int nx = p.x + dx[i];

					if (nz < 0 || ny < 0 || nx < 0 || nz > L - 1 || ny > R - 1 || nx > C - 1 || visit[nz][ny][nx]
							|| map[nz][ny][nx] == '#')
						continue;
					
					visit[nz][ny][nx] = true;
					//System.out.println((time+1)+"s: "+nz+" "+ny+" "+nx);
					que.add(new pair(nz, ny, nx));
				}
				
			} // 1초 단위
			time++;
			if (isExit)
				break;
		}
		if (isExit) { // 탈출 성공
			System.out.println("Escaped in " + (time-1) + " minute(s).");
		} else { // 탈출 실패
			System.out.println("Trapped!");
		}
	}

	static class pair {
		int z;
		int y;
		int x;

		public pair(int z, int y, int x) {
			super();
			this.z = z;
			this.y = y;
			this.x = x;
		}
	}
}