import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;

public class Solution_1257 {
	public static void main(String[] args) throws Exception {
BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(bf.readLine());
		
		for(int tc = 1 ; tc<=T ; tc++) {
			int k = Integer.parseInt(bf.readLine());
			String str = bf.readLine();
			
			HashSet<String> hs = new HashSet<String>();
			
			
			//길이 : i
			//j부터 j+i까지
			for(int i=1;i<=str.length();i++) {
				for(int j=0;j<=str.length()-i;j++) {
					hs.add(str.substring(j, j+i));
				}
			}
			
			Object[] s=hs.toArray();
			Arrays.sort(s);
			
			System.out.println("#"+tc+" "+s[k-1]);
		
		}// end of tc
	}
}
