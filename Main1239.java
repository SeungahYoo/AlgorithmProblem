import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

//JUNGOL 1239 비밀편지
// 2019-03-19
public class Main1239 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] key = {"000000","001111","010011","011100","100110","101001","110101","111010"};
//		String A = "000000";
//		String B = "001111";
//		String C = "010011";
//		String D = "011100";
//		String E = "100110";
//		String F = "101001";
//		String G = "110101";
//		String H = "111010";
		
		int N = Integer.parseInt(br.readLine());
		String msg = br.readLine();
		
		ArrayList<Character> ans= new ArrayList<>();
		int ans2=N*6+1;
		for(int i=0;i<msg.length()-6+1;i+=6) {
			String tmp = msg.substring(i, i+6);
			boolean flag = false;
			for(int j=0;j<key.length;j++) {
				if(key[j].equals(tmp)) { // 아예 같은 경우
					ans.add((char) ('A'+j));
					flag = true;
					break;
				} else { //한문자만 다른 경우
					int dif = 0;
					for(int k=0;k<tmp.length();k++) {
						if(tmp.charAt(k)!=key[j].charAt(k)) {
							dif++;
						}
						if(dif>=2) break;
					}
					if(dif==1) {
						ans.add((char) ('A'+j));
						flag = true;
					}
				}
			} // 암호를 해독한 경우
			
			//해독하지 못한 경우
			if(!flag) {
				System.out.println(i/6+1);
				return;
			}
		}

		for(int i=0;i<ans.size();i++) {
			System.out.print(ans.get(i));
		}
	} // end of main
}
