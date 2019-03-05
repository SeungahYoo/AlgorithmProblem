import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class pair {
	int y;
	int x;

	public pair(int y, int x) {
		this.y = y;
		this.x = x;
	}
}

public class Solution1247 {
	static pair home;
	static pair company;
	static pair[] cus;
	static int ans = Integer.MAX_VALUE;

	public static int getDistance(pair p1, pair p2) {
		return Math.abs(p1.x - p2.x) + Math.abs(p1.y - p2.y);
	}

	public static void swap(int[] set, int i, int index) {
		int temp = set[i];
		set[i] = set[index];
		set[index] = temp;
	}
	
	
	static int solve(int[] set) {
		int sum=0;
		sum += getDistance(company, cus[set[0]]);
		for(int i=0;i<set.length-1;i++) {
			int idx = set[i];
			int next = set[i+1];
			sum+= getDistance(cus[idx], cus[next]);
		}
		sum+=getDistance(cus[set[set.length-1]], home);
		
		return sum;
	}
	

	
	public static void perm(int[] set, int size, int n, int k) {
		if (size == k) { //종료조건
			int s = solve(set);

			ans = ans > s? s: ans;
			return;
		}

		for (int i = size; i < n; i++) {
			swap(set, i, size);
			perm(set, size + 1, n, k);
			swap(set, i, size);
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int TC = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= TC; tc++) {
			int N = Integer.parseInt(br.readLine()); // 고객 수
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int y = Integer.parseInt(st.nextToken());
			int x = Integer.parseInt(st.nextToken());
			ans = Integer.MAX_VALUE;
			int[] set = new int[N];
			company = new pair(y, x);

			y = Integer.parseInt(st.nextToken());
			x = Integer.parseInt(st.nextToken());
			home = new pair(y, x);

			cus = new pair[N];
			for (int i = 0; i < N; i++) {
				y = Integer.parseInt(st.nextToken());
				x = Integer.parseInt(st.nextToken());
				cus[i] = new pair(y, x);
			}

			for (int i = 0; i < N; i++) {
				set[i] = i;
			}

			perm(set, 0, N, N);
			
			System.out.println("#"+tc + " "+ans);

		}
	}
}
