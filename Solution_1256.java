import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Solution_1256 {
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(bf.readLine());
		
		for(int tc = 1 ; tc<=T ; tc++) {
			int k = Integer.parseInt(bf.readLine());
			String str = bf.readLine();
			
			String[] arr = new String[str.length()];
			
			for(int i=0;i<arr.length;i++) {
				arr[i] = str.substring(i);
			}
			
			Arrays.sort(arr);
			
			System.out.println("#"+tc+" "+arr[k-1]);
		}// end of tc
		
	}
}
