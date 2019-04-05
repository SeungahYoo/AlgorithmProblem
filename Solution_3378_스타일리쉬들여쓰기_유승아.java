import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 1. R, C, S �� ���Ѵ�.
public class Solution_3378_��Ÿ�ϸ����鿩����_���¾� {
	private static String[] prr;
	private static String[] qrr;
	private static int[] result;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int p = Integer.parseInt(st.nextToken()); // ������
			int q = Integer.parseInt(st.nextToken()); // ��

			prr = new String[p]; // ������ �ڵ�
			qrr = new String[q]; // ��
			result = new int[q]; // ����� ��� ������ �迭
			Arrays.fill(result, -1); // �迭�� �ʱⰪ�� ������� �ʴ� ���ڷ� �ʱ�ȭ

			for (int i = 0; i < p; i++) {
				prr[i] = br.readLine();
			}
			for (int i = 0; i < q; i++) {
				qrr[i] = br.readLine();
			}

			for (int r = 1; r <= 20; r++) {
				for (int c = 1; r <= 20; c++) {
					for (int s = 1; s <= 20; s++) {
						if (pOK(r, c, s)) { // �������� ��� �ڵ��࿡ ������ ������ üũ
							qCheck(r, c, s);// ������ ��� �ڵ� �࿡�� �������� üũ �� �迭�� ����
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

	/* ������ ��� �ڵ� �࿡�� ������ �� üũ �� �迭�� ����. */
	private static void qCheck(int r, int c, int s) {
		int rr = 0;
		int cc = 0;
		int ss = 0;
		for(int i = 0; i < qrr.length; i++) {
			int dap = r * rr + c * cc + s * ss; // ����� ��
			
			if(result[i] == -2) // ó�� �����ϴ� ��Ȳ
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

	/* �������� ��� �ڵ��࿡ ������ ������ üũ */
	private static boolean pOK(int r, int c, int s) {
		int rr = 0; // () ����
		int cc = 0; // {} ����
		int ss = 0; // [] ����
		
		for(int i=0; i<prr.length; i++) {
			int dot = 0; // .�� ����
			String str = prr[i]; // ������ �ڵ��� �� ��
			int j = 0;
			
			// ���� ������ ī��Ʈ�ϴ� �ʹ�
			for(; j<str.length(); j++) {
				if(str.charAt(j) == '.') dot++;
				else break; // �ٸ� ���ڰ� ������ �������´�.
			}
			
			//�� ���ٱ����� ��ȣ���� (rr, cc, ss) �� �������� ���� ������ �ľ����ش�.
			if(r * rr + c * cc + s * ss != dot)
				return false;
			
			// . ���� ���ڵ� �������� �о��
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