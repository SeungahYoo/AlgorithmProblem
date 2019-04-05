import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

//BOJ :: 1535 ¾È³ç
//2019-03-25

public class Main1535_¾È³ç_bruteforce {
	private static int N;
	private static int[] power;
	private static int[] happy;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine()); // »ç¶÷ ¼ö 
		
		power = new int[N]; //Ã¼·Â
		happy = new int[N]; //±â»Ý

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		for(int i=0;i<N;i++) {//Ã¼·Â
			power[i] = Integer.parseInt(st.nextToken());
		}
		
		st = new StringTokenizer(br.readLine(), " ");
		for(int i=0;i<N;i++) {//±â»Ý
			happy[i] = Integer.parseInt(st.nextToken());
		}
		
		ans = Integer.MIN_VALUE;
		for(int i=1;i<=N;i++) {
			set = new int[i];
			select(0,i,0);
		}
		if (ans == Integer.MIN_VALUE) {
			ans = 0;
		}
		System.out.println(ans);
	}
	static int[] set;
	static int ans;
	public static void select(int len,int size,int k) {
		if(len==size) {
			int happySum = 0;
			int powerSum = 100;
			for(int i=0;i<set.length;i++) {
				powerSum-=power[set[i]];
				if(powerSum <= 0) break;
				happySum+=happy[set[i]];
			}
			
			if(powerSum>0) {
				if(ans < happySum) {
					ans = happySum;
					//System.out.println(Arrays.toString(set));
				}
			}
		
			return;
		}
		
		for(int i=k;i<N;i++) {
			set[len]= i;
			select(len+1,size,i+1);
		}
	}
}
