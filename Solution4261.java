import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//SWEA :: 4261 빠른 휴대전화 키패드
//2019-04-04
public class Solution4261 {
	private static String[] words;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			String s = st.nextToken();
			int N = Integer.parseInt(st.nextToken());
			words = new String[N];
			st = new StringTokenizer(br.readLine(), " ");
			int ans = 0;
			for (int i = 0; i < N; i++) {
				words[i] = st.nextToken();
				if (words[i].length() != s.length())
					continue;
				boolean flag = true;
				for(int j=0;j<words[i].length();j++) {
					int num = getNumber(words[i].charAt(j));
					if(num!=s.charAt(j)) {
						flag= false;
						break;
					}
				}
				if(flag) ans++;
			}
			System.out.println("#" + tc + " "+ans);
		} // end of tc
	} // end of main

	public static char getNumber(char c) {
		if ('a' <= c && c <= 'c') {
			return '2';
		} else if ('d' <= c && c <= 'f') {
			return '3';
		} else if ('g' <= c && c <= 'i') {
			return '4';
		} else if ('j' <= c && c <= 'l') {
			return '5';
		} else if ('m' <= c && c <= 'o') {
			return '6';
		} else if ('p' <= c && c <= 's') {
			return '7';
		} else if ('t' <= c && c <= 'v') {
			return '8';
		} else if ('w' <= c && c <= 'z') {
			return '9';
		}
		return '0';
	}
}
