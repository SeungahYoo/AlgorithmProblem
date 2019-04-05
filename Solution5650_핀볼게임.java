import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//SWEA :: 5650. ÇÉº¼°ÔÀÓ
//https://www.swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AWXRF8s6ezEDFAUo
//2019-04-04

//-1: ºí·¢È¦ //0:ºó°ø°£ //1~5:ºí·Ï //6~10¿úÈ¦ 
public class Solution5650_ÇÉº¼°ÔÀÓ {
	private static int[][] map;
	private static int[] dy = { -1, 1, 0, 0 };
	private static int[] dx = { 0, 0, -1, 1 }; // »óÇÏÁÂ¿ì
	private static Queue<pair> q;
	private static ArrayList<pair>[] hole;
	private static int N,ans;
	private static int startY;
	private static int startX;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine().trim());
		StringBuilder sb = new StringBuilder();
		for (int tc = 1; tc <= T; tc++) {
			sb.append('#').append(tc).append(" ");
			N = Integer.parseInt(br.readLine().trim());
			map = new int[N][N];
			q = new LinkedList<>();
			hole = new ArrayList[11];
			for (int i = 6; i < 11; i++) {
				hole[i] = new ArrayList<pair>();
			}
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					if (map[i][j] == 0) {
						q.add(new pair(i, j));
					}
					if (6 <= map[i][j] && map[i][j] <= 10) {
						hole[map[i][j]].add(new pair(i, j)); // ¿úÈ¦ ÀúÀå
					}
				} //// input
			}
			ans = -1;
			startPoint();
		
			sb.append(ans).append('\n');
		} // end of tc
		System.out.print(sb);
	}// end of main

	public static void startPoint() {
		while (!q.isEmpty()) {
			pair p = q.poll();
			startY = p.y;
			startX = p.x;
			for (int d = 0; d < 4; d++) {
				pinBall(startY, startX, d, 0);
			}
		}
	} // end of startPoint


	public static void pinBall(int y, int x, int dir, int score) {
		int ny, nx;
		while(true) {
			y+=dy[dir];
			x+=dx[dir];
			//º® 
			if(y<0 || y>N-1 || x<0 || x>N-1) { 
				dir = reverseDir(dir);
				score++;
				continue;
			}
			//ºí·Ï 
			if(1<=map[y][x] && map[y][x]<=5) {
				dir = dirByBlock(map[y][x], dir);
				score++;
				continue;
			}
			//¿úÈ¦ 
			if(6<=map[y][x]&&map[y][x]<=10) {
				pair p = wormhole(y, x, map[y][x]);
				y=p.y;
				x=p.x;
				continue;
			}
			//ºí·¢È¦ÀÌ°Å³ª, ½ÃÀÛÁ¡ 
			if(map[y][x]==-1 || (y==startY&&x==startX)) {
				break;
			}
		}
		ans = ans <score? score:ans;
		return;
	}// end of dfs
	public static int reverseDir(int d) {
		if(d==0) return 1;
		else if(d==1) return 0;
		else if(d==2) return 3;
		else return 2;
	}
	
	public static pair wormhole(int y, int x, int type) {
			pair p;
			int yy = hole[type].get(0).y;
			int xx = hole[type].get(0).x;
			
			if(yy==y && xx==x) p = new pair(hole[type].get(1).y,hole[type].get(1).x); 
			else p = new pair(yy,xx);
			
			return p;
	}
	
	public static int dirByBlock(int type, int dir) {
		switch (type) {
		case 1:
			if(dir==0 || dir==3) return reverseDir(dir);
			if(dir==1) return 3;
			if(dir==2) return 0;
			break;
		case 2:
			if(dir==1 || dir==3) return reverseDir(dir);
			if(dir==0) return 3;
			if(dir==2) return 1;
		case 3:
			if(dir==1 || dir==2) return reverseDir(dir);
			if(dir==0) return 2;
			if(dir==3) return 1;
		case 4:
			if(dir==0 || dir==2) return reverseDir(dir);
			if(dir==1) return 2;
			if(dir==3) return 0;
		case 5:
			return reverseDir(dir);
			
		default: break;
		}
		return dir;
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
}// end of class
