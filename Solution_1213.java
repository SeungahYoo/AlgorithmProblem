import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution_1213 {
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		String find;
		String str;
		for(int tc=1;tc<=10;tc++) {
			String T = bf.readLine();
			
			find = bf.readLine();
			str = bf.readLine();
			
			int ans = 0;
			if(str.contains(find)) {
				int len = find.length();
				for(int i=0;i<=str.length()-len;i++) {
					String sub = str.substring(i,i+len);
					if(sub.equals(find)) {
						ans++;
						i+=len;
					}
				}
				
			}
			System.out.println("#"+tc+" "+ans);
			
		}//end of tc
	}
}
