import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

//SWEA 3234. 준환이의 양팔저울
//2019-04-04

public class Solution3234_준환이의양팔저울_유승아2 {
	private static long[] fac;
	private static int[] weight, set;
	private static boolean[] visit;
	private static int ans;
	private static int N;
	private static boolean[] chk;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		fac = new long[10];
		Arrays.fill(fac, -1);
		for (int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine());
			weight = new int[N];
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for (int i = 0; i < N; i++) {
				weight[i] = Integer.parseInt(st.nextToken());
			} //// input
			
			visit = new boolean[N];
			set = new int[N];
			perm(0);
			System.out.println("#" + tc + " "+ans);
		}// end of tc
	} // end of main
	
	
	public static void perm(int len) {
		if(len == N) {
			System.out.println(Arrays.toString(set));
			subset(0,0);
			return;
		}
		
		for(int i=0;i<N;i++) {
			if(visit[i]) continue;
			set[len] = weight[i];
			visit[i] = true;
			perm(len+1);
			visit[i] = false;
		}
	} // end of perm
	
	public static void subset(int k, int len) { //인덱스 고르기
		

		int left= 0; //left < right;
		int right = 0;
	
		for(int i=0;i<chk.length;i++) {
			if(chk[i]) { //선택된것은 왼쪽
				System.out.print(i+",");
			} else {
				right+=weight[i];
			}
		}

		if(left>=right) {
			ans++;
		}
		
		if(len==weight.length) return;
		
		for(int i=k;i<set.length;i++) {
			chk[i] = true;
			subset(i+1, len+1);
			chk[i] = false;
		}
	}
	

}
