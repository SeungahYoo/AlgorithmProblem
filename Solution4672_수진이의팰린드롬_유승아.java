import java.io.BufferedReader;
import java.io.InputStreamReader;

//SWEA :: 4672 수진이의 팰린드롬
//2019-04-03
public class Solution4672_수진이의팰린드롬_유승아 {
	private static String str;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine().trim());

		for (int tc = 1; tc <= T; tc++) {
			str = br.readLine();

			int[] cnt = new int[26];
			
 			int ans = 0;
			for(int i=0;i<str.length();i++) {
				cnt[str.charAt(i)-'a']++;
			}
			
			for(int i=0;i<cnt.length;i++) {
				if(cnt[i]<=1) continue;
				for(int j=1;j<cnt[i];j++) {
					ans+=j;
				}
			}
			System.out.println("#"+tc+" "+(ans+str.length()));
		}//end of tc
	}//end of main
	
}
