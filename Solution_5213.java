import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_5213 {
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(bf.readLine().trim());
		
		long[] dp = new long[1000002];

		
		for(int i=1;i<=1000000;i+=2) {
			for(int j=i;j<=1000000;j+=i) {
				dp[j]+=i;
			}
		}
		
		for(int i=2;i<=1000000;i++) {
			dp[i]+=dp[i-1];
		}
		
		for(int tc=1;tc<=T;tc++) {
			StringTokenizer st = new StringTokenizer(bf.readLine(), " ");
			int L = Integer.parseInt(st.nextToken());
			int R = Integer.parseInt(st.nextToken());
			

			
			System.out.println("#"+tc+" "+(dp[R]-dp[L-1]));
		}// end of tc
	}//end of main
	

}
