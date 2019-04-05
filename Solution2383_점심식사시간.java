import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

//SWEA :: 2383 ���� �Ļ�ð� 
//2019-04-04
public class Solution2383_���ɽĻ�ð� {
	private static int[][] map;
	private static int N, ans;
	private static ArrayList<pair> ppl;
	private static ArrayList<pair> stair;
	private static int[] set;
	private static PriorityQueue<pair2> pq;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine());
			map = new int[N][N];
			ppl = new ArrayList<>();
			stair = new ArrayList<>();
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					if (map[i][j] == 1)
						ppl.add(new pair(i, j));
					if (map[i][j] > 1)
						stair.add(new pair(i, j));
				}
			} /// input
			set = new int[ppl.size()];
			ans = Integer.MAX_VALUE;
			whichStair(0);

			System.out.println("#" + tc + " " + ans);
		} // end of tc
	}// end of main

	public static void whichStair(int len) {
		if (len == ppl.size()) { // ����� �����ŭ ��� ���� --> �ߺ�����
			// System.out.println(Arrays.toString(set));
			pq = new PriorityQueue<>();
			
			for (int i = 0; i < len; i++) {
				int py = ppl.get(i).y;
				int px = ppl.get(i).x;
				int sy = stair.get(set[i]).y;
				int sx = stair.get(set[i]).x;
				int t = Math.abs(py - sy) + Math.abs(px - sx);
				pq.add(new pair2(t, set[i], -1));
			}
			goStair();
			return;
		}

		for (int i = 0; i < stair.size(); i++) {
			set[len] = i; // �ε��� ����
			whichStair(len + 1);
		}
	} // end of whichStair

	public static void goStair() {
		/*
		 * pair2�� status -1: ��ܿ� ���� �� 0: ��ܿ� ������ ������ �����. 1:��ܿ� �ö� ����
		 */
		int min = 0;
		int[] inStair = new int[stair.size()]; // idx��° ��ܿ� ����� ����� �ִ��� Ȯ��.
		while (!pq.isEmpty()) {
			min++;

			while (!pq.isEmpty()) {
				pair2 front = pq.peek();
				if (front.time != min)
					break;
				pq.poll();
				int mystair = front.stair;
				if (front.status != 1) { // ��� ���� �Ȱ�.
					//����� ������ �� �ֳ�?
					if (inStair[mystair] < 3) { // �� �� ������
						int ntime = 0;
						if (front.status == -1) { //��ܿ� ���� �����̸� 1�� ����Ѵ�.
							ntime = front.time + 1 + map[stair.get(mystair).y][stair.get(mystair).x];
						} else if (front.status == 0) { //������ ������ ����ϰ��־����� �ٷ� ��ܿ� ����.
							ntime = front.time + map[stair.get(mystair).y][stair.get(mystair).x];
						}
						pq.add(new pair2(ntime, front.stair, 1));
						inStair[mystair]++;
					} else { // ����� ��ȭ ���¶� �� �� ���ٸ�.
						pq.add(new pair2(front.time + 1, front.stair, 0));
					}
				} else { // front.status == 1//��ܿ� �ִ� ����.
					inStair[mystair]--;
				}
			}
		}
		ans = ans > min ? min : ans;
	}

	static class pair {
		int y;
		int x;

		public pair(int y, int x) {
			super();
			this.y = y;
			this.x = x;
		}
	} // end of pair

	static class pair2 implements Comparable<pair2> {
		int time;
		int stair;
		int status;

		public pair2(int time, int stair, int status) {
			super();
			this.time = time;
			this.stair = stair;
			this.status = status;
		}

		@Override
		public int compareTo(pair2 o) {
			// TODO Auto-generated method stub
			if (this.time == o.time) {
				return o.status - this.status;
			} else {
				return this.time - o.time;
			}
		}

	}
}// end of class