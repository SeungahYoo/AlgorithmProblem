import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

//JUNGOL :: 1113 119±¸±Þ´ë
//2019-03-25
public class Main1113 {
	private static int[][] map;
	private static boolean[][] visited;
	private static int m;
	private static int n;
	static int[] dx = { 1, 0, -1, 0 };
	static int[] dy = { 0, 1, 0, -1 };
	private static int N;
	private static int M;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		M = Integer.parseInt(st.nextToken());

		N = Integer.parseInt(st.nextToken());

		map = new int[M][N];

		visited = new boolean[M][N];

		st = new StringTokenizer(br.readLine(), " ");

		m = Integer.parseInt(st.nextToken());

		n = Integer.parseInt(st.nextToken());

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}

		}

		min = Integer.MAX_VALUE;
		dfs(0,0,0,-1);
		System.out.println(min);
	}
	
	static int min;
	public static void dfs(int cnt, int y, int x, int dir) {
		visited[y][x]= true;
		
		if(y==m && x==n) {//µµÂø
			min = min > cnt? cnt : min;
			return; 
		}
		
		for(int i=0;i<4;i++) {
			int ny = y +dy[i];
			int nx = x+ dx[i];
			if(ny<0 || ny>M-1 || nx<0 || nx>N-1 || map[ny][nx]==0 || visited[ny][nx]) continue;
			

			if(dir==-1 || dir==i)	{
				
				if(cnt<min) dfs(cnt, ny,nx,i);
			}
			else	{
				
				if(cnt+1<min) dfs(cnt+1, ny,nx,i);
			}
		
			
			visited[ny][nx]=false;
		}
	}
}
