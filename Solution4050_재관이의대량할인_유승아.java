import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

//SWEA :: 4050 재관이의 대량할인
//2019-04-01
public class Solution4050_재관이의대량할인_유승아 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int tc= 1;tc<=T;tc++) {
			int N = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int[] piece = new int[N];
			for(int i=0;i<N;i++) {
				piece[i] = Integer.parseInt(st.nextToken());
			}/////input
			
			Arrays.sort(piece);
			
			int cnt = 0;
			int ans=0;
			for(int i=piece.length-1;i>=0;i--) {
				cnt++;
				if(cnt==3) {
					cnt=0;
					continue;
				}
				ans+=piece[i];
			}
			
			System.out.println("#"+tc+" "+ans);
		}//end of tc
	}// end of main
}
