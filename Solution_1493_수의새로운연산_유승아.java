import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//SWEA :: 1493 수의 새로운 연산
//2019-03-06
public class Solution_1493_수의새로운연산_유승아 {
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(bf.readLine());

		start();
		for (int tc = 1; tc <= T; tc++) {

			StringTokenizer st = new StringTokenizer(bf.readLine(), " ");
			long x = Long.parseLong(st.nextToken());
			long y = Long.parseLong(st.nextToken());

			long ans = cal(x, y);
			System.out.println("#" + tc + " " + ans);
		} // end of tc

	}// end of main

	public static long cal(long x, long y) {
		pair p1 = r_sharp(x);
		pair p2 = r_sharp(y);

		long nx = p1.x + p2.x;
		long ny = p1.y + p2.y;

		long ret = sharp(nx, ny);

		return ret;
	}

	static int[] Yfirst = new int[300];

	public static void start() {

		int ygap = 1;

		Yfirst[1] = 1;

		for (int i = 2; i < Yfirst.length; i++) {
			Yfirst[i] = Yfirst[i - 1] + (ygap++);

		}

	}

	public static long sharp(long x, long y) {
		long cha = x - 1;
		int yy = (int) (y + cha); // 시작점의 y좌표

		int a1 = Yfirst[yy];
		long ret = a1 + (x - 1);

		return ret;
	}

	public static pair r_sharp(long p) {
		int a1 = 0, idx = -1;
		for (int i = 0; i < Yfirst.length; i++) {
			if (Yfirst[i] > p) {
				idx = i - 1;
				a1 = Yfirst[i - 1];
				break;
			}
		}

		// 시작점 좌표는 (1,idx)
		long cha = p - a1;
		return new pair(1 + cha, idx - cha);
	}

	static class pair {
		long x;
		long y;

		public pair(long x, long y) {
			super();
			this.x = x;
			this.y = y;
		}

	}
}
