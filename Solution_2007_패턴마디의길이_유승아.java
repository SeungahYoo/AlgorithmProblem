import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.Character.Subset;

public class Solution_2007_패턴마디의길이_유승아 {
	static String word;
	static boolean flag;
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(bf.readLine());
		

		for(int tc=1;tc<=T;tc++) {
			String input = bf.readLine();
			boolean[] check = new boolean[100];
			word="";
			flag = false;
			for(int i=0;i<input.length();i++) {
				char c = input.charAt(i);
				if(!check[c]) {
					check[c] = true;
					word+=c;
					

				} else {
					flag = false;
					solve(input.substring(word.length()));
					if(!flag) word+=c;
				}
				if(flag) break;

			}
			System.out.println("#"+tc+" "+word.length());
		}// end of tc
	}
	

	public static void solve(String str) {
		int len = word.length();
		if(str.length() < len ) {
			flag = true;
			return;
		}
		String comp = str.substring(0,len);
		if(word.equals(str.substring(0, len))) 
			solve(str.substring(len));
		
		else return;
		

	}
}