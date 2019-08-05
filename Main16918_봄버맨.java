import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//2019-08-05
public class Main16918_봄버맨 {
	private static int R, C, N, b;
	private static int[][] map;
	private static int[] dy = {-1,1,0,0};
	private static int[] dx = {0,0,-1,1};

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		
		map = new int[R][C];
		b=1;
		for(int i=0;i<R;i++) {
			String str = br.readLine();
			for(int j=0;j<C;j++) {
				if(str.charAt(j)=='O') {
					map[i][j]=b;
				}
				else {
					map[i][j]=0;
				}
			}
		} ///input
		
		int time=1;
		b*=-1;
		while(true) {
			if(time == N) break;
			//2차 설치 : 빈곳 모두 설치 
			secondBomb();
			time++;
			if(time == N) break;
			explosion();
			time++;
			if(time == N) break;
		}
		
		for(int i=0;i<R;i++) {
			for(int j=0;j<C;j++) {
				if(map[i][j]==0) {
					System.out.print(".");
				}
				else {
					System.out.print("O");
				}
			}
			System.out.println();
		} ///input
	}  //end of main
	
	//2차 폭탄 : 빈곳 모두 
	public static void secondBomb() {
		for(int i=0;i<R;i++) {
			for(int j=0;j<C;j++) {
				if(map[i][j]==0) { //빈칸이면 폭탄 설치 
					map[i][j]=b;
				}
			}
		}
		b*=-1;
	}
	
	public static void explosion() {
		Queue<pair> q = new LinkedList<>();
		for(int i=0;i<R;i++) {
			for(int j=0;j<C;j++) {
				if(map[i][j]==b) { //폭탄 터트리긔 
					q.add(new pair(i,j));
				
				}
			}
		}
		
		while(!q.isEmpty()) {
			pair p = q.poll();
			map[p.y][p.x]=0;
			for(int k=0;k<4;k++) {
				int ny = p.y+dy[k];
				int nx = p.x+dx[k];
				
				if(ny<0 || ny>R-1 || nx<0 || nx>C-1) continue;
				map[ny][nx]=0;
			}
		}
	}
	
	static class pair{
		int y;
		int x;
		public pair(int y, int x) {
			super();
			this.y = y;
			this.x = x;
		}
	}
}
