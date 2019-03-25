import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_3143_가장빠른문자열타이핑_유승아 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine().trim());
		for(int tc=1;tc<=T;tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			String A = st.nextToken();
			String B = st.nextToken();
			
			boolean[] visit = new boolean[A.length()];
			int push = 0;
			for(int i=0;i<A.length()-B.length()+1;i++) {
				if(visit[i]) continue;
				
				String tmp = A.substring(i, i+B.length());
				if(tmp.equals(B)) {
					push++;
					for(int j=i;j<i+B.length();j++) {
						visit[j] = true;
					}
				} else {
					visit[i] = true;
					push++;
				}
			}
			
			for(int i=0;i<A.length();i++) {
				if(!visit[i]) push++;
			}
			
			System.out.println("#"+tc+" "+push);
		} //ed of TC
	}
}
