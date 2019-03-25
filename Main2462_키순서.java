
//JUNGOL :: 2462 키순서
//2019-03-25

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main2462_키순서 {
	static int[][] map;
	static int[][] chk;
	static int N;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken()); // 학생 수
		int M = Integer.parseInt(st.nextToken()); // 비교 횟수

		map = new int[N + 1][N + 1];

		boolean[] visit = new boolean[N + 1];
		chk = new int[N + 1][2]; // 0은 out, 1은 in

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			map[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())] = 1;

		}
		////////////////// input

		int ans = 0;
		for (int i = 1; i <= N; i++) {
			boolean rst = bfs(i);
			if(rst) ans++;
		}

		System.out.println(ans);
	} // end of main

	public static boolean bfs(int x) {
		Queue<Integer> q = new LinkedList<>();
		boolean[] visit = new boolean[N + 1];
		visit[x] = true;
		for (int i = 1; i <= N; i++) {
			if (map[x][i] == 1) { // x->i 연결
				visit[i] = true;
				q.add(i);
			}
		}

		while (!q.isEmpty()) {
			int pop = q.poll();
			for (int i = 1; i < map[pop].length; i++) {
				if (map[pop][i] == 1) { // pop->i연결
					if (!visit[i]) {
						visit[i] = true;
						q.add(i);
					}
				}
			}
		}

		for (int i = 1; i <= N; i++) {
			if (map[i][x] == 1) { // x<-i 연결
				if (!visit[i]) {
					visit[i] = true;
					q.add(i);
				}
			}
		}

		while (!q.isEmpty()) {
			int pop = q.poll();
			for (int i = 1; i < map[pop].length; i++) {
				if (map[i][pop] == 1) { // pop<-i연결
					if (!visit[i]) {
						visit[i] = true;
						q.add(i);
					}
				}
			}
		}
		
		
		for(int i=1;i<=N;i++) {
			if(!visit[i]) 
				return false;
		}
		
		return true;
	} // end of bfs

}
