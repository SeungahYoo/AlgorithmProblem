import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

//SWEA 3074 �Ա��ɻ�
public class Solution3074 {
	static int N, M;
	static int[] checkpoint;
	static int[] tmpchk;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			N = Integer.parseInt(st.nextToken()); // �ɻ�� ����
			M = Integer.parseInt(st.nextToken()); // ��� ��

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
		int remain = M; //�˻簡 �Ϸ���� ���� ���
		int line = M - N; //�ٿ��� ����ϴ� ���

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
//				if (tmpchk[i] != 0) { // �˻�뿡 �ð��� ����������
//					done = false;
//				}

				if (tmpchk[i] == 0) {
					if(working) remain--; // �Ѹ� �Ϸ�
					if (line > 0) { //����ڰ� ����������.
//						done = false; // ����� ����������
						// ���ο� ����� �˻���� ����.
						if (waitMin >= checkpoint[i]) {
							tmpchk[i] = checkpoint[i];
							line--; // ����ڰ� �پ���.
						}
					}
				}
			}
			if (remain==0 && line==0) //��� ����� �Ϸ�Ǹ�
				break;
		}

		return time;
	} // end of solve
}
