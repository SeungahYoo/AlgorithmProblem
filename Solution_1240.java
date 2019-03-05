import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_1240 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	static int[] ChangeDigit(String[] strCode) {
		int[] digitCode = new int[8];
		for(int i=0;i<8;i++) {
			String s = strCode[i];
			int d = -1;
			switch (s) {
			case "0001101": //0
				d=0;
				break;
			case "0011001": //1
				d=1;
				break;
			case "0010011": //2
				d=2;
				break;
			case "0111101": //3
				d=3;
				break;
			case "0100011": //4
				d=4;
				break;
			case "0110001": //5
				d=5;
				break;
			case "0101111": //6
				d=6;
				break;
			case "0111011": //7
				d=7;
				break;
			case "0110111": //8
				d=8;
				break;
			case "0001011": //9
				d=9;
				break;

			default:
				break;
			}
			digitCode[i] = d;
		}
			
		return digitCode;
	}
	
	static int CheckCode(int[] Code) {
		//코드 검정
		
		int evenSum=0;
		int oddSum=0;
		for(int i=0;i<7;i++) {
			if(i%2 == 0) evenSum+=Code[i];
			if(i%2 == 1) oddSum+=Code[i];
		}
		
		int x = evenSum*3 + oddSum + Code[7];
		
		if(x%10 == 0) return evenSum+oddSum+Code[7];
		else return 0;
	}
	
	public static void main(String[] args) throws Exception {
		int TC = Integer.parseInt(br.readLine()); //tc
		for(int tc = 1 ; tc<=TC ; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			String[] arr = new String[n];
			String[] strCode = new String[8];
			int flag = -1;
			for(int i=0;i<n;i++) {
				arr[i] = br.readLine();
				if(flag==-1 && arr[i].contains("1")) {
					flag = i;
				}
			}
			
			String str = arr[flag];
			for(int i=str.length()-1;i>0;i--) {
				if(str.charAt(i) == '1') {
					//7자리씩 추출
					String s = "";
					int cnt=0;
					int idx = 7;
					for(int j=i;j>=(i-56);j--) {
						s = str.charAt(j)+s;
						++cnt;
						if(cnt==7) {
							strCode[idx--] = s;
							s = "";
							cnt=0;
						}
					}
					
					int[] Code = ChangeDigit(strCode);
					int ans=CheckCode(Code);
					
					
					
					System.out.println("#"+tc+" "+ans);
					
					
					break;
				}
			}
			
		}//end of tc
	}//end of main
}
