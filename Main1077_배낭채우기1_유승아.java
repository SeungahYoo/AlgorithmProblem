import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//JUNGOL :: 1077 배낭채우기
//2019-03-25

public class Main1077_배낭채우기1_유승아 {
	static class val{
		int w;
		int v;
		public val(int w, int v) {
			super();
			this.w = w;
			this.v = v;
		}
		
	}
	private static int W;
	private static int N;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		N = Integer.parseInt(st.nextToken()); // 보석의 가지 수
		W = Integer.parseInt(st.nextToken()); // 배낭의 용량
		val[] arr = new val[N];
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int w = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			arr[i] = new val(w,v);
		}
		///////input
		
		
		
		///////dp
		int[] values = new int[W+1];
		
		//i는 보석 종류
		for(int i=0;i<N;i++) {
			//j는 보석 무게
			//내 무게보다 작은 배낭은 이전에 구한 값을 참고한다.
			for(int j=arr[i].w;j<=W;j++) { 
				values[j] = Math.max(values[j],values[j-arr[i].w]+arr[i].v);
			}
		}
		
		System.out.println(values[W]);
	}//end of main

}
