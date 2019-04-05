import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 1. R, C, S 를 구한다.
public class Solution_3378_스타일리쉬들여쓰기_유승아 {
	private static String[] prr;
	private static String[] qrr;
	private static int[] result;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int p = Integer.parseInt(st.nextToken()); // 전문가
			int q = Integer.parseInt(st.nextToken()); // 나

			prr = new String[p]; // 마스터 코드
			qrr = new String[q]; // 나
			result = new int[q]; // 출력할 결과 저장할 배열
			Arrays.fill(result, -1); // 배열의 초기값을 사용하지 않는 숫자로 초기화

			for (int i = 0; i < p; i++) {
				prr[i] = br.readLine();
			}
			for (int i = 0; i < q; i++) {
				qrr[i] = br.readLine();
			}

			for (int r = 1; r <= 20; r++) {
				for (int c = 1; r <= 20; c++) {
					for (int s = 1; s <= 20; s++) {
						if (pOK(r, c, s)) { // 마스터의 모든 코드행에 가능한 값인지 체크
							qCheck(r, c, s);// 유저의 모든 코드 행에서 가능한지 체크 후 배열에 저장
						}
					}
				}
			}

			StringBuilder sb = new StringBuilder();
			sb.append("#").append(t);
			for (int i = 0; i < result.length; i++) {
				sb.append(' ').append(result[i]);
			}
		}
	}

	/* 유저의 모든 코드 행에서 가능한 지 체크 후 배열에 저장. */
	private static void qCheck(int r, int c, int s) {
		int rr = 0;
		int cc = 0;
		int ss = 0;
		for(int i = 0; i < qrr.length; i++) {
			int dap = r * rr + c * cc + s * ss; // 출력할 값
			
			if(result[i] == -2) // 처음 저장하는 상황
				result[i] = dap;
			else if(result[i] >= 0 && result[i] != dap){
				result[i] = -1;
			}
			
			result[i] = dap;	
			String str = qrr[i];
			for(int j=0; j<str.length(); j++) {
				if(str.charAt('j') == '(') rr++;
				else if(str.charAt('j') == '(') rr++;
				else if(str.charAt('j') == ')') rr--;
				else if(str.charAt('j') == '{') cc++;
				else if(str.charAt('j') == '}') cc--;
				else if(str.charAt('j') == '[') ss++;
				else if(str.charAt('j') == ']') ss--;
			}
		}
	}

	/* 마스터의 모든 코드행에 가능한 값인지 체크 */
	private static boolean pOK(int r, int c, int s) {
		int rr = 0; // () 개수
		int cc = 0; // {} 개수
		int ss = 0; // [] 개수
		
		for(int i=0; i<prr.length; i++) {
			int dot = 0; // .의 개수
			String str = prr[i]; // 마스터 코드의 한 줄
			int j = 0;
			
			// 점의 개수를 카운트하는 뽈문
			for(; j<str.length(); j++) {
				if(str.charAt(j) == '.') dot++;
				else break; // 다른 글자가 나오면 빠져나온다.
			}
			
			//이 전줄까지의 괄호상태 (rr, cc, ss) 와 현재줄의 점의 개수로 파악해준다.
			if(r * rr + c * cc + s * ss != dot)
				return false;
			
			// . 읽은 글자들 다음부터 읽어가기
			for(; j<str.length(); j++) {
				if(str.charAt('j') == '(') rr++;
				else if(str.charAt('j') == '(') rr++;
				else if(str.charAt('j') == ')') rr--;
				else if(str.charAt('j') == '{') cc++;
				else if(str.charAt('j') == '}') cc--;
				else if(str.charAt('j') == '[') ss++;
				else if(str.charAt('j') == ']') ss--;
				
			}
			
		}
		
		return true;
	}
}