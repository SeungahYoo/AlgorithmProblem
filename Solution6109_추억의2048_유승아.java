import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//SWEA :: 6109 추억의 2048게임
//2019-04-02

/*
 * 1. 벽에서부터 더할수 있으면 더한다.
 * 2. 한번에 당긴다.
 */

public class Solution6109_추억의2048_유승아 {
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
	static int[] dx = { 0, 0, -1, 0 };// 상하좌우

	public static void up() {
		Deque<Integer> dq = new LinkedList<>();
		for (int j = 0; j < N; j++) { // 열
			dq.clear();
			int before= -1;
			for (int i = 0; i < N; i++) { // 행
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
			/// 당기기
			int idx = 0;
			while (!dq.isEmpty()) {
				ans[idx++][j] = dq.poll();
			}
		}
	}
	
	public static void down() {
		Deque<Integer> dq = new LinkedList<>();
		for (int j = 0; j < N; j++) { // 열
			dq.clear();
			int before= -1;
			for (int i = N-1; i >=0; i--) { // 행
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
			/// 당기기
			int idx = N-1;
			while (!dq.isEmpty()) {
				ans[idx--][j] = dq.poll();
			}
		}
	}
	
	public static void left() {
		Deque<Integer> dq = new LinkedList<>();
		for (int i = 0; i < N; i++) { // 행
			dq.clear();
			int before= -1;
			for (int j = 0; j < N; j++) { // 열
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
			/// 당기기
			int idx = 0;
			while (!dq.isEmpty()) {
				ans[i][idx++] = dq.poll();
			}
		}
	}
	
	public static void right() {
		Deque<Integer> dq = new LinkedList<>();
		for (int i = 0; i < N; i++) { // 행
			dq.clear();
			int before= -1;
			for (int j = N-1; j >=0; j--) { // 열
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
			/// 당기기
			int idx = N-1;
			while (!dq.isEmpty()) {
				ans[i][idx--] = dq.poll();
			}
		}
	}
	
	
	

}// end of tc
