import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

//2019-08-06
public class Main11559_PuyoPuyo {
	private static char[][] map;
	private static int[] dy = { -1, 1, 0, 0 };
	private static int[] dx = { 0, 0, -1, 1 };
	private static int ans;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		map = new char[12][6];

		for (int i = 0; i < 12; i++) {
			String str = br.readLine();
			for (int j = 0; j < 6; j++) {
				map[i][j] = str.charAt(j);
			}
		} //// input

		ans = 0;
		while (true) {
			if (!findSamePuyo())
				break;
		} 
		System.out.println(ans);
	}// end of class

	public static boolean findSamePuyo() {
		Queue<pair> que = new LinkedList<>();
		List<pair> list = new ArrayList<>();
		boolean isPop = false;

		for (int i = 0; i < 12; i++) {
			for (int j = 0; j < 6; j++) {
				if (map[i][j] == '.')
					continue;

				// 같은 색 찾기
				boolean[][] visit = new boolean[12][6];
				que.clear();
				list.clear();
				que.add(new pair(i, j));
				list.add(new pair(i,j));
				visit[i][j] = true;
				
				while (!que.isEmpty()) {
					pair p = que.poll();

					for (int d = 0; d < 4; d++) {
						int ny = p.y + dy[d];
						int nx = p.x + dx[d];

						if (ny < 0 || ny > 11 || nx < 0 || nx > 5 || visit[ny][nx] || map[ny][nx] != map[p.y][p.x]) {
							continue;
						}
						que.add(new pair(ny, nx));
						visit[ny][nx] = true;
						list.add(new pair(ny, nx));
					}
				}

				if (list.size() >= 4) {
					popPuyo(list);
					isPop = true;
				}
			}
		} // end of for

		if (isPop) {
			pullPuyo();
			ans++;
			return true;
		}
		return false;
	}

	public static void popPuyo(List<pair> list) {
		for (pair p : list) {
			map[p.y][p.x] = '.';
		}
	}

	public static void pullPuyo() {
		// 밑으로 당기기
		Stack<Character> stack = new Stack<>();
		for (int c = 0; c < 6; c++) {
			stack.clear();
			for (int r = 0; r < 12; r++) {
				if (map[r][c] == '.')
					continue;
				stack.add(map[r][c]);
				map[r][c]='.';
			}
		
			int n = 11;
			while (!stack.empty()) {
				map[n--][c] = stack.pop();
			}
		}
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
