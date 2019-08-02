import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

//2019-08-01
public class Main17140_이차원배열과연산 {
	private static int r;
	private static int c;
	private static int k;
	private static int[][] map;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());

		map = new int[3][3];

		for (int i = 0; i < 3; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 3; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		} /// input

		int time = 0;
		while (true) {
			if(map.length>r-1 && map[0].length>c-1 && map[r-1][c-1]==k) break;
			int row = map.length;
			int column = map[0].length;
			time++;
			//System.out.println(time);
			if(time>100) {
				time = -1;
				break;
			}
			if (row >= column) {
				rCalc();
			} else {
				cCalc();
			}
		}
		
		System.out.println(time);
	}

	public static void rCalc() {
		int[][] check = new int[map.length][101];

		// 모든 행에 대해서 정렬 수행
		int nextC = 0;
		for (int i = 0; i < map.length; i++) {
			int tmpC = 0;
			for (int j = 0; j < map[i].length; j++) {
				if (map[i][j] == 0)
					continue;
				check[i][map[i][j]]++;
				if (check[i][map[i][j]] == 1) { // 새로 더해지는 경우만.
					tmpC++;
				}
			}
			nextC = nextC < tmpC ? tmpC : nextC;
		}
		nextC = nextC*2 > 99 ? 99 : nextC*2;
		
		map = new int[map.length][nextC];

		List<value> list = new ArrayList<>();
		for (int i = 0; i < map.length; i++) {
			list.clear();
			for (int j = 1; j < 101; j++) {
				if (check[i][j] == 0)
					continue;
				list.add(new value(j, check[i][j]));
			}
			Collections.sort(list);
	
			int start;
			if(list.size()>50) {
				start = list.size()-50;
			} else {
				start = 0;
			}
			
			int x=0;
			for(int idx = start ; idx<list.size(); idx++) {
				value v = list.get(idx);
				map[i][x++] = v.num;
				map[i][x++] = v.cnt;
				if(x>99) break;
			}

		}
	}

	public static void cCalc() {
		int[][] check = new int[101][map[0].length];

		// 모든 열에 대해서 정렬 수행
		int nextR = 0;
		for (int j = 0; j < map[0].length; j++) {
			int tmpR = 0;
			for (int i = 0; i < map.length; i++) {
				if (map[i][j] == 0)
					continue;
				check[map[i][j]][j]++;
				if (check[map[i][j]][j] == 1) { // 새로 더해지는 경우만.
					tmpR++;
				}
			}
			nextR = nextR < tmpR ? tmpR : nextR;
		}

		nextR = nextR*2 > 99 ? 99 : nextR*2;
		
		map = new int[nextR][map[0].length];

		List<value> list = new ArrayList<>();
		for (int j = 0; j < map[0].length; j++) {
			list.clear();
			for (int i = 1; i < 101; i++) {
				if (check[i][j] == 0)
					continue;
				list.add(new value(i, check[i][j]));
			}
			Collections.sort(list);

			int start;
			if(list.size()>50) {
				start = list.size()-50;
			} else {
				start = 0;
			}
			
			int x = 0;
			for(int idx = start ; idx<list.size(); idx++) {
				value v = list.get(idx);
				map[x++][j] = v.num;
				map[x++][j] = v.cnt;
				if(x>99) break;
			}

		}
	}

	static class value implements Comparable<value> {
		int num;
		int cnt;

		public value(int num, int cnt) {
			super();
			this.num = num;
			this.cnt = cnt;
		}

		@Override
		public int compareTo(value o) {
			if (this.cnt == o.cnt)
				return this.num - o.num; // 내림차순 
			else
				return this.cnt - o.cnt; // 내림차순
		}

	}
}
