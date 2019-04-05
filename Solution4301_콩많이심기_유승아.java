import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//SWEA :: 4301 콩 많이 심기
//2019-04-01
public class Solution4301_콩많이심기_유승아 {
	private static int N;// 가로
	private static int M;// 세로
	private static int[][] map;
	private static boolean[][] chk;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			map = new int[M][N];
			chk = new boolean[M][N];

			//int ans = M * N;

			for (int i = 0; i < M; i++) {
				for (int j = 0; j < N; j++) {
					if (!chk[i][j]) {
						//chk[i][j] = true;
						if (i + 2 < M) {
							chk[i + 2][j] = true;
							//ans--;
						}
						if (j + 2 < N) {
							chk[i][j + 2] = true;
							//ans--;
						}
					}
				}
			}
			
			int ans=0;
			for (int i = 0; i < M; i++) {
				for (int j = 0; j < N; j++) {
					if (!chk[i][j]) {
						ans++;
					}
				}
			}

			System.out.println("#" + tc + " " + ans);
		} // end of tc

	}// end of main

}// end of class
