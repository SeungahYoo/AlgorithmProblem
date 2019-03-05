import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

//파핑파핑 지뢰찾기
public class Solution_1868_파핑파핑지뢰찾기_유승아 {
	static char[][] map;
	static boolean[][] visited;
	static int N, click;
	static ArrayList<pair> al;

	static int[] dy = { -1, 1, 0, 0, -1, -1, 1, 1 };
	static int[] dx = { 0, 0, -1, 1, -1, 1, -1, 1 };

	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(bf.readLine());

		for (int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(bf.readLine());
			map = new char[N][N];
			visited = new boolean[N][N];
			al = new ArrayList<>();
			click = 0;
			int ans = 0;
			for (int i = 0; i < N; i++) {
				String str = bf.readLine();
				for (int j = 0; j < N; j++) {
					map[i][j] = str.charAt(j);
					if (map[i][j] == '.')
						click++; //숫자의 개수
				}
			} // intput

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {

					if (map[i][j] == '.') {
							find(i, j);

					}
				}
			}
			
			for(pair p : al) {
				int yy = p.y;
				int xx = p.x;
				
				if(!visited[yy][xx]) {
					visit(yy,xx);
					visited[yy][xx]=true;
					click--;
					ans++;
					//System.out.println();
				}
			}
			
			
			int rst = click+ans;
			System.out.println("#"+tc+" "+rst);
		} // end of tc
	}// end of main

	static void visit(int y, int x) {
		visited[y][x]=true;
		//click--;
		//System.out.println(y + "," + x);
		for (int k = 0; k < 8; k++) {
			int ny = y + dy[k];
			int nx = x + dx[k];

			if (ny < 0 || ny > N - 1 || nx < 0 || nx > N - 1)
				continue;
			if (!visited[ny][nx]) {
				visited[ny][nx] = true;
				click--;
				//System.out.println(ny + "," + nx);
				if (map[ny][nx] == '0')
					visit(ny, nx);
			}
		}
	}

	static void find(int y, int x) {
		int bomb = 0;
	
		for (int k = 0; k < 8; k++) {
			int ny = y + dy[k];
			int nx = x + dx[k];

			if (ny < 0 || ny > N - 1 || nx < 0 || nx > N - 1)
				continue;
			if (map[ny][nx] == '*')// 지뢰면
				bomb++;
		}

		map[y][x] = (char) (bomb + '0');
		
		if(map[y][x] == '0') 
			al.add(new pair(y,x));
		

		if (bomb == 0) {
			zero(y, x);
		}

	}

	static void zero(int y, int x) {
		Queue<pair> q = new LinkedList<>();
		for (int k = 0; k < 8; k++) {
			int ny = y + dy[k];
			int nx = x + dx[k];

			if (ny < 0 || ny > N - 1 || nx < 0 || nx > N - 1 || map[ny][nx] =='*')
				continue;
			if (map[ny][nx] == '.')
				q.add(new pair(ny, nx));
		}

		while (!q.isEmpty()) {
			int yy = q.peek().y;
			int xx = q.peek().x;
			q.poll();

			find(yy, xx);
		}

	}

	public static class pair {
		int y;
		int x;

		public pair(int y, int x) {
			super();
			this.y = y;
			this.x = x;
		}

	}


}
