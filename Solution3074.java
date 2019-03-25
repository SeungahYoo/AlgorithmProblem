import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

//SWEA 3074 입국심사
public class Solution3074 {
	static int N, M;
	static int[] checkpoint;
	static int[] tmpchk;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			N = Integer.parseInt(st.nextToken()); // 심사대 개수
			M = Integer.parseInt(st.nextToken()); // 사람 수

			checkpoint = new int[N];
			for (int i = 0; i < N; i++)
				checkpoint[i] = Integer.parseInt(br.readLine());
			Arrays.sort(checkpoint);
			////////////////// input

			int ans = solve();
			System.out.println("#" + tc + " " + ans);

		} // end of tc
	}// end of main

	public static void mapcopy() {
		tmpchk = new int[N];
		for (int i = 0; i < N; i++) {
			tmpchk[i] = checkpoint[i];
		}
	} // mapcopy method

	public static int solve() {
		mapcopy();

		int time = 0;
//		boolean done = false;
		int remain = M; //검사가 완료되지 않은 사람
		int line = M - N; //줄에서 대기하는 사람

		// M -= N;
		while (true) {

			time++;
//			done = true;
			int wait = -1;
			int waitMin = Integer.MAX_VALUE;

			for (int i = 0; i < N; i++) {
				boolean working = false;
				if (tmpchk[i] > 0) {
					working = true;
					tmpchk[i]--;
					wait = tmpchk[i] + checkpoint[i];
					waitMin = wait < waitMin ? wait : waitMin;
				}
//				if (tmpchk[i] != 0) { // 검사대에 시간이 남아있으면
//					done = false;
//				}

				if (tmpchk[i] == 0) {
					if(working) remain--; // 한명 완료
					if (line > 0) { //대기자가 남아있으면.
//						done = false; // 사람이 남아있으면
						// 새로운 사람이 검색대로 들어간다.
						if (waitMin >= checkpoint[i]) {
							tmpchk[i] = checkpoint[i];
							line--; // 대기자가 줄어든다.
						}
					}
				}
			}
			if (remain==0 && line==0) //모든 사람이 완료되면
				break;
		}

		return time;
	} // end of solve
}
