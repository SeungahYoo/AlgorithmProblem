import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution_3750 {
	//Digit sum
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(bf.readLine());
		
		for(int tc=1;tc<=T;tc++) {
			
			String n = bf.readLine();
			
			
			
			System.out.println("#"+tc+" "+f(n));
		}// end of tc
	}

	public static String f(String x) {
		if(x.length()==1) {
			return x;
		}
		int sum=0;
		for(int i=0;i<x.length();i++) {
			String s = ""+x.charAt(i);
			sum+=Integer.parseInt(s);
		}
		return f(""+sum);
		
		

	}
}
