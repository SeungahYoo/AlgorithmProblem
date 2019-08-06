//2019-08-06

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main17136_색종이붙이기 {
	static int[][] map;
	static boolean[][] visit;
	static int ans, remain;
	static int[] type;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		map = new int[10][10];
		visit = new boolean[10][10];
		type = new int[] { 0, 5, 5, 5, 5, 5 };

		for (int i = 0; i < 10; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < 10; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j]==1) remain++;
			}
		} //// input
		
		if(remain == 0) {
			System.out.println("0");
			return;
		}
		
		ans = Integer.MAX_VALUE;
		
		dfs(0);
		
		System.out.println(ans==Integer.MAX_VALUE? -1 :ans);
	}// end of main

	public static void dfs(int paper) {
		if(remain == 0 ) { //남은 공간이 없으면 == 색종이를 다 붙혔다면 
			ans = ans > paper ? paper : ans; 
			return;
		}
		
		int y = -1, x = -1; //initialize
		boolean isSpace=false;
		loop : for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				if (map[i][j] == 1) {
					y=i;
					x=j;
					isSpace=true;
					break loop;
				}
			}
		}
		
		if(!isSpace) return; //색종이를 붙힐 공간이 없다면 return
		
		for (int i = 1; i <= 5; i++) {
			if (type[i] == 0)
				continue;
			if(isValid(y, x, i)) {
				setVisited(y, x, i);
				dfs(paper+1);
				resetVisited(y, x, i);
			}
		}
		return;
	}

	public static boolean isValid(int y, int x, int size) {
		if(y+size>10 || x+size>10) return false;
		for (int i = y; i < y + size; i++) {
			for (int j = x; j < x + size; j++) {
				if (map[i][j] == 0) {
					return false;
				}
			}
		}
		return true;
	}

	public static void setVisited(int y, int x, int size) {
		for (int i = y; i < y + size; i++) {
			for (int j = x; j < x + size; j++) {
				map[i][j] = 0;
				remain--;
			}
		}
		type[size]--;
	}
	
	public static void resetVisited(int y, int x, int size) {
		for (int i = y; i < y + size; i++) {
			for (int j = x; j < x + size; j++) {
				map[i][j] = 1;
				remain++;
			}
		}
		type[size]++;
	}
}// end of class
