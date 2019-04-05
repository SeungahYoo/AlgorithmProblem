import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//SWEA :: 6109 �߾��� 2048����
//2019-04-02

/*
 * 1. ���������� ���Ҽ� ������ ���Ѵ�.
 * 2. �ѹ��� ����.
 */

public class Solution6109_�߾���2048_���¾� {
	private static int N;
	private static int[][] map;
	private static int[][] ans;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine().trim());

		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			N = Integer.parseInt(st.nextToken());
			map = new int[N][N];
			ans = new int[N][N];
			String dir = st.nextToken();

			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			} //// input
			if(dir.equals("up")) up();
			else if(dir.equals("down")) down();
			if(dir.equals("left")) left();
			if(dir.equals("right")) right();
			
			System.out.println("#"+tc);
			for(int i=0;i<N;i++) {
				for(int j=0;j<N;j++) {
					System.out.print(ans[i][j]+" ");
				}
				System.out.println();
			}
		} // end of tc
	} // end of main

	static int[] dy = { -1, 1, 0, 0 };
	static int[] dx = { 0, 0, -1, 0 };// �����¿�

	public static void up() {
		Deque<Integer> dq = new LinkedList<>();
		for (int j = 0; j < N; j++) { // ��
			dq.clear();
			int before= -1;
			for (int i = 0; i < N; i++) { // ��
				if (map[i][j] == 0)
					continue;
				if (i>0 && (map[i][j] == before)) {
					dq.pollLast();
					dq.add(map[i][j] *= 2);
			
					map[i][j] = 0;
					before= -1;
				} else {
					before = map[i][j];
					dq.add(map[i][j]);
				}
			}
			/// ����
			int idx = 0;
			while (!dq.isEmpty()) {
				ans[idx++][j] = dq.poll();
			}
		}
	}
	
	public static void down() {
		Deque<Integer> dq = new LinkedList<>();
		for (int j = 0; j < N; j++) { // ��
			dq.clear();
			int before= -1;
			for (int i = N-1; i >=0; i--) { // ��
				if (map[i][j] == 0)
					continue;
				if (i<N-1 && (map[i][j] == before)) {
					dq.pollLast();
					dq.add(map[i][j] *= 2);
			
					map[i][j] = 0;
					before= -1;
				} else {
					before = map[i][j];
					dq.add(map[i][j]);
				}
			}
			/// ����
			int idx = N-1;
			while (!dq.isEmpty()) {
				ans[idx--][j] = dq.poll();
			}
		}
	}
	
	public static void left() {
		Deque<Integer> dq = new LinkedList<>();
		for (int i = 0; i < N; i++) { // ��
			dq.clear();
			int before= -1;
			for (int j = 0; j < N; j++) { // ��
				if (map[i][j] == 0)
					continue;
				if (j>0 && (map[i][j] == before)) {
					dq.pollLast();
					dq.add(map[i][j] *= 2);
		
					map[i][j] = 0;
					before= -1;
				} else {
					before = map[i][j];
					dq.add(map[i][j]);
				}
			}
			/// ����
			int idx = 0;
			while (!dq.isEmpty()) {
				ans[i][idx++] = dq.poll();
			}
		}
	}
	
	public static void right() {
		Deque<Integer> dq = new LinkedList<>();
		for (int i = 0; i < N; i++) { // ��
			dq.clear();
			int before= -1;
			for (int j = N-1; j >=0; j--) { // ��
				if (map[i][j] == 0)
					continue;
				if (j<N-1 && (map[i][j] == before)) {
					dq.pollLast();
					dq.add(map[i][j] *= 2);
			
					map[i][j] = 0;
					before= -1;
				} else {
					before = map[i][j];
					dq.add(map[i][j]);
				}
			}
			/// ����
			int idx = N-1;
			while (!dq.isEmpty()) {
				ans[i][idx--] = dq.poll();
			}
		}
	}
	
	
	

}// end of tc
