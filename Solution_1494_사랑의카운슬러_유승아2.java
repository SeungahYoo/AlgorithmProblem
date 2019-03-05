import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_1494_사랑의카운슬러_유승아2 {
	static int N,sumX,sumY;
	static long min;
	static pair[] bug ;
	static boolean[] visit ;
	static int[] set;
	public static class pair{
		int y;
		int x;
		public pair(int y, int x) {
			super();
			this.y = y;
			this.x = x;
		}
		
	}
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(bf.readLine());

		for (int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(bf.readLine());
			bug = new pair[N]; //지렁이 좌표
			set = new int[N/2]; 
			sumX=0;
			sumY=0;
			visit = new boolean[N];
			min = Long.MAX_VALUE;
			for(int i=0;i<N;i++) {
				StringTokenizer st = new StringTokenizer(bf.readLine(), " ");
			
				int y = Integer.parseInt(st.nextToken());
				int x = Integer.parseInt(st.nextToken());
				sumX+=x;
				sumY+=y;
				bug[i] = new pair(y,x);
				

			} // input

			comb(0,0);
			System.out.println("#"+tc+" "+min);
		}// end of tc
		
	} //end of main
	
	public static long vector(long x , long y) {
		return x*x+y*y;
	}
	

	
	public static void comb(int len, int k) {
		if(len == N/2) {
			//System.out.println(Arrays.toString(set));
			long c = cal();
			min = min>c? c:min;
			return;
		}
		
		for(int i=k;i<N;i++) {
			set[len]=i;
			comb(len+1,i+1);
		}
	}
	public static long cal() {
		long yy=0;
		long xx=0;
		
		//선택된 것은 음수
		for(int idx : set) {
			yy+=bug[idx].y;
			xx+=bug[idx].x;
		}
		
		long unSelectY = sumY-yy;
		long unSelectX= sumX-xx;
		
		return vector(yy-unSelectY,xx-unSelectX);
	}

}