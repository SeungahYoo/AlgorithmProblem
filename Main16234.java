import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//BOJ :: 16234 인구이동
//2019-03-25
public class Main16234 {
	private static int N,L,R,stop;
	private static int[][] map;
	private static boolean[][] visit;
	static int[] dy = { -1, 1, 0, 0 };
	static int[] dx = { 0, 0, -1, 1 };
	static ArrayList<pair> union;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());

		map = new int[N][N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		////// input
		int ans = 0;

		while (stop < N*N) {
			visit = new boolean[N][N];
			stop=0;
			
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					union = new ArrayList<>();

					if (!visit[i][j]) {
						
						solve(i, j); // 국경선 열기
					}
				}
			}
			if(stop==N*N) break;
			ans++;
			
		} // end of while
		System.out.println(ans);
	
	}// end of main

	public static void solve(int y, int x) {
		Queue<pair> q = new LinkedList<>();
		union.add(new pair(y, x));
		q.add(new pair(y, x));
		visit[y][x] = true;
		int sum = 0;
		while (!q.isEmpty()) {
			pair p = q.poll();
			int py = p.y;
			int px = p.x;
			//System.out.println(px+ ", "+ py);
			int now = map[py][px];
			sum += now;
			for (int i = 0; i < 4; i++) {
				int ny = py + dy[i];
				int nx = px + dx[i];
				if (ny < 0 || ny > N - 1 || nx < 0 || nx > N - 1 || visit[ny][nx])
					continue;
				int gap = Math.abs(now - map[ny][nx]);
				if (gap >= L && gap <= R) {
					q.add(new pair(ny, nx));
					union.add(new pair(ny, nx));
					visit[ny][nx] = true;
				}
			}

		}

		if (union.size() != 1) {
			int val = sum / union.size();

			for (pair p : union) {
				map[p.y][p.x] = val;

			}
		}
		else stop++;
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
