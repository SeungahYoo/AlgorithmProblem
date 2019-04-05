import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//BOJ :: 1535 �ȳ�
//2019-03-25

public class Main1535_�ȳ� {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine()); // ��� �� 
		
		int[] L = new int[N]; //ü��
		int[] J = new int[N]; //���
		int[] dp = new int[100];
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		for(int i=0;i<N;i++) {//ü��
			L[i] = Integer.parseInt(st.nextToken());
		}
		
		st = new StringTokenizer(br.readLine(), " ");
		for(int i=0;i<N;i++) {//���
			J[i] = Integer.parseInt(st.nextToken());
			if(L[i]<100) dp[L[i]] = J[i];
		}
		
		
		int ans = 0;
	
		//��� max
		for(int i=0;i<N;i++) { //i�� ��� ��ȣ
			for(int j=0;j<N;j++) {
				if(i==j) continue;
				if(L[i]+L[j]<100) {
					dp[L[i]+L[j]] =dp[L[i]]+dp[L[j]]; 
					ans = ans < dp[L[i]+L[j]]? dp[L[i]+L[j]]:ans;
				}
			}
		}
		
		System.out.println(ans);
	}
}
