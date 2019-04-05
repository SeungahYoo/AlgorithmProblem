import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//JUNGOL :: 1230 선물의 집
//2019-04-05

public class Main1230_선물의집_유승아 {
	private static int N;
	private static int[][] map;
	private static boolean[][] visit;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine().trim());
		map = new int[N][N];
		visit = new boolean[N][N];

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		dfs(0, 0,0);
		System.out.println(ans);
	}

	static int[] dy = { -1, 1, 0, 0 };
	static int[] dx = { 0, 0, -1, 1 };
	private static int ans;

	public static void dfs(int y, int x, int gift) {
		visit[y][x] = true;
		if(map[y][x]==2 ) gift++;
 		if(y==N-1 && x==N-1) { 
			ans = ans < gift ? gift : ans;
			return;
		}
		for (int i = 0; i < 4; i++) {
			int ny = y + dy[i];
			int nx = x + dx[i];
			
			if(nx<0 || nx>N-1 || ny<0 || ny>N-1 || visit[ny][nx] || map[ny][nx]==1) continue;
			dfs(ny,nx,gift);
		
			visit[ny][nx] = false;
		}
	}
}
