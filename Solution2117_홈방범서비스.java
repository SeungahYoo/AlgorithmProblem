//2019-08-07

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution2117_홈방범서비스 {
	private static int N;
	private static int M, total;
	private static int[][] map;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken()); // 도시 크기
			M = Integer.parseInt(st.nextToken()); // 지불 비용
			map = new int[N][N];
			total = 0;
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					if(map[i][j] == 1) {
						total++;
					}
				}
			} /// input
			ans = -1;

			for (int i = 1; i < 2*N; i++) { //마름모 크기 결정 
				if(solve(i)) break;
			}
			System.out.println("#" + tc + " " + ans);
		} // end of tc
	}// end of main

	static int ans;

	public static boolean solve(int k) {
		for (int i = -k; i < N; i++) {
			for (int j = -N+1; j < N; j++) {
				int home = safeZone(k, i, j);
				
				if (home > 0) {
					int profit = home * M - (k * k + (k - 1) * (k - 1));
					if (profit >= 0) {
						ans = ans < home ? home : ans;
						if(home == total) return true;
					}
				}
			}
		}
		return false;
	}

	public static int safeZone(int k, int y, int x) {
		int s = k * 2 - 1;
		int home = 0;
		int start = s / 2;
		int end = s / 2;
		for (int i = 0; i < s; i++) {
			for (int j = 0; j < s; j++) {
				if (j < start || j > end || (y + i) < 0 || (x + j) < 0 || (y + i) > N - 1 || (x + j) > N - 1) {
					continue;
				}

				if (map[y + i][x + j] == 1) {
					home++;
				}
			}
			if (i < s / 2) {
				start--;
				end++;
			} else {
				start++;
				end--;
			}
		}
		return home;
	}
	
}// end of class
