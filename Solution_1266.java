import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_1266 {
	static boolean[] prime = new boolean[19];
	static double[] comb = new double[19];
	static long[] fac = new long[19];
	//18������ �Ҽ� ã��
	
	static void factorial(int n) {
		
		for(int i = n;i>1;i--) {
			if(fac[i] != 0) {
				
			}
		}
	}
	
	static double calComb(int r) {
		int ans = 0;
		
		return ans;
	}
	
	static void primeNum() {
		prime[0] = true;
		prime[1]=true;
		for(int i=2;i<=(int)Math.sqrt(18);i++) {
			if(prime[i]) {
				continue;
			}
			for(int j=i+i;j<prime.length;j+=i) {
				prime[j]=true;
			}
		}
		System.out.println();
	}
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		primeNum();//true�� �Ҽ��� �ƴ� ��
		for(int i=0;i<prime.length;i++) {
			if(prime[i]) { //�Ҽ��� �ƴ� ��
				
			}
		}
		
		int TC = Integer.parseInt(br.readLine());
		
		
		for (int tc = 1; tc <= TC; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken()); //Ȯ��
			
			
			System.out.println("#"+tc + " ");
		}// end of tc
	}
}
