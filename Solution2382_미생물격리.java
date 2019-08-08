
//2019-08-08

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Solution2382_미생물격리 {
	private static int N, M, K;
	private static int[][] map;
	private static List<microbe> list;
	private static int[] dy = { 0, -1, 1, 0, 0 };
	private static int[] dx = { 0, 0, 0, -1, 1 };

	// 1:상 / 2:하 / 3:왼 / 4:오
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st;
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken()); // 맵 크기
			M = Integer.parseInt(st.nextToken()); // M시간 후 남아있는 미생물의 수 출력
			K = Integer.parseInt(st.nextToken()); // 미생물 군집 개수

			map = new int[N][N];
			list = new ArrayList<>();

			for (int i = 0; i < K; i++) {
				st = new StringTokenizer(br.readLine());
				microbe m = new microbe(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()),
						Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
				list.add(m);
			}

			Collections.sort(list);
			for (int t = 0; t < M; t++) {
				
				// 이동
				for (microbe m : list) {
					m.y += dy[m.dir];
					m.x += dx[m.dir];

					if (m.y == 0 || m.x == 0 || m.y == N - 1 || m.x == N - 1) {
						m.cnt /= 2;
						if (m.dir == 1)
							m.dir = 2;
						else if (m.dir == 2)
							m.dir = 1;
						else if (m.dir == 3)
							m.dir = 4;
						else if (m.dir == 4)
							m.dir = 3;
					}
				}

				Collections.sort(list);
				//같은 위치 검사 
				microbe before = null;
				List<microbe> beDeleted = new ArrayList<>();
				for (microbe now : list) {
					if (before == null) {
						before = now;
						continue;
					}
					if (now.y == before.y && now.x == before.x) { // 같은 위치에 있으면
						before.cnt += now.cnt;
						beDeleted.add(now);
						//System.out.println(now.toString());
					} else { //위치가 바뀌면 
						before = now;
					}
				}
				
				for(microbe deleted : beDeleted) {
					//System.out.println("delete // "+deleted.toString());
					list.remove(deleted);
				}
			}
			
			int ans = 0;
			for(microbe m : list) {
				ans += m.cnt;
			}

			System.out.println("#" + tc + " "+ans);
		} // end of tc
	}// end of main

	static class microbe implements Comparable<microbe> {
		int y;
		int x;
		int dir;
		int cnt;

		public microbe(int y, int x, int cnt, int dir) {
			this.y = y;
			this.x = x;
			this.dir = dir;
			this.cnt = cnt;
		}

		@Override
		public int compareTo(microbe o) {
			if (o.y != this.y) {
				return this.y - o.y;
			} else if (o.y == this.y && this.x != o.x) {
				return this.x - o.x;
			}
			// 같은 위치라면 미생물 개수 내림차순
			return o.cnt - this.cnt;
		}

		@Override
		public String toString() {
			return "microbe [y=" + y + ", x=" + x + ", dir=" + dir + ", cnt=" + cnt + "]";
		}
		

	}
}
